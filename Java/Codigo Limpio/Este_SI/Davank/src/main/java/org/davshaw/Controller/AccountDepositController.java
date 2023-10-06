package org.davshaw.Controller;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Date;

import javax.security.auth.login.AccountNotFoundException;

import org.davshaw.Exception.RecordNotFoundException;
import org.davshaw.External.RequestResult;
import org.davshaw.Model.derivatedentities.AccountDeposit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AccountDepositController
{
    public static RequestResult<Boolean> deposit(int ownerDni, double balance)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(AccountDeposit.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que la cuenta exista
            if(!(AccountController.accountExist(ownerDni).getResult()))
            {
                throw new AccountNotFoundException();
            }
            //Sino se lanzan las exceptions, entonces se procede
            session.beginTransaction();

            //Haciendo el deposito
            AccountController.addBalance(ownerDni, balance);

            //Haciendo el registro del deposito
            AccountDeposit depositoCuenta = new AccountDeposit();
            depositoCuenta.setAccountId(AccountController.getAccountNumber(ownerDni).getResult());
            depositoCuenta.setDateTime(new Date());
            depositoCuenta.setBalance(balance);

            //Guardando el registro del deposito
            session.persist(depositoCuenta);

            session.getTransaction().commit();

            return new RequestResult<Boolean>(true, true, "The deposit has been done.");
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new RequestResult<Boolean>(true, true, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }
    
    public static RequestResult<Boolean> depositExist(int id)
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
                return new RequestResult<Boolean>(true, true, "Deposit found.");
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

    public static RequestResult<AccountDeposit> getDeposit(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(AccountDeposit.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista el registro del deposito
            if(!(AccountDepositController.depositExist(id)).getResult())
            {
                throw new RecordNotFoundException();
            }

            session.beginTransaction();

            AccountDeposit deposito = session.get(AccountDeposit.class, id);

            session.getTransaction().commit();

            return new RequestResult<AccountDeposit>(true, deposito, "Deposit found.");
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new RequestResult<AccountDeposit>(false, null, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static RequestResult<Boolean> deleteDeposit(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(AccountDeposit.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista el registro del deposito
            if(!(AccountDepositController.depositExist(id).getResult()))
            {
                throw new RecordNotFoundException();
            }

            session.beginTransaction();

            AccountDeposit deposito = AccountDepositController.getDeposit(id).getResult();
            session.remove(deposito);

            session.getTransaction().commit();

            return new RequestResult<Boolean>(true, null, "The deposit has been deleted.");
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