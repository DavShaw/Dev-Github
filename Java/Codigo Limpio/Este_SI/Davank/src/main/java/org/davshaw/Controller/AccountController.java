package org.davshaw.Controller;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.davshaw.Exception.AccountNotFoundException;
import org.davshaw.Exception.AccountOwnerNotFoundException;
import org.davshaw.Exception.DuplicateAccountOwnerException;
import org.davshaw.Exception.NegativeAmountException;
import org.davshaw.External.Color;
import org.davshaw.External.RequestResult;
import org.davshaw.Model.pureentities.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AccountController
{
    public static RequestResult<Boolean> createAccount(int ownerDni)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Account.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Checking account exist
            if(!AccountController.accountExist(ownerDni).getResult())
            {
                Account cuenta = new Account();

                //Setting data
                cuenta.setOwnerDni(ownerDni);

                session.beginTransaction();
                session.persist(cuenta);
                session.getTransaction().commit();
                
                return new RequestResult<Boolean>(true, null, "Account created successfully.");
            }

            else
            {
                throw new DuplicateAccountOwnerException();
            }
            

        }

        catch (IllegalArgumentException e)
        {
            System.err.println(Color.color("RED", e.getMessage()));
            e.printStackTrace();
            return new RequestResult<Boolean>(false, null, e.getMessage());
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
    
    public static RequestResult<Boolean> accountExist(int ownerDni)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Account.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            String sql = "SELECT count(*) FROM Account WHERE ownerDni = :ownerDni";
            Query<Long> query = session.createNativeQuery(sql, Long.class);
            query.setParameter("ownerDni", ownerDni);
            int count = ((Number) query.uniqueResult()).intValue();
            
            if (count > 0)
            {
                return new RequestResult<Boolean>(true, true, "Account found.");
            }

            else
            {
                return new RequestResult<Boolean>(true, false, new AccountNotFoundException().getMessage());
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

    public static RequestResult<Integer> getAccountNumber(int ownerDni)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Account.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            String sql = "SELECT accountNumber FROM Account WHERE ownerDni = :ownerDni";
            Query<Long> query = session.createNativeQuery(sql, Long.class);
            query.setParameter("ownerDni", ownerDni);
            Integer numeroCuenta = ((Number) query.uniqueResult()).intValue();

            return new RequestResult<Integer>(true, numeroCuenta, "Account number found.");
            
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new RequestResult<Integer>(false, null, "Account number not found.");
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static RequestResult<Account> getAccount(int ownerDni)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Account.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar si existe cuenta con titularDni
            if(AccountController.accountExist(ownerDni).getResult())
            {
                session.beginTransaction();

                Account cuenta = session.get(Account.class, AccountController.getAccountNumber(ownerDni));

                session.getTransaction().commit();
                
                return new RequestResult<Account>(true, cuenta, "Account found.");
            }
            else
            {
                throw new AccountOwnerNotFoundException();
            }
        }

        catch (IllegalArgumentException e)
        {
            System.err.println(Color.color("RED", e.getMessage()));
            e.printStackTrace();
            return new RequestResult<Account>(false, null, "Account not found.");
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new RequestResult<Account>(false, null, "Account not found.");
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static RequestResult<Boolean> addBalance(int ownerDni, double balance)
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
                throw new NegativeAmountException();
            }

            if(!(AccountController.accountExist(ownerDni).getResult()))
            {
                throw new AccountOwnerNotFoundException();
            }

            session.beginTransaction();

            Account cuenta = session.get(Account.class, AccountController.getAccountNumber(ownerDni));

            //Obtener saldo actual
            double nuevoSaldo = cuenta.getBalance() + balance;
            cuenta.setBalance(nuevoSaldo);

            session.merge(cuenta);

            session.getTransaction().commit();

            return new RequestResult<Boolean>(true, null, "Balance added successfully");
            
        }

        catch (IllegalArgumentException e)
        {
            System.err.println(Color.color("RED", e.getMessage()));
            e.printStackTrace();
            return new RequestResult<Boolean>(false, null, e.getMessage());
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

    public static RequestResult<Boolean> withdrawBalance(int ownerDni, double balance)
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
                throw new NegativeAmountException();
            }

            if(!(AccountController.accountExist(ownerDni).getResult()))
            {
                throw new AccountOwnerNotFoundException();
            }

            session.beginTransaction();
    
            Account cuenta = session.get(Account.class, AccountController.getAccountNumber(ownerDni));
    
            //Obtener saldo actual
            double nuevoSaldo = cuenta.getBalance() - balance;
            cuenta.setBalance(nuevoSaldo);
    
            session.merge(cuenta);
    
            session.getTransaction().commit();
    
            return new RequestResult<Boolean>(true, null, "Balance withdrawn successfully");
        }

        catch (IllegalArgumentException e)
        {
            System.err.println(Color.color("RED", e.getMessage()));
            e.printStackTrace();
            return new RequestResult<Boolean>(false, null, e.getMessage());
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

    public static RequestResult<Double> getBalance(int ownerDni)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Account.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            if(!(AccountController.accountExist(ownerDni).getResult()))
            {
                throw new AccountOwnerNotFoundException();
            }

            Account cuenta = AccountController.getAccount(ownerDni).getResult();

            return new RequestResult<Double>(true, cuenta.getBalance(), "Balance got successfully.");
        }

        catch (IllegalArgumentException e)
        {
            System.err.println(Color.color("RED", e.getMessage()));
            e.printStackTrace();
            return new RequestResult<Double>(false, null, e.getMessage());
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new RequestResult<Double>(false, null, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static RequestResult<Boolean> deleteAccount(int ownerDni)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Account.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            if(!(AccountController.accountExist(ownerDni)).getResult())
            {
                throw new AccountOwnerNotFoundException();
            }

            session.beginTransaction();

            Account cuenta = AccountController.getAccount(ownerDni).getResult();
            session.remove(cuenta);

            session.getTransaction().commit();

            return new RequestResult<Boolean>(true, null, "Account deleted successfully.");

        }

        catch (IllegalArgumentException e)
        {
            System.err.println(Color.color("RED", e.getMessage()));
            e.printStackTrace();
            return new RequestResult<Boolean>(false, null, e.getMessage());
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

    public static RequestResult<Boolean> hasEnough(int ownerDni, double balance)
    {
        Boolean theResult = AccountController.getBalance(ownerDni).getResult() >= balance;
        return new RequestResult<Boolean>(true, theResult, "Account has enough balance.");
    }
}