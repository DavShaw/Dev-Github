package org.davshaw.Controller;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.davshaw.External.Color;
import org.davshaw.Model.pureentities.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AccountController
{
    public static String createAccount(int dni)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Account.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que no exista otra cuenta con el titularDni igual
            if(!AccountController.accountExist(dni))
            {
                Account cuenta = new Account();

                //Establecer datos con setters (Reemplazando el constructor)
                cuenta.setOwnerDni(dni);

                session.beginTransaction();
                session.persist(cuenta);
                session.getTransaction().commit();
                return "Cuenta creada con éxito.";
            }

            else
            {
                throw new IllegalArgumentException("Ya existe una cuenta asociada a este usuario.");
            }
            

        }

        catch (IllegalArgumentException e)
        {
            System.err.println(Color.color("RED", e.getMessage()));
    e.printStackTrace();
            return "Error al crear cuenta.";
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return "Error al crear cuenta.";
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }
    
    public static Boolean accountExist(int titularDni)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Account.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            String sql = "SELECT count(*) FROM Cuenta WHERE titularDni = :titularDni";
            Query<Long> query = session.createNativeQuery(sql, Long.class);
            query.setParameter("titularDni", titularDni);
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

    public static Integer getAccountNumber(int titularDni)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Account.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            String sql = "SELECT numeroCuenta FROM Cuenta WHERE titularDni = :titularDni LIMIT 1;";
            Query<Long> query = session.createNativeQuery(sql, Long.class);
            query.setParameter("titularDni", titularDni);
            int numeroCuenta = ((Number) query.uniqueResult()).intValue();

            return numeroCuenta;
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

    public static Account getAccount(int titularDni)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Account.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar si existe cuenta con titularDni
            if(AccountController.accountExist(titularDni))
            {
                session.beginTransaction();

                Account cuenta = session.get(Account.class, AccountController.getAccountNumber(titularDni));

                session.getTransaction().commit();
                return cuenta;
            }
            else
            {
                throw new IllegalArgumentException("No existe una cuenta asociada a este titular.");
            }
        }

        catch (IllegalArgumentException e)
        {
            System.err.println(Color.color("RED", e.getMessage()));
    e.printStackTrace();
            return null;
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

    public static String addBalance(int titularDni, double monto)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Account.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            if (monto < 0)
            {
                throw new IllegalArgumentException("El monto no puede ser negativo");
            }

            else if(AccountController.accountExist(titularDni))
            {
                session.beginTransaction();

                Account cuenta = session.get(Account.class, AccountController.getAccountNumber(titularDni));

                //Obtener saldo actual
                double nuevoSaldo = cuenta.getBalance() + monto;
                cuenta.setBalance(nuevoSaldo);

                session.merge(cuenta);

                session.getTransaction().commit();

                return "Saldo añadido con éxito.";
            }
            
            else
            {
                throw new IllegalArgumentException("No existe una cuenta asociada a este titular.");
            }
        }

        catch (IllegalArgumentException e)
        {
            System.err.println(Color.color("RED", e.getMessage()));
    e.printStackTrace();
            return "Error al agregar saldo.";
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return "Error al agregar saldo.";
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static String withdrawalBalance(int titularDni, double monto)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Account.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            if (monto < 0)
            {
                throw new IllegalArgumentException("El monto no puede ser negativo");
            }

            else if(AccountController.accountExist(titularDni))
            {
                session.beginTransaction();

                Account cuenta = session.get(Account.class, AccountController.getAccountNumber(titularDni));

                //Obtener saldo actual
                double nuevoSaldo = cuenta.getBalance() - monto;
                cuenta.setBalance(nuevoSaldo);

                session.merge(cuenta);

                session.getTransaction().commit();

                return "Saldo retirado con éxito.";
            }
            
            else
            {
                throw new IllegalArgumentException("No existe una cuenta asociada a este titular.");
            }
        }

        catch (IllegalArgumentException e)
        {
            System.err.println(Color.color("RED", e.getMessage()));
    e.printStackTrace();
            return "Error al retirar saldo.";
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return "Error al retirar saldo.";
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static Double getBalance(int titularDni)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Account.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            if(AccountController.accountExist(titularDni))
            {
                Account cuenta = AccountController.getAccount(titularDni);
                return cuenta.getBalance();
            }
            
            else
            {
                throw new IllegalArgumentException("No existe una cuenta asociada a este titular.");
            }
        }

        catch (IllegalArgumentException e)
        {
            System.err.println(Color.color("RED", e.getMessage()));
    e.printStackTrace();
            return null;
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

    public static String deleteAccount(int titularDni)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Account.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            if(AccountController.accountExist(titularDni))
            {
                session.beginTransaction();

                Account cuenta = session.get(Account.class, AccountController.getAccount(titularDni));

                session.remove(cuenta);

                session.getTransaction().commit();

                return "Cuenta eliminada con éxito.";
            }
            
            else
            {
                throw new IllegalArgumentException("No existe una cuenta asociada a este titular.");
            }
        }

        catch (IllegalArgumentException e)
        {
            System.err.println(Color.color("RED", e.getMessage()));
    e.printStackTrace();
            return "Error al eliminar cuenta.";
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return "Error al eliminar cuenta.";
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static Boolean hasEnough(int titularDni, double monto)
    {
        return AccountController.getBalance(titularDni) >= monto;
    }
}