package org.davshaw.Controller;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Date;

import org.davshaw.Exception.AccountNotFoundException;
import org.davshaw.Exception.InsufficientBalanceException;
import org.davshaw.Exception.NegativeAmountException;
import org.davshaw.Exception.RecordNotFoundException;
import org.davshaw.External.ResultPack;
import org.davshaw.Model.derivatedentities.AccountDeposit;
import org.davshaw.Model.derivatedentities.AccountWithdrawal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AccountWithdrawController
{
    public static ResultPack<Boolean> withdraw(int ownerDni, double balance)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(AccountDeposit.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Checking account exists
            if(!(AccountController.accountExist(ownerDni).getResult()))
            {
                throw new AccountNotFoundException();
            }
            //Checking account has enough balance
            if(!(AccountController.hasEnough(ownerDni, balance).getResult()))
            {
                throw new InsufficientBalanceException();
            }

            if(balance < 0)
            {
                throw new NegativeAmountException();
            }
            
            session.beginTransaction();

            AccountController.withdrawBalance(ownerDni, balance);
            //Registering withdraw
            AccountWithdrawal withdraw = new AccountWithdrawal();
            withdraw.setDateTime(new Date());
            withdraw.setBalance(balance);
            withdraw.setAccountNumber(AccountController.getAccountNumber(ownerDni).getResult());

            session.persist(withdraw);
            session.getTransaction().commit();
            return new ResultPack<Boolean>(true, null, "The withdraw has been done successfully.");
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new ResultPack<Boolean>(false, null, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static ResultPack<Boolean> withdrawExist(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(AccountWithdrawal.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            String sql = "SELECT count(*) FROM AccountWithdrawal WHERE id = :id";
            Query<Long> query = session.createNativeQuery(sql, Long.class);
            query.setParameter("id", id);
            int count = ((Number) query.uniqueResult()).intValue();

            if (count > 0)
            {
                return new ResultPack<Boolean>(true, true, "Withdraw found.");
            }

            else
            {
                return new ResultPack<Boolean>(true, false, new RecordNotFoundException().getMessage());
            }
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new ResultPack<Boolean>(false, false, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static ResultPack<AccountWithdrawal> getWithdrawal(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(AccountWithdrawal.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Checking withdraw exists
            if(!(AccountWithdrawController.withdrawExist(id).getResult()))
            {
                throw new RecordNotFoundException();
            }

            session.beginTransaction();

            AccountWithdrawal withdraw = session.get(AccountWithdrawal.class, id);

            session.getTransaction().commit();

            return new ResultPack<AccountWithdrawal>(true, withdraw, "Withdraw found.");
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new ResultPack<AccountWithdrawal>(false, null, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    } 

    public static ResultPack<Boolean> deleteWithdrawal(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(AccountWithdrawal.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Checking withdraw exists
            if(!(AccountWithdrawController.withdrawExist(id).getResult()))
            {
                throw new RecordNotFoundException();
            }
            session.beginTransaction();

            AccountWithdrawal withdraw = AccountWithdrawController.getWithdrawal(id).getResult();

            session.remove(withdraw);

            session.getTransaction().commit();

            return new ResultPack<Boolean>(true, null, "withdraw found.");
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new ResultPack<Boolean>(false, null, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    } 
}