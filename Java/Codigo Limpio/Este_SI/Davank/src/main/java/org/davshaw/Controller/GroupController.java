package org.davshaw.Controller;

import org.davshaw.Model.pureentities.Group;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class GroupController
{
    public static String createGroup(String name)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Group.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            session.beginTransaction();
            
            Group grupo = new Group();
            //Establecer datos con setters (Reemplazando el constructor)
            grupo.setName(name);

            session.persist(grupo);

            session.getTransaction().commit();
            return "Grupo creado con éxito.";
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return "Error al crear el grupo.";
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static Boolean groupExist(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Group.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            String sql = "SELECT count(*) FROM Group WHERE id = :id";
            Query<Long> query = session.createNativeQuery(sql, Long.class);
            query.setParameter("id", id);
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

    public static Group getGroup(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Group.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            if(GroupController.groupExist(id))
            {
                session.beginTransaction();

                Group grupo = session.get(Group.class, id);

                session.getTransaction().commit();

                return grupo;
            }
            
            else
            {
                throw new IllegalArgumentException("No existe un grupo con este id.");
            }
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

    public static Double getBalance(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Group.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            if(GroupController.groupExist(id))
            {
                session.beginTransaction();

                Group grupo = session.get(Group.class, id);

                session.getTransaction().commit();

                return grupo.getBalance();
            }
            
            else
            {
                throw new IllegalArgumentException("No existe un grupo con este id.");
            }
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

    public static String addBalance(int id, double balance)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Group.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            if(balance < 0)
            {
                throw new IllegalArgumentException("El monto no puede ser negativo.");
            }

            else if(GroupController.groupExist(id))
            {
                session.beginTransaction();

                Group grupo = GroupController.getGroup(id);

                //Editar saldo
                double nuevoSaldo = grupo.getBalance() + balance;
                grupo.setBalance(nuevoSaldo);

                session.merge(grupo);

                session.getTransaction().commit();

                return "Se ha agregado saldo al grupo.";

            }
            
            else
            {
                throw new IllegalArgumentException("No existe un grupo con este id.");
            }
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

    public static String withdrawalBalance(int id, double balance)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Group.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            if(balance < 0)
            {
                throw new IllegalArgumentException("El monto no puede ser negativo.");
            }

            else if(GroupController.groupExist(id))
            {
                session.beginTransaction();

                Group grupo = GroupController.getGroup(id);

                //Editar saldo
                double nuevoSaldo = grupo.getBalance() - balance;
                grupo.setBalance(nuevoSaldo);

                session.merge(grupo);

                session.getTransaction().commit();

                return "Se ha retirado saldo al grupo.";

            }
            
            else
            {
                throw new IllegalArgumentException("No existe un grupo con este id.");
            }
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
}
