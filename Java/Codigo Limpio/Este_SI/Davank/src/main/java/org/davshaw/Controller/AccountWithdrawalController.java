package org.davshaw.Controller;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Date;

import org.davshaw.Model.derivatedentities.AccountDeposit;
import org.davshaw.Model.derivatedentities.AccountWithdrawal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AccountWithdrawalController
{
    public static Boolean hacerRetiro(int titularDniCuenta, double monto)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(AccountDeposit.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar si existe una cuenta asociada a este dni
            if(!(AccountController.existeCuenta(titularDniCuenta)))
            {
                throw new IllegalArgumentException("No existe una cuenta asociada a este dni.");
            }
            //Verificar que el monto de la cuenta sea mayor o igual al monto a retirar
            if(!(AccountController.obtenerSaldo(titularDniCuenta) >= monto))
            {
                throw new IllegalArgumentException("El monto a retirar supera el saldo de la cuenta.");
            }

            //Si ninguna de las anteriores se lanzó, podemos hacer el retiro
            else
            {
                session.beginTransaction();

                AccountController.retirarSaldo(titularDniCuenta, monto);
                //Crear registro del retiro
                AccountWithdrawal retiro = new AccountWithdrawal();
                retiro.setDateTime(new Date());
                retiro.setBalance(monto);
                retiro.setAccountNumber(AccountController.obtenerNumeroCuenta(titularDniCuenta));

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

    public static Boolean existeRetiro(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(AccountWithdrawal.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            String sql = "SELECT count(*) FROM RetiroCuenta WHERE id = :id";
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

    public static AccountWithdrawal obtenerRetiro(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(AccountWithdrawal.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista el registro del deposito
            if(!(AccountWithdrawalController.existeRetiro(id)))
            {
                throw new IllegalArgumentException("No existe un retiro registrado con este id.");
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

    public static Boolean eliminarRetiro(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(AccountWithdrawal.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista el registro del deposito
            if(!(AccountWithdrawalController.existeRetiro(id)))
            {
                throw new IllegalArgumentException("No existe un retiro registrado con este id.");
            }

            else
            {
                session.beginTransaction();

                AccountWithdrawal retiro = AccountWithdrawalController.obtenerRetiro(id);
                
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