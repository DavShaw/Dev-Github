package org.davshaw.Controller;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.davshaw.External.Color;
import org.davshaw.Model.pureentities.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AccountController
{
    public static String createAccount(int ownerDni)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Account.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que no exista otra cuenta con el titularDni igual
            if(!AccountController.accountExist(ownerDni))
            {
                Account cuenta = new Account();

                //Establecer datos con setters (Reemplazando el constructor)
                cuenta.setOwnerDni(ownerDni);

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
    
    public static Boolean accountExist(int ownerDni)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Account.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            String sql = "SELECT count(*) FROM account WHERE ownerDni = :ownerDni";
            Query<Long> query = session.createNativeQuery(sql, Long.class);
            query.setParameter("ownerDni", ownerDni);
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

    public static Integer getAccountNumber(int ownerDni)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Account.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            String sql = "SELECT accountNumber FROM account WHERE ownerDni = :ownerDni LIMIT 1;";
            Query<Long> query = session.createNativeQuery(sql, Long.class);
            query.setParameter("ownerDni", ownerDni);
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

    public static Account getAccount(int ownerDni)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Account.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar si existe cuenta con titularDni
            if(AccountController.accountExist(ownerDni))
            {
                session.beginTransaction();

                Account cuenta = session.get(Account.class, AccountController.getAccountNumber(ownerDni));

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

    public static String addBalance(int ownerDni, double balance)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Account.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            if (balance < 0)
            {
                throw new IllegalArgumentException("El monto no puede ser negativo");
            }

            else if(AccountController.accountExist(ownerDni))
            {
                session.beginTransaction();

                Account cuenta = session.get(Account.class, AccountController.getAccountNumber(ownerDni));

                //Obtener saldo actual
                double nuevoSaldo = cuenta.getBalance() + balance;
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

    public static String withdrawalBalance(int ownerDni, double balance)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Account.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            if (balance < 0)
            {
                throw new IllegalArgumentException("El monto no puede ser negativo");
            }

            else if(AccountController.accountExist(ownerDni))
            {
                session.beginTransaction();

                Account cuenta = session.get(Account.class, AccountController.getAccountNumber(ownerDni));

                //Obtener saldo actual
                double nuevoSaldo = cuenta.getBalance() - balance;
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

    public static Double getBalance(int ownerDni)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Account.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            if(AccountController.accountExist(ownerDni))
            {
                Account cuenta = AccountController.getAccount(ownerDni);
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

    public static String deleteAccount(int ownerDni)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Account.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            if(AccountController.accountExist(ownerDni))
            {
                session.beginTransaction();

                Account cuenta = session.get(Account.class, AccountController.getAccount(ownerDni));

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

    public static Boolean hasEnough(int ownerDni, double balance)
    {
        return AccountController.getBalance(ownerDni) >= balance;
    }
}