package org.davshaw.Controller;

import org.davshaw.Exception.AccountNotFoundException;
import org.davshaw.Exception.AccountOwnerNotFoundException;
import org.davshaw.Exception.DuplicateAccountOwnerException;
import org.davshaw.Exception.InsufficientBalanceException;
import org.davshaw.Exception.NegativeAmountException;
import org.davshaw.External.Color;
import org.davshaw.External.ResultPack;
import org.davshaw.Model.pureentities.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class AccountController {

  public static ResultPack<Boolean> createAccount(int ownerDni) {
    SessionFactory sessionFactory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(Account.class)
      .buildSessionFactory();

    Session session = sessionFactory.openSession();

    try {
      //Checking account exist
      if (!AccountController.accountExist(ownerDni).getResult()) {
        Account account = new Account();

        //Setting data
        account.setOwnerDni(ownerDni);

        session.beginTransaction();
        session.persist(account);
        session.getTransaction().commit();

        return new ResultPack<Boolean>(
          true,
          null,
          "Account created successfully."
        );
      } else {
        throw new DuplicateAccountOwnerException();
      }
    } catch (IllegalArgumentException e) {
      System.err.println(Color.color("RED", e.getMessage()));
      
      return new ResultPack<Boolean>(false, null, e.getMessage());
    } catch (Exception e) {
      
      return new ResultPack<Boolean>(false, null, e.getMessage());
    } finally {
      session.close();
      sessionFactory.close();
    }
  }

  public static ResultPack<Boolean> accountExist(int ownerDni) {
    SessionFactory sessionFactory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(Account.class)
      .buildSessionFactory();

    Session session = sessionFactory.openSession();

    try {
      String sql = "SELECT count(*) FROM Account WHERE ownerDni = :ownerDni";
      Query<Long> query = session.createNativeQuery(sql, Long.class);
      query.setParameter("ownerDni", ownerDni);
      int count = ((Number) query.uniqueResult()).intValue();

      if (count > 0) {
        return new ResultPack<Boolean>(true, true, "Account found.");
      } else {
        return new ResultPack<Boolean>(
          true,
          false,
          new AccountNotFoundException().getMessage()
        );
      }
    } catch (Exception e) {
      
      return new ResultPack<Boolean>(false, false, e.getMessage());
    } finally {
      session.close();
      sessionFactory.close();
    }
  }

  public static ResultPack<Integer> getAccountNumber(int ownerDni) {
    SessionFactory sessionFactory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(Account.class)
      .buildSessionFactory();

    Session session = sessionFactory.openSession();

    try {
      //Checking account exists
      if (!(AccountController.accountExist(ownerDni).getResult())) {
        throw new AccountNotFoundException();
      }

      String sql =
        "SELECT accountNumber FROM Account WHERE ownerDni = :ownerDni LIMIT 1";
      Query<Integer> query = session.createNativeQuery(sql, Integer.class);
      query.setParameter("ownerDni", ownerDni);

      Integer accountNumber = query.uniqueResult();

      if (accountNumber != null) {
        return new ResultPack<Integer>(true, accountNumber, "Account found.");
      }
      return new ResultPack<Integer>(
        true,
        null,
        new AccountNotFoundException().getMessage()
      );
    } catch (Exception e) {
      
      return new ResultPack<Integer>(false, null, e.getMessage());
    } finally {
      session.close();
      sessionFactory.close();
    }
  }

  public static ResultPack<Account> getAccount(int ownerDni) {
    SessionFactory sessionFactory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(Account.class)
      .buildSessionFactory();

    Session session = sessionFactory.openSession();

    try {
      //Checking account exists
      if (!(AccountController.accountExist(ownerDni).getResult())) {
        throw new AccountOwnerNotFoundException();
      }
      session.beginTransaction();

      Integer primarykey = AccountController
        .getAccountNumber(ownerDni)
        .getResult();
      Account account = session.get(Account.class, primarykey);

      session.getTransaction().commit();

      return new ResultPack<Account>(true, account, "Account found.");
    } catch (IllegalArgumentException e) {
      System.err.println(Color.color("RED", e.getMessage()));
      
      return new ResultPack<Account>(false, null, "Account not found.");
    } catch (Exception e) {
      
      return new ResultPack<Account>(false, null, "Account not found.");
    } finally {
      session.close();
      sessionFactory.close();
    }
  }

  public static ResultPack<Boolean> addBalance(int ownerDni, double balance) {
    SessionFactory sessionFactory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(Account.class)
      .buildSessionFactory();

    Session session = sessionFactory.openSession();

    try {
      //Checking correct balance input
      if (balance < 0) {
        throw new NegativeAmountException();
      }

      //Checking account exists
      if (!(AccountController.accountExist(ownerDni).getResult())) {
        throw new AccountOwnerNotFoundException();
      }

      session.beginTransaction();

      Integer primarykey = AccountController
        .getAccountNumber(ownerDni)
        .getResult();
      Account account = session.get(Account.class, primarykey);
      double newBalance = account.getBalance() + balance;

      account.setBalance(newBalance);
      session.merge(account);

      session.getTransaction().commit();

      return new ResultPack<Boolean>(true, null, "Balance added successfully");
    } catch (IllegalArgumentException e) {
      System.err.println(Color.color("RED", e.getMessage()));
      
      return new ResultPack<Boolean>(false, null, e.getMessage());
    } catch (Exception e) {
      
      return new ResultPack<Boolean>(false, null, e.getMessage());
    } finally {
      session.close();
      sessionFactory.close();
    }
  }

  public static ResultPack<Boolean> withdrawBalance(
    int ownerDni,
    double balance
  ) {
    SessionFactory sessionFactory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(Account.class)
      .buildSessionFactory();

    Session session = sessionFactory.openSession();

    try {
      if (balance < 0) {
        throw new NegativeAmountException();
      }

      if (!(AccountController.accountExist(ownerDni).getResult())) {
        throw new AccountOwnerNotFoundException();
      }

      if (!(AccountController.hasEnough(ownerDni, balance).getResult())) {
        throw new InsufficientBalanceException();
      }
      
      session.beginTransaction();

      Integer primarykey = AccountController
        .getAccountNumber(ownerDni)
        .getResult();
      Account account = session.get(Account.class, primarykey);

      //Getting current balance
      double newBalance = account.getBalance() - balance;
      account.setBalance(newBalance);

      session.merge(account);

      session.getTransaction().commit();

      return new ResultPack<Boolean>(
        true,
        null,
        "Balance withdrawn successfully"
      );
    } catch (IllegalArgumentException e) {
      System.err.println(Color.color("RED", e.getMessage()));
      
      return new ResultPack<Boolean>(false, null, e.getMessage());
    } catch (Exception e) {
      
      return new ResultPack<Boolean>(false, null, e.getMessage());
    } finally {
      session.close();
      sessionFactory.close();
    }
  }

  public static ResultPack<Double> getBalance(int ownerDni) {
    SessionFactory sessionFactory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(Account.class)
      .buildSessionFactory();

    Session session = sessionFactory.openSession();

    try {
      if (!(AccountController.accountExist(ownerDni).getResult())) {
        throw new AccountOwnerNotFoundException();
      }

      Account account = AccountController.getAccount(ownerDni).getResult();

      return new ResultPack<Double>(
        true,
        account.getBalance(),
        "Balance got successfully."
      );
    } catch (IllegalArgumentException e) {
      System.err.println(Color.color("RED", e.getMessage()));
      
      return new ResultPack<Double>(false, null, e.getMessage());
    } catch (Exception e) {
      
      return new ResultPack<Double>(false, null, e.getMessage());
    } finally {
      session.close();
      sessionFactory.close();
    }
  }

  public static ResultPack<Boolean> deleteAccount(int ownerDni) {
    SessionFactory sessionFactory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(Account.class)
      .buildSessionFactory();

    Session session = sessionFactory.openSession();

    try {
      if (!(AccountController.accountExist(ownerDni)).getResult()) {
        throw new AccountOwnerNotFoundException();
      }

      session.beginTransaction();

      Account account = AccountController.getAccount(ownerDni).getResult();
      session.remove(account);

      session.getTransaction().commit();

      return new ResultPack<Boolean>(
        true,
        null,
        "Account deleted successfully."
      );
    } catch (IllegalArgumentException e) {
      System.err.println(Color.color("RED", e.getMessage()));
      
      return new ResultPack<Boolean>(false, null, e.getMessage());
    } catch (Exception e) {
      
      return new ResultPack<Boolean>(false, null, e.getMessage());
    } finally {
      session.close();
      sessionFactory.close();
    }
  }

  public static ResultPack<Boolean> hasEnough(int ownerDni, double balance) {
    Boolean theResult =
      (AccountController.getBalance(ownerDni).getResult() >= balance);
    return new ResultPack<Boolean>(
      true,
      theResult,
      "Account has enough balance."
    );
  }
}
