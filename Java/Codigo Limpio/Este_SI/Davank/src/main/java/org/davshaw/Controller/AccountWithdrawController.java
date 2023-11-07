package org.davshaw.Controller;

import java.util.Date;
import java.util.List;

import org.davshaw.Exception.AccountNotFoundException;
import org.davshaw.Exception.InsufficientBalanceException;
import org.davshaw.Exception.NegativeAmountException;
import org.davshaw.Exception.RecordNotFoundException;
import org.davshaw.Exception.UserNotFoundException;
import org.davshaw.External.ResultPack;
import org.davshaw.Model.derivatedentities.AccountDeposit;
import org.davshaw.Model.derivatedentities.AccountTransfer;
import org.davshaw.Model.derivatedentities.AccountWithdraw;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class AccountWithdrawController {

  public static ResultPack<Boolean> withdraw(int ownerDni, double balance) {
    SessionFactory sessionFactory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(AccountDeposit.class)
      .buildSessionFactory();

    Session session = sessionFactory.openSession();

    try {
      //Checking account exists
      if (!(AccountController.accountExist(ownerDni).getResult())) {
        throw new AccountNotFoundException();
      }
      //Checking account has enough balance
      if (!(AccountController.hasEnough(ownerDni, balance).getResult())) {
        throw new InsufficientBalanceException();
      }

      if (balance < 0) {
        throw new NegativeAmountException();
      }

      session.beginTransaction();

      AccountController.withdrawBalance(ownerDni, balance);
      //Registering withdraw
      AccountWithdraw withdraw = new AccountWithdraw();
      withdraw.setDateTime(new Date());
      withdraw.setBalance(balance);
      withdraw.setAccountNumber(
        AccountController.getAccountNumber(ownerDni).getResult()
      );

      session.persist(withdraw);
      session.getTransaction().commit();
      return new ResultPack<Boolean>(
        true,
        null,
        "The withdraw has been done successfully."
      );
    } catch (Exception e) {
      e.printStackTrace();
      return new ResultPack<Boolean>(false, null, e.getMessage());
    } finally {
      session.close();
      sessionFactory.close();
    }
  }

  public static ResultPack<Boolean> withdrawExist(int id) {
    SessionFactory sessionFactory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(AccountWithdraw.class)
      .buildSessionFactory();

    Session session = sessionFactory.openSession();

    try {
      String sql = "SELECT count(*) FROM AccountWithdraw WHERE id = :id";
      Query<Long> query = session.createNativeQuery(sql, Long.class);
      query.setParameter("id", id);
      int count = ((Number) query.uniqueResult()).intValue();

      if (count > 0) {
        return new ResultPack<Boolean>(true, true, "Withdraw found.");
      } else {
        return new ResultPack<Boolean>(
          true,
          false,
          new RecordNotFoundException().getMessage()
        );
      }
    } catch (Exception e) {
      e.printStackTrace();
      return new ResultPack<Boolean>(false, false, e.getMessage());
    } finally {
      session.close();
      sessionFactory.close();
    }
  }

  public static ResultPack<AccountWithdraw> getWithdraw(int id) {
    SessionFactory sessionFactory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(AccountWithdraw.class)
      .buildSessionFactory();

    Session session = sessionFactory.openSession();

    try {
      //Checking withdraw exists
      if (!(AccountWithdrawController.withdrawExist(id).getResult())) {
        throw new RecordNotFoundException();
      }

      session.beginTransaction();

      AccountWithdraw withdraw = session.get(AccountWithdraw.class, id);

      session.getTransaction().commit();

      return new ResultPack<AccountWithdraw>(
        true,
        withdraw,
        "Withdraw found."
      );
    } catch (Exception e) {
      e.printStackTrace();
      return new ResultPack<AccountWithdraw>(false, null, e.getMessage());
    } finally {
      session.close();
      sessionFactory.close();
    }
  }

  public static ResultPack<Boolean> deleteWithdraw(int id) {
    SessionFactory sessionFactory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(AccountWithdraw.class)
      .buildSessionFactory();

    Session session = sessionFactory.openSession();

    try {
      //Checking withdraw exists
      if (!(AccountWithdrawController.withdrawExist(id).getResult())) {
        throw new RecordNotFoundException();
      }
      session.beginTransaction();

      AccountWithdraw withdraw = AccountWithdrawController
        .getWithdraw(id)
        .getResult();

      session.remove(withdraw);

      session.getTransaction().commit();

      return new ResultPack<Boolean>(true, null, "withdraw found.");
    } catch (Exception e) {
      e.printStackTrace();
      return new ResultPack<Boolean>(false, null, e.getMessage());
    } finally {
      session.close();
      sessionFactory.close();
    }
  }

  public static ResultPack<List<Integer>> getWithdrawReport(int userDni) {
    SessionFactory sessionFactory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(AccountTransfer.class)
      .buildSessionFactory();

    Session session = sessionFactory.openSession();

    try {
      
      //Checking user exists
      if(!(UserController.userExist(userDni).getResult())) {
        throw new UserNotFoundException();
      }
      
      //Checking account exists
      if(!(AccountController.accountExist(userDni).getResult())) {
        throw new AccountNotFoundException();
      }

      session.beginTransaction();

      //Get account number
      int accountNumber = AccountController.getAccountNumber(userDni).getResult();
      //FIXME
      String sql = "SELECT id FROM AccountWithdraw WHERE accountNumber = :accountNumber";
      Query<Integer> query = session.createNativeQuery(sql, Integer.class);
      query.setParameter("accountNumber", accountNumber);

      return new ResultPack<List<Integer>>(true, query.list(), "Withdraw found.");
    }
    
    catch (Exception e) {
      e.printStackTrace();
      return new ResultPack<List<Integer>>(false, null, e.getMessage());
    }
    finally {
      session.close();
      sessionFactory.close();
    }
  }

}
