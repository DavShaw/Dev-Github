package org.davshaw.Controller;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Date;

import org.davshaw.Exception.AccountNotFoundException;
import org.davshaw.Exception.InsufficientBalanceException;
import org.davshaw.Exception.RecordNotFoundException;
import org.davshaw.Model.derivatedentities.AccountDeposit;
import org.davshaw.Model.derivatedentities.AccountWithdrawal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AccountWithdrawController
{
    public static Boolean withdraw(int ownerDni, double balance)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(AccountDeposit.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar si existe una cuenta asociada a este dni
            if(!(AccountController.accountExist(ownerDni)))
            {
                throw new AccountNotFoundException();
            }
            //Verificar que el balance de la cuenta sea mayor o igual al balance a retirar
            if(!(AccountController.getBalance(ownerDni) >= balance))
            {
                throw new InsufficientBalanceException();
            }

            //Si ninguna de las anteriores se lanzó, podemos hacer el retiro
            else
            {
                session.beginTransaction();

                AccountController.withdrawBalance(ownerDni, balance);
                //Crear registro del retiro
                AccountWithdrawal retiro = new AccountWithdrawal();
                retiro.setDateTime(new Date());
                retiro.setBalance(balance);
                retiro.setAccountNumber(AccountController.getAccountNumber(ownerDni));

                session.persist(retiro);
                session.getTransaction().commit();
                return true;
            }
            

        }

        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static Boolean withdrawExist(int id)
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

            return count > 0;
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static AccountWithdrawal getWithdrawal(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(AccountWithdrawal.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista el registro del deposito
            if(!(AccountWithdrawController.withdrawExist(id)))
            {
                throw new RecordNotFoundException();
            }

            else
            {
                session.beginTransaction();

                AccountWithdrawal retiro = session.get(AccountWithdrawal.class, id);

                session.getTransaction().commit();

                return retiro;
            }
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    } 

    public static Boolean deleteWithdrawal(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(AccountWithdrawal.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista el registro del deposito
            if(!(AccountWithdrawController.withdrawExist(id)))
            {
                throw new RecordNotFoundException();
            }

            else
            {
                session.beginTransaction();

                AccountWithdrawal retiro = AccountWithdrawController.getWithdrawal(id);
                
                session.remove(retiro);
                
                session.getTransaction().commit();

                return true;
            }
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    } 
}