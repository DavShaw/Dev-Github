package org.davshaw.Controller;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Date;

import org.davshaw.Exception.AccountNotFoundException;
import org.davshaw.Exception.InsufficientBalanceException;
import org.davshaw.Exception.RecordNotFoundException;
import org.davshaw.External.RequestResult;
import org.davshaw.Model.derivatedentities.AccountDeposit;
import org.davshaw.Model.derivatedentities.AccountWithdrawal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AccountWithdrawController
{
    public static RequestResult<Boolean> withdraw(int ownerDni, double balance)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(AccountDeposit.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar si existe una cuenta asociada a este dni
            if(!(AccountController.accountExist(ownerDni).getResult()))
            {
                throw new AccountNotFoundException();
            }
            //Verificar que el balance de la cuenta sea mayor o igual al balance a retirar
            if(!(AccountController.getBalance(ownerDni).getResult() >= balance))
            {
                throw new InsufficientBalanceException();
            }
            session.beginTransaction();

            AccountController.withdrawBalance(ownerDni, balance);
            //Crear registro del retiro
            AccountWithdrawal retiro = new AccountWithdrawal();
            retiro.setDateTime(new Date());
            retiro.setBalance(balance);
            retiro.setAccountNumber(AccountController.getAccountNumber(ownerDni).getResult());

            session.persist(retiro);
            session.getTransaction().commit();
            return new RequestResult<Boolean>(true, null, "The withdraw has been done successfully.");
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

    public static RequestResult<Boolean> withdrawExist(int id)
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
                return new RequestResult<Boolean>(true, true, "Withdraw found.");
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

    public static RequestResult<AccountWithdrawal> getWithdrawal(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(AccountWithdrawal.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista el registro del deposito
            if(!(AccountWithdrawController.withdrawExist(id).getResult()))
            {
                throw new RecordNotFoundException();
            }

            session.beginTransaction();

            AccountWithdrawal retiro = session.get(AccountWithdrawal.class, id);

            session.getTransaction().commit();

            return new RequestResult<AccountWithdrawal>(true, retiro, "Withdraw found.");
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new RequestResult<AccountWithdrawal>(false, null, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    } 

    public static RequestResult<Boolean> deleteWithdrawal(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(AccountWithdrawal.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista el registro del deposito
            if(!(AccountWithdrawController.withdrawExist(id).getResult()))
            {
                throw new RecordNotFoundException();
            }
            session.beginTransaction();

            AccountWithdrawal retiro = AccountWithdrawController.getWithdrawal(id).getResult();

            session.remove(retiro);

            session.getTransaction().commit();

            return new RequestResult<Boolean>(true, null, "Witdraw found.");
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