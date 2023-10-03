package org.davshaw.Controller;

import org.davshaw.Model.derivatedentities.GroupLog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class GroupLogController
{
    public static String createLog(int userDni, int groupId, Boolean nativeFlag)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(GroupLog.class)
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
            else if (!(GroupController.groupExist(groupId)))
            {
                throw new IllegalArgumentException("No existe un grupo con este ID.");
            }
            //Sino se lanzaron esas exceptions, entonces tenemos todo lo necesario
            else
            {
                session.beginTransaction();

                GroupLog registro = new GroupLog();
                //Establecer datos con setters (Reemplazando el constructor)
                registro.setUserDni(userDni);
                registro.setGroupId(groupId);
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
        .addAnnotatedClass(GroupLog.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();
    

        try
        {
            String sql = "SELECT COUNT(*) FROM groupLog WHERE id = :id";
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

    public static GroupLog getLog(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(GroupLog.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            session.beginTransaction();

            GroupLog registro = session.get(GroupLog.class, id);

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
        .addAnnotatedClass(GroupLog.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista el registro
            if(!(GroupLogController.logExist(id)))
            {
                throw new IllegalArgumentException("No existe un registro con este id.");
            }

            //Obtener objeto
            GroupLog registro = GroupLogController.getLog(id);

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

    public static Integer getGroupId(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(GroupLog.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista el registro
            if(!(GroupLogController.logExist(id)))
            {
                throw new IllegalArgumentException("No existe un registro con este id.");
            }

            //Obtener objeto
            GroupLog registro = GroupLogController.getLog(id);

            return registro.getGroupId();
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
        .addAnnotatedClass(GroupLog.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista el registro
            if(!(GroupLogController.logExist(id)))
            {
                throw new IllegalArgumentException("No existe un registro con este id.");
            }

            //Obtener objeto
            GroupLog registro = GroupLogController.getLog(id);

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
