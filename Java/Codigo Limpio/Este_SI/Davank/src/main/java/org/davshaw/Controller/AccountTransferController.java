package org.davshaw.Controller;

import java.util.Date;
import java.util.List;

import org.davshaw.Exception.AccountNotFoundException;
import org.davshaw.Exception.InsufficientBalanceException;
import org.davshaw.Exception.RecordNotFoundException;
import org.davshaw.Exception.UserNotFoundException;
import org.davshaw.External.ResultPack;
import org.davshaw.Model.derivatedentities.AccountTransfer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class AccountTransferController {

  public static ResultPack<Boolean> transfer(
    int originOwnerDni,
    int destinationOwnerDni,
    double balance
  ) {
    SessionFactory sessionFactory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(AccountTransfer.class)
      .buildSessionFactory();

    Session session = sessionFactory.openSession();

    try {
      //Checking account exists (Origin)
      if (!(AccountController.accountExist(originOwnerDni).getResult())) {
        throw new AccountNotFoundException();
      }

      //Checking account exists (Destination)
      if (!(AccountController.accountExist(destinationOwnerDni).getResult())) {
        throw new AccountNotFoundException();
      }

      //Checking account has enough balance to make transfer
      if (!(AccountController.hasEnough(originOwnerDni, balance).getResult())) {
        throw new InsufficientBalanceException();
      }

      session.beginTransaction();

      //Withdraw balance from origin account
      AccountController.withdrawBalance(originOwnerDni, balance);
      //Deposit balance to destination account
      AccountController.addBalance(destinationOwnerDni, balance);

      //Registering transfer
      AccountTransfer transfer = new AccountTransfer();
      transfer.setDateTime(new Date());
      transfer.setBalance(balance);

      Integer originAccount = AccountController
        .getAccountNumber(originOwnerDni)
        .getResult();
      Integer destinationAccount = AccountController
        .getAccountNumber(destinationOwnerDni)
        .getResult();

      transfer.setOriginAccountNumber(originAccount);
      transfer.setDestinationAccountNumber(destinationAccount);

      session.persist(transfer);

      session.getTransaction().commit();

      return new ResultPack<Boolean>(true, null, "The transfer has been done.");
    } catch (Exception e) {
      e.printStackTrace();
      return new ResultPack<Boolean>(false, null, e.getMessage());
    } finally {
      session.close();
      sessionFactory.close();
    }
  }

  public static ResultPack<Boolean> transferExist(int id) {
    SessionFactory sessionFactory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(AccountTransfer.class)
      .buildSessionFactory();

    Session session = sessionFactory.openSession();

    try {
      String sql = "SELECT count(*) FROM AccountTransfer WHERE id = :id";
      Query<Long> query = session.createQuery(sql, Long.class);
      query.setParameter("id", id);
      int count = Integer.valueOf(query.uniqueResult().toString());

      if (count > 0) {
        return new ResultPack<Boolean>(true, true, "Transfer found.");
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

  public static ResultPack<AccountTransfer> getTransfer(int id) {
    SessionFactory sessionFactory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(AccountTransfer.class)
      .buildSessionFactory();

    Session session = sessionFactory.openSession();

    try {
      if (!(AccountTransferController.transferExist(id).getResult())) {
        throw new RecordNotFoundException();
      }

      session.beginTransaction();
      AccountTransfer transfer = session.get(AccountTransfer.class, id);
      session.getTransaction().commit();

      return new ResultPack<AccountTransfer>(true, transfer, "Transfer found.");
    } catch (Exception e) {
      e.printStackTrace();
      return new ResultPack<AccountTransfer>(false, null, e.getMessage());
    } finally {
      session.close();
      sessionFactory.close();
    }
  }

  public static ResultPack<Boolean> deleteTransfer(int id) {
    SessionFactory sessionFactory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(AccountTransfer.class)
      .buildSessionFactory();

    Session session = sessionFactory.openSession();

    try {
      //Checking if transfer exists
      if (!(AccountTransferController.transferExist(id).getResult())) {
        throw new RecordNotFoundException();
      }

      session.beginTransaction();

      AccountTransfer transfer = AccountTransferController
        .getTransfer(id)
        .getResult();

      session.remove(transfer);
      session.getTransaction().commit();

      return new ResultPack<Boolean>(
        true,
        null,
        "The transfer has been deleted successfully."
      );
    } catch (Exception e) {
      e.printStackTrace();
      return new ResultPack<Boolean>(false, null, e.getMessage());
    } finally {
      session.close();
      sessionFactory.close();
    }
  }

  public static ResultPack<List<Integer>> getTransferReport(int userDni) {
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
      String sql = "SELECT id FROM AccountTransfer WHERE (originAccountNumber = :accountNumber OR destinationAccountNumber = :accountNumber)";
      Query<Integer> query = session.createNativeQuery(sql, Integer.class);
      query.setParameter("originAccountNumber", accountNumber);
      query.setParameter("destinationAccountNumber", accountNumber);

      return new ResultPack<List<Integer>>(true, query.list(), "Transfers found.");
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
