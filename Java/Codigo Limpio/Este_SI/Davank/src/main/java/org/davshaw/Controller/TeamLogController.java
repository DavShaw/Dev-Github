package org.davshaw.Controller;

import org.davshaw.Model.derivatedentities.TeamLog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class TeamLogController
{
    public static String createLog(int userDni, int teamId, Boolean nativeFlag)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(TeamLog.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista el usuario
            if(!(UserController.userExist(userDni)))
            {
                throw new IllegalArgumentException("No existe un usuario con este DNI.");
            }
            //Verificar que exista el grupo
            else if (!(TeamController.groupExist(teamId)))
            {
                throw new IllegalArgumentException("No existe un grupo con este ID.");
            }
            //Sino se lanzaron esas exceptions, entonces tenemos todo lo necesario
            else
            {
                session.beginTransaction();

                TeamLog registro = new TeamLog();
                //Establecer datos con setters (Reemplazando el constructor)
                registro.setUserDni(userDni);
                registro.setTeamId(teamId);
                registro.setNativeFlag(nativeFlag);

                session.persist(registro);
                session.getTransaction().commit();

                return "Registro de grupo creado con éxito";
            }
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return "Error al hacer el registro de grupo";
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static boolean logExist(int id)
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

    public static TeamLog getLog(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(TeamLog.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            session.beginTransaction();

            TeamLog registro = session.get(TeamLog.class, id);

            session.getTransaction().commit();

            return registro;
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

    public static Integer getOwnerDni(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(TeamLog.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista el registro
            if(!(TeamLogController.logExist(id)))
            {
                throw new IllegalArgumentException("No existe un registro con este id.");
            }

            //Obtener objeto
            TeamLog registro = TeamLogController.getLog(id);

            return registro.getUserDni();
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

    public static Integer getteamId(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(TeamLog.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista el registro
            if(!(TeamLogController.logExist(id)))
            {
                throw new IllegalArgumentException("No existe un registro con este id.");
            }

            //Obtener objeto
            TeamLog registro = TeamLogController.getLog(id);

            return registro.getTeamId();
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

    public static Boolean getNativeFlag(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(TeamLog.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista el registro
            if(!(TeamLogController.logExist(id)))
            {
                throw new IllegalArgumentException("No existe un registro con este id.");
            }

            //Obtener objeto
            TeamLog registro = TeamLogController.getLog(id);

            return registro.isNativeFlag();
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
