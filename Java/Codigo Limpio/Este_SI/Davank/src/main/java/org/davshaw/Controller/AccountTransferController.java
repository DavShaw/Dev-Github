package org.davshaw.Controller;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Date;

import org.davshaw.Exception.AccountNotFoundException;
import org.davshaw.Exception.InsufficientBalanceException;
import org.davshaw.Exception.RecordNotFoundException;
import org.davshaw.Model.derivatedentities.AccountTransfer;
import org.davshaw.External.RequestResult;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AccountTransferController
{
    public static RequestResult<Boolean> transfer(int originOwnerDni, int destinationOwnerDni, double balance)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(AccountTransfer.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Checking account exists (Origin)
            if(!(AccountController.accountExist(originOwnerDni).getResult()))
            {
                throw new AccountNotFoundException();
            }

            //Checking account exists (Destination)
            if(!(AccountController.accountExist(destinationOwnerDni).getResult()))
            {
                throw new AccountNotFoundException();
            }

            //Checking account has enough balance to make transfer
            if (!(AccountController.hasEnough(originOwnerDni, balance).getResult()))
            {
                throw new InsufficientBalanceException();
            }

            session.beginTransaction();

            //Withdraw balance from origin account
            AccountController.withdrawBalance(originOwnerDni, balance);
            //Deposit balance to destination account
            AccountController.addBalance(destinationOwnerDni, balance);

            //Registering transfer
            AccountTransfer transfer = new AccountTransfer();
            transfer.setDateTime(new Date());
            transfer.setBalance(balance);

            Integer originAccount = AccountController.getAccountNumber(originOwnerDni).getResult();
            Integer destinationAccount = AccountController.getAccountNumber(destinationOwnerDni).getResult();

            transfer.setOriginAccountNumber(originAccount);
            transfer.setDestinationAccountNumber(destinationAccount);

            session.persist(transfer);

            session.getTransaction().commit();
            

            return new RequestResult<Boolean>(true, null, "The transfer has been done.");
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new RequestResult<Boolean>(false, null, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static RequestResult<Boolean> transferExist(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(AccountTransfer.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            String sql = "SELECT count(*) FROM AccountTransfer WHERE id = :id";
            Query<Long> query = session.createQuery(sql, Long.class);
            query.setParameter("id", id);
            int count = Integer.valueOf(query.uniqueResult().toString());

            if (count > 0)
            {
                return new RequestResult<Boolean>(true, true, "Transfer found.");
            }

            else
            {
                return new RequestResult<Boolean>(true, false, new RecordNotFoundException().getMessage());
            }
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new RequestResult<Boolean>(false, false, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static RequestResult<AccountTransfer> getTransfer(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(AccountTransfer.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            if(!(AccountTransferController.transferExist(id).getResult()))
            {
                throw new RecordNotFoundException();
            }

            session.beginTransaction();
            AccountTransfer transfer = session.get(AccountTransfer.class, id);
            session.getTransaction().commit();

            return new RequestResult<AccountTransfer>(true, transfer, "Transfer found.");

        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new RequestResult<AccountTransfer>(false, null, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static RequestResult<Boolean> deleteTransfer(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(AccountTransfer.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Checking if transfer exists
            if(!(AccountTransferController.transferExist(id).getResult()))
            {
                throw new RecordNotFoundException();
            }

            session.beginTransaction();

            AccountTransfer transfer = AccountTransferController.getTransfer(id).getResult();

            session.remove(transfer);
            session.getTransaction().commit();

            return new RequestResult<Boolean>(true, null, "The transfer has been deleted successfully.");
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new RequestResult<Boolean>(false, null, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }
}