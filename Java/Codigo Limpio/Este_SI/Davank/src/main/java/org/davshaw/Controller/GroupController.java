package org.davshaw.Controller;

import org.davshaw.Model.pureentities.Group;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class GroupController
{

    public static String crearGrupo(String nombre)
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
            grupo.setName(nombre);

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

    public static Boolean existeGrupo(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Group.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            String sql = "SELECT count(*) FROM Grupo WHERE id = :id";
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

    public static Group obtenerGrupo(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Group.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            if(GroupController.existeGrupo(id))
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

    public static Double obtenersaldo(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Group.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            if(GroupController.existeGrupo(id))
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

    public static String agregarSaldo(int id, double monto)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Group.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            if(monto < 0)
            {
                throw new IllegalArgumentException("El monto no puede ser negativo.");
            }

            else if(GroupController.existeGrupo(id))
            {
                session.beginTransaction();

                Group grupo = GroupController.obtenerGrupo(id);

                //Editar saldo
                double nuevoSaldo = grupo.getBalance() + monto;
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

    public static String retirarSaldo(int id, double monto)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Group.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            if(monto < 0)
            {
                throw new IllegalArgumentException("El monto no puede ser negativo.");
            }

            else if(GroupController.existeGrupo(id))
            {
                session.beginTransaction();

                Group grupo = GroupController.obtenerGrupo(id);

                //Editar saldo
                double nuevoSaldo = grupo.getBalance() - monto;
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
