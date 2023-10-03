package org.davshaw.Controller;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Date;

import org.davshaw.Model.derivatedentities.AccountDeposit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AccountDepositController
{
    public static Boolean hacerDeposito(int titularDniCuenta, double monto)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(AccountDeposit.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que la cuenta exista
            if(!(AccountController.existeCuenta(titularDniCuenta)))
            {
                throw new IllegalArgumentException("La cuenta no existen.");
            }
            //Sino se lanzan las exceptions, entonces se procede
            session.beginTransaction();

            //Haciendo el deposito
            AccountController.agregarSaldo(titularDniCuenta, monto);

            //Haciendo el registro del deposito
            AccountDeposit depositoCuenta = new AccountDeposit();
            depositoCuenta.setAccountId(AccountController.obtenerNumeroCuenta(titularDniCuenta));
            depositoCuenta.setDateTime(new Date());
            depositoCuenta.setBalance(monto);

            //Guardando el registro del deposito
            session.persist(depositoCuenta);

            session.getTransaction().commit();
            return true;
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
    
    public static Boolean existeDeposito(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(AccountDeposit.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            String sql = "SELECT count(*) FROM DepositoCuenta WHERE id = :id";
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

    public static AccountDeposit obtenerDeposito(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(AccountDeposit.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista el registro del deposito
            if(!(AccountDepositController.existeDeposito(id)))
            {
                throw new IllegalArgumentException("No existe un deposito registrado con este id.");
            }

            else
            {
                session.beginTransaction();

                AccountDeposit deposito = session.get(AccountDeposit.class, id);

                session.getTransaction().commit();

                return deposito;
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

    public static Boolean eliminarDeposito (int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(AccountDeposit.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista el registro del deposito
            if(!(AccountDepositController.existeDeposito(id)))
            {
                throw new IllegalArgumentException("No existe un deposito registrado con este id.");
            }

            else
            {
                session.beginTransaction();

                AccountDeposit deposito = AccountDepositController.obtenerDeposito(id);
                session.remove(deposito);

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