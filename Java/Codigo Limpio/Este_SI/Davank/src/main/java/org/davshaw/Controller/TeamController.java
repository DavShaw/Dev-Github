package org.davshaw.Controller;

import org.davshaw.Exception.NegativeAmountException;
import org.davshaw.Exception.TeamNotFoundException;
import org.davshaw.Model.pureentities.Team;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class TeamController
{
    public static String createTeam(String name)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Team.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            session.beginTransaction();
            
            Team grupo = new Team();
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

    public static Boolean teamExist(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Team.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            String sql = "SELECT count(*) FROM Team WHERE id = :id";
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

    public static Team getTeam(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Team.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            if(TeamController.teamExist(id))
            {
                session.beginTransaction();

                Team grupo = session.get(Team.class, id);

                session.getTransaction().commit();

                return grupo;
            }
            
            else
            {
                throw new TeamNotFoundException();
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
        .addAnnotatedClass(Team.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            if(TeamController.teamExist(id))
            {
                session.beginTransaction();

                Team grupo = session.get(Team.class, id);

                session.getTransaction().commit();

                return grupo.getBalance();
            }
            
            else
            {
                throw new TeamNotFoundException();
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
        .addAnnotatedClass(Team.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            if(balance < 0)
            {
                throw new NegativeAmountException();
            }

            if(TeamController.teamExist(id))
            {
                session.beginTransaction();

                Team grupo = TeamController.getTeam(id);

                //Editar saldo
                double nuevoSaldo = grupo.getBalance() + balance;
                grupo.setBalance(nuevoSaldo);

                session.merge(grupo);

                session.getTransaction().commit();

                return "Se ha agregado saldo al grupo.";

            }
            
            else
            {
                throw new TeamNotFoundException();
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

    public static String withdrawBalance(int id, double balance)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Team.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            if(balance < 0)
            {
                throw new NegativeAmountException();
            }

            if(TeamController.teamExist(id))
            {
                session.beginTransaction();

                Team grupo = TeamController.getTeam(id);

                //Editar saldo
                double nuevoSaldo = grupo.getBalance() - balance;
                grupo.setBalance(nuevoSaldo);

                session.merge(grupo);

                session.getTransaction().commit();

                return "Se ha retirado saldo al grupo.";

            }
            
            else
            {
                throw new TeamNotFoundException();
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
