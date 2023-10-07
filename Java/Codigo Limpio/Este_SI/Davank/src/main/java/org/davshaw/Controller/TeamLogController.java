package org.davshaw.Controller;

import org.davshaw.Exception.RecordNotFoundException;
import org.davshaw.Exception.TeamNotFoundException;
import org.davshaw.Exception.UserNotFoundException;
import org.davshaw.External.RequestResult;
import org.davshaw.Model.derivatedentities.TeamLog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class TeamLogController
{
    public static RequestResult<Boolean> createLog(int userDni, int teamId, Boolean nativeFlag)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(TeamLog.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista el usuario
            if(!(UserController.userExist(userDni).getResult()))
            {
                throw new UserNotFoundException();
            }
            //Verificar que exista el grupo
            if (!(TeamController.teamExist(teamId).getResult()))
            {
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

            return new RequestResult<Boolean>(true, null, "The log has been created successfully.");
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

    public static RequestResult<Boolean> logExist(int id)
    {
        SessionFactory sessionFactory = new
        Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(TeamLog.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();
    

        try
        {
            String sql = "SELECT COUNT(*) FROM TeamLog WHERE id = :id";
            Query<Long> query = session.createNativeQuery(sql, Long.class);
            query.setParameter("id", id);

            // Obtener el resultado de la consulta (cantidad de usuarios con el DNI dado)
            int count = ((Number) query.uniqueResult()).intValue();
    
            // Si count es mayor que 0, significa que existe un usuario con ese DNI
            if (count > 0)
            {
                return new RequestResult<Boolean>(true, true, "Log found.");
            }

            else
            {
                return new RequestResult<Boolean>(true, false, new RecordNotFoundException().getMessage());
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

    public static RequestResult<TeamLog> getLog(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(TeamLog.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Checking if log exists
            if(!(TeamLogController.logExist(id).getResult()))
            {
                throw new RecordNotFoundException();
            }

            session.beginTransaction();

            TeamLog registro = session.get(TeamLog.class, id);

            session.getTransaction().commit();

            return new RequestResult<TeamLog>(true, registro, "Log found.");
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new RequestResult<TeamLog>(false, null, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static RequestResult<Integer> getOwnerDni(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(TeamLog.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista el registro
            if(!(TeamLogController.logExist(id).getResult()))
            {
                throw new RecordNotFoundException();
            }

            //Obtener objeto
            TeamLog registro = TeamLogController.getLog(id).getResult();

            Integer userDni = registro.getUserDni();

            return new RequestResult<Integer>(true, userDni, "Log found.");
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new RequestResult<Integer>(false, null, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static RequestResult<Integer> getteamId(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(TeamLog.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista el registro
            if(!(TeamLogController.logExist(id).getResult()))
            {
                throw new RecordNotFoundException();
            }

            //Obtener objeto
            TeamLog registro = TeamLogController.getLog(id).getResult();

            Integer teamId =registro.getTeamId();

            return new RequestResult<Integer>(true, teamId, "Log found.");
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new RequestResult<Integer>(false, null, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }
}
