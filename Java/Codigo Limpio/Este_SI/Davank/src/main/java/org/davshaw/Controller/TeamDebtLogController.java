package org.davshaw.Controller;

import java.util.Date;
import java.util.List;
import org.davshaw.Exception.NegativeAmountException;
import org.davshaw.Exception.NoDebtException;
import org.davshaw.Exception.OverPaymentException;
import org.davshaw.Exception.RecordNotFoundException;
import org.davshaw.External.ResultPack;
import org.davshaw.Model.derivatedentities.TeamDebtLog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class TeamDebtLogController {

  public static ResultPack<Boolean> createLog(int logId, double amount) {
    SessionFactory sessionFactory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(TeamDebtLog.class)
      .buildSessionFactory();

    Session session = sessionFactory.openSession();

    try {
      //Checking log exists
      if (!(TeamLogController.logExist(logId).getResult())) {
        throw new RecordNotFoundException();
      }

      session.beginTransaction();

      TeamDebtLog log = new TeamDebtLog();

      log.setAmount(amount);
      log.setLastPayment(new Date());
      log.setLogId(logId);

      session.persist(log);

      session.getTransaction().commit();

      return new ResultPack<Boolean>(
        false,
        null,
        "The log has been created successfully."
      );
    } catch (Exception e) {
      e.printStackTrace();
      return new ResultPack<Boolean>(false, null, e.getMessage());
    } finally {
      session.close();
      sessionFactory.close();
    }
  }

  public static ResultPack<Boolean> logExist(int id) {
    SessionFactory sessionFactory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(TeamDebtLog.class)
      .buildSessionFactory();

    Session session = sessionFactory.openSession();

    try {
      String sql = "SELECT count(*) FROM TeamDebtLog WHERE id = :id";
      Query<Long> query = session.createNativeQuery(sql, Long.class);
      query.setParameter("id", id);
      int count = ((Number) query.uniqueResult()).intValue();

      if (count > 0) {
        return new ResultPack<Boolean>(true, true, "Log found.");
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

  public static ResultPack<TeamDebtLog> getLog(int id) {
    SessionFactory sessionFactory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(TeamDebtLog.class)
      .buildSessionFactory();

    Session session = sessionFactory.openSession();

    try {
      //Checking log exists
      if (!(TeamDebtLogController.logExist(id).getResult())) {
        throw new RecordNotFoundException();
      }

      session.beginTransaction();

      TeamDebtLog log = session.get(TeamDebtLog.class, id);

      session.getTransaction().commit();

      return new ResultPack<TeamDebtLog>(true, log, "Log found.");
    } catch (Exception e) {
      e.printStackTrace();
      return new ResultPack<TeamDebtLog>(false, null, e.getMessage());
    } finally {
      session.close();
      sessionFactory.close();
    }
  }

  public static ResultPack<TeamDebtLog> getLogByLogId(int logId) {
    SessionFactory sessionFactory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(TeamDebtLog.class)
      .buildSessionFactory();

    Session session = sessionFactory.openSession();

    try {
      //Checking logId exists
      if (!(TeamLogController.logExist(logId).getResult())) {
        throw new RecordNotFoundException();
      }

      session.beginTransaction();

      String sql = "SELECT id FROM TeamDebtLog WHERE logId = :logId LIMIT 1";
      Query<Integer> query = session.createNativeQuery(sql, Integer.class);
      query.setParameter("logId", logId);
      Integer id = query.uniqueResult();

      TeamDebtLog log = TeamDebtLogController.getLog(id).getResult();

      session.getTransaction().commit();

      return new ResultPack<TeamDebtLog>(true, log, "Log found.");
    } catch (Exception e) {
      e.printStackTrace();
      return new ResultPack<TeamDebtLog>(false, null, e.getMessage());
    } finally {
      session.close();
      sessionFactory.close();
    }
  }

  public static ResultPack<Double> getCurrentDebt(int id) {
    SessionFactory sessionFactory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(TeamDebtLog.class)
      .buildSessionFactory();

    Session session = sessionFactory.openSession();

    try {
      //Checking log exists
      if (!(TeamDebtLogController.logExist(id).getResult())) {
        throw new RecordNotFoundException();
      }

      session.beginTransaction();

      Double amount = TeamDebtLogController.getLog(id).getResult().getAmount();

      session.getTransaction().commit();

      return new ResultPack<Double>(true, amount, "Log found.");
    } catch (Exception e) {
      e.printStackTrace();
      return new ResultPack<Double>(false, null, e.getMessage());
    } finally {
      session.close();
      sessionFactory.close();
    }
  }

  public static ResultPack<Boolean> deleteLog(int id) {
    SessionFactory sessionFactory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(TeamDebtLog.class)
      .buildSessionFactory();

    Session session = sessionFactory.openSession();

    try {
      //Checking if log exists
      if (!(TeamDebtLogController.logExist(id).getResult())) {
        throw new RecordNotFoundException();
      }

      session.beginTransaction();

      TeamDebtLog log = TeamDebtLogController.getLog(id).getResult();

      session.remove(log);
      session.getTransaction().commit();

      return new ResultPack<Boolean>(
        true,
        null,
        "The log has been deleted successfully."
      );
    } catch (Exception e) {
      e.printStackTrace();
      return new ResultPack<Boolean>(false, null, e.getMessage());
    } finally {
      session.close();
      sessionFactory.close();
    }
  }

  public static ResultPack<Boolean> addDebt(int id, double amount) {
    SessionFactory sessionFactory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(TeamDebtLog.class)
      .buildSessionFactory();

    Session session = sessionFactory.openSession();

    try {
      //Checking log exists
      if (!(TeamDebtLogController.logExist(id).getResult())) {
        throw new RecordNotFoundException();
      }

      session.beginTransaction();

      TeamDebtLog log = TeamDebtLogController.getLog(id).getResult();
      Double newAmount = log.getAmount() + amount;
      log.setAmount(newAmount);

      session.merge(log);
      session.getTransaction().commit();

      return new ResultPack<Boolean>(true, null, "Log found.");
    } catch (Exception e) {
      e.printStackTrace();
      return new ResultPack<Boolean>(false, null, e.getMessage());
    } finally {
      session.close();
      sessionFactory.close();
    }
  }

  public static ResultPack<Boolean> payDebt(int id, double amount) {
    SessionFactory sessionFactory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(TeamDebtLog.class)
      .buildSessionFactory();

    Session session = sessionFactory.openSession();

    try {
      //Checking log exists
      if (!(TeamDebtLogController.logExist(id).getResult())) {
        throw new RecordNotFoundException();
      }

      //Checking entered amount < 0
      if (amount < 0) {
        throw new NegativeAmountException();
      }

      //!(This check depends on the previous check)
      //Checking current debt = 0 (There's nothing to pay)
      if (TeamDebtLogController.getCurrentDebt(id).getResult() == 0) {
        //Delete debt, because there's not
        TeamDebtLogController.deleteLog(id);
        throw new NoDebtException();
      }

      //!(This check depends on the previous check)
      //Checking amount <= currentDebt
      if (TeamDebtLogController.getCurrentDebt(id).getResult() < amount) {
        throw new OverPaymentException();
      }

      session.beginTransaction();

      TeamDebtLog log = TeamDebtLogController.getLog(id).getResult();
      Double newAmount = log.getAmount() - amount;
      log.setAmount(newAmount);

      session.merge(log);
      session.getTransaction().commit();

      return new ResultPack<Boolean>(true, null, "Log found.");
    } catch (Exception e) {
      e.printStackTrace();
      return new ResultPack<Boolean>(false, null, e.getMessage());
    } finally {
      session.close();
      sessionFactory.close();
    }
  }

  public static ResultPack<Boolean> deleteLogsIfDebtIsZero() {
    SessionFactory sessionFactory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(TeamDebtLog.class)
      .buildSessionFactory();

    Session session = sessionFactory.openSession();

    try {
      String sql = "SELECT id FROM TeamDebtLog WHERE amount = :amount";
      Query<Integer> query = session.createNativeQuery(sql, Integer.class);
      query.setParameter("amount", 0.0);

      List<Integer> result = query.list();

      for (Integer logId : result) {
        TeamDebtLogController.deleteLog(logId);
      }

      return new ResultPack<Boolean>(
        true,
        false,
        "Logs has been deleted successfully."
      );
    } catch (Exception e) {
      e.printStackTrace();
      return new ResultPack<Boolean>(false, false, e.getMessage());
    } finally {
      session.close();
      sessionFactory.close();
    }
  }
}
