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
            //Verificar si la cuenta origen existe
            if(!(AccountController.accountExist(originOwnerDni).getResult()))
            {
                throw new AccountNotFoundException();
            }

            //Verificar si cuenta destino existe
            if(!(AccountController.accountExist(destinationOwnerDni).getResult()))
            {
                throw new AccountNotFoundException();
            }

            //Verificar si la cuenta de origen tiene el saldo suficiente para realizar la transferencia
            if (AccountController.getBalance(originOwnerDni).getResult() < balance)
            {
                throw new InsufficientBalanceException();
            }

            session.beginTransaction();

            //Retirar dinero de la cuenta de origen
            AccountController.withdrawBalance(originOwnerDni, balance);
            //Agregar dinero a la cuenta de destino
            AccountController.addBalance(destinationOwnerDni, balance);

            //Iniciar creación del registro de la transferencia
            AccountTransfer transferencia = new AccountTransfer();
            transferencia.setDateTime(new Date());
            transferencia.setBalance(balance);

            Integer originAccount = AccountController.getAccountNumber(originOwnerDni).getResult();
            Integer destinationAccount = AccountController.getAccountNumber(destinationOwnerDni).getResult();

            transferencia.setOriginAccountNumber(originAccount);
            transferencia.setDestinationAccountNumber(destinationAccount);

            session.persist(transferencia);

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
            AccountTransfer transferencia = session.get(AccountTransfer.class, id);
            session.getTransaction().commit();

            return new RequestResult<AccountTransfer>(true, transferencia, "Transfer found.");

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
            //Verificar si existe
            if(!(AccountTransferController.transferExist(id).getResult()))
            {
                throw new RecordNotFoundException();
            }

            session.beginTransaction();

            AccountTransfer transferencia = AccountTransferController.getTransfer(id).getResult();

            session.remove(transferencia);
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