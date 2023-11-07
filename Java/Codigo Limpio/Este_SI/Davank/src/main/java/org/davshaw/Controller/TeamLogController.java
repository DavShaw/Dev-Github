package org.davshaw.Controller;

import java.util.List;

import org.davshaw.Exception.RecordNotFoundException;
import org.davshaw.Exception.TeamNotFoundException;
import org.davshaw.Exception.UserNotFoundException;
import org.davshaw.External.ResultPack;
import org.davshaw.Model.derivatedentities.TeamLog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class TeamLogController {

  public static ResultPack<Boolean> createLog(
    int userDni,
    int teamId,
    Boolean nativeFlag
  ) {
    SessionFactory sessionFactory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(TeamLog.class)
      .buildSessionFactory();

    Session session = sessionFactory.openSession();

    try {
      //Verificar que exista el usuario
      if (!(UserController.userExist(userDni).getResult())) {
        throw new UserNotFoundException();
      }
      //Verificar que exista el grupo
      if (!(TeamController.teamExist(teamId).getResult())) {
        throw new TeamNotFoundException();
      }

      session.beginTransaction();

      TeamLog registro = new TeamLog();
      //Establecer datos con setters (Reemplazando el constructor)
      registro.setUserDni(userDni);
      registro.setTeamId(teamId);
      registro.setNativeFlag(nativeFlag);

      session.persist(registro);
      session.getTransaction().commit();

      return new ResultPack<Boolean>(
        true,
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
      .addAnnotatedClass(TeamLog.class)
      .buildSessionFactory();

    Session session = sessionFactory.openSession();

    try {
      String sql = "SELECT COUNT(*) FROM TeamLog WHERE id = :id";
      Query<Long> query = session.createNativeQuery(sql, Long.class);
      query.setParameter("id", id);

      // Obtener el resultado de la consulta (cantidad de usuarios con el DNI dado)
      int count = ((Number) query.uniqueResult()).intValue();

      // Si count es mayor que 0, significa que existe un usuario con ese DNI
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

  public static ResultPack<TeamLog> getLog(int id) {
    SessionFactory sessionFactory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(TeamLog.class)
      .buildSessionFactory();

    Session session = sessionFactory.openSession();

    try {
      //Checking if log exists
      if (!(TeamLogController.logExist(id).getResult())) {
        throw new RecordNotFoundException();
      }

      session.beginTransaction();

      TeamLog registro = session.get(TeamLog.class, id);

      session.getTransaction().commit();

      return new ResultPack<TeamLog>(true, registro, "Log found.");
    } catch (Exception e) {
      e.printStackTrace();
      return new ResultPack<TeamLog>(false, null, e.getMessage());
    } finally {
      session.close();
      sessionFactory.close();
    }
  }

  public static ResultPack<List<Integer>> getLogIdByTeamId(int teamId) {

    SessionFactory sessionFactory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(TeamLog.class)
      .buildSessionFactory();

    Session session = sessionFactory.openSession();

    try {

      // Checking if team exists
      if (!TeamController.teamExist(teamId).getResult()) {
        throw new TeamNotFoundException();
      }

      session.beginTransaction();
      String sql = "SELECT id FROM TeamLog WHERE teamId = :teamId";
      Query<Integer> query = session.createNativeQuery(sql, Integer.class);
      query.setParameter("teamId", teamId);

      List<Integer> id = query.list();
      if (id != null) {
        return new ResultPack<List<Integer>>(true, id, "Log found.");
      }
      return new ResultPack<List<Integer>>(true, null, "Log not found.");

    } catch (Exception e) {
      e.printStackTrace();
      return new ResultPack<List<Integer>>(false, null, e.getMessage());
    } finally {
      session.close();
      sessionFactory.close();
    }

  }

  public static ResultPack<Integer> getOwnerDni(int id) {
    SessionFactory sessionFactory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(TeamLog.class)
      .buildSessionFactory();

    Session session = sessionFactory.openSession();

    try {
      //Verificar que exista el registro
      if (!(TeamLogController.logExist(id).getResult())) {
        throw new RecordNotFoundException();
      }

      //Obtener objeto
      TeamLog registro = TeamLogController.getLog(id).getResult();

      Integer userDni = registro.getUserDni();

      return new ResultPack<Integer>(true, userDni, "Log found.");
    } catch (Exception e) {
      e.printStackTrace();
      return new ResultPack<Integer>(false, null, e.getMessage());
    } finally {
      session.close();
      sessionFactory.close();
    }
  }

  public static ResultPack<Integer> getTeamId(int id) {
    SessionFactory sessionFactory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(TeamLog.class)
      .buildSessionFactory();

    Session session = sessionFactory.openSession();

    try {
      //Verificar que exista el registro
      if (!(TeamLogController.logExist(id).getResult())) {
        throw new RecordNotFoundException();
      }

      //Obtener objeto
      TeamLog registro = TeamLogController.getLog(id).getResult();

      Integer teamId = registro.getTeamId();

      return new ResultPack<Integer>(true, teamId, "Log found.");
    } catch (Exception e) {
      e.printStackTrace();
      return new ResultPack<Integer>(false, null, e.getMessage());
    } finally {
      session.close();
      sessionFactory.close();
    }
  }

  public static ResultPack<Boolean> deleteLog(int id) {
    SessionFactory sessionFactory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(TeamLog.class)
      .buildSessionFactory();

    Session session = sessionFactory.openSession();

    try {
      //Verificar que exista el registro
      if (!(TeamLogController.logExist(id).getResult())) {
        throw new RecordNotFoundException();
      }

      session.beginTransaction();

      //Obtener objeto
      TeamLog registro = TeamLogController.getLog(id).getResult();

      session.remove(registro);

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

  public static ResultPack<Boolean> userOnTeam(int userDni, int teamId) {
    SessionFactory sessionFactory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(TeamLog.class)
      .buildSessionFactory();

    Session session = sessionFactory.openSession();

    try {
      //checking user exits
      if (!(UserController.userExist(userDni).getResult())) {
        throw new UserNotFoundException();
      }

      //Checking team exists
      if (!(TeamController.teamExist(teamId).getResult())) {
        throw new TeamNotFoundException();
      }

      session.beginTransaction();

      String sql =
        "SELECT count(*) FROM TeamLog WHERE userDni = :userDni AND teamId = :teamId";
      Query<Long> query = session.createNativeQuery(sql, Long.class);
      query.setParameter("userDni", userDni);
      query.setParameter("teamId", teamId);

      Integer count = Integer.valueOf(query.uniqueResult().toString());

      if (count > 0) {
        return new ResultPack<Boolean>(true, true, "User found.");
      }

      return new ResultPack<Boolean>(true, false, "User not found.");
    } catch (Exception e) {
      e.printStackTrace();
      return new ResultPack<Boolean>(false, false, e.getMessage());
    } finally {
      session.close();
      sessionFactory.close();
    }
  }
}
