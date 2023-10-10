package org.davshaw.Controller;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Date;

import javax.security.auth.login.AccountNotFoundException;

import org.davshaw.Exception.NegativeAmountException;
import org.davshaw.Exception.RecordNotFoundException;
import org.davshaw.External.ResultPack;
import org.davshaw.Model.derivatedentities.AccountDeposit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AccountDepositController
{
    public static ResultPack<Boolean> deposit(int ownerDni, double balance)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(AccountDeposit.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Checking account exits
            if(!(AccountController.accountExist(ownerDni).getResult()))
            {
                throw new AccountNotFoundException();
            }

            if(balance < 0 )
            {
                throw new NegativeAmountException();
            }
            
            session.beginTransaction();

            //Making deposit
            AccountController.addBalance(ownerDni, balance);

            //Registering deposit
            AccountDeposit accountDeposit = new AccountDeposit();
            accountDeposit.setAccountId(AccountController.getAccountNumber(ownerDni).getResult());
            accountDeposit.setDateTime(new Date());
            accountDeposit.setBalance(balance);

            //Saving registered deposit
            session.persist(accountDeposit);

            session.getTransaction().commit();

            return new ResultPack<Boolean>(true, true, "The deposit has been done.");
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new ResultPack<Boolean>(true, true, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }
    
    public static ResultPack<Boolean> depositExist(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(AccountDeposit.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            String sql = "SELECT count(*) FROM AccountDeposit WHERE id = :id";
            Query<Long> query = session.createNativeQuery(sql, Long.class);
            query.setParameter("id", id);
            int count = ((Number) query.uniqueResult()).intValue();

            if (count > 0)
            {
                return new ResultPack<Boolean>(true, true, "Deposit found.");
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

    public static ResultPack<AccountDeposit> getDeposit(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(AccountDeposit.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Checking deposit exists
            if(!(AccountDepositController.depositExist(id)).getResult())
            {
                throw new RecordNotFoundException();
            }

            session.beginTransaction();

            AccountDeposit deposit = session.get(AccountDeposit.class, id);

            session.getTransaction().commit();

            return new ResultPack<AccountDeposit>(true, deposit, "Deposit found.");
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new ResultPack<AccountDeposit>(false, null, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static ResultPack<Boolean> deleteDeposit(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(AccountDeposit.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Checking deposit exists
            if(!(AccountDepositController.depositExist(id).getResult()))
            {
                throw new RecordNotFoundException();
            }

            session.beginTransaction();

            AccountDeposit deposit = AccountDepositController.getDeposit(id).getResult();
            session.remove(deposit);

            session.getTransaction().commit();

            return new ResultPack<Boolean>(true, null, "The deposit has been deleted.");
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