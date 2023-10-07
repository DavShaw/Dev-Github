package org.davshaw.Controller;

import org.davshaw.Exception.NegativeAmountException;
import org.davshaw.Exception.RecordNotFoundException;
import org.davshaw.Exception.TeamNotFoundException;
import org.davshaw.External.RequestResult;
import org.davshaw.Model.pureentities.Team;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class TeamController
{
    public static RequestResult<Boolean> createTeam(String name)
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
            
            return new RequestResult<Boolean>(true, null, "Team has been created successfully.");
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

    public static RequestResult<Boolean> teamExist(int id)
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

            if (count > 0)
            {
                return new RequestResult<Boolean>(true, true, "Team found.");
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

    public static RequestResult<Team> getTeam(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Team.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            if(TeamController.teamExist(id).getResult())
            {
                session.beginTransaction();

                Team grupo = session.get(Team.class, id);

                session.getTransaction().commit();

                return new RequestResult<Team>(true, grupo, "Team found.");
            }
            
            else
            {
                throw new TeamNotFoundException();
            }
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new RequestResult<Team>(false, null, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static RequestResult<Double> getBalance(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Team.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            if(TeamController.teamExist(id).getResult())
            {
                session.beginTransaction();

                Team grupo = session.get(Team.class, id);

                session.getTransaction().commit();

                return new RequestResult<Double>(true, grupo.getBalance(), "Team found.");
            }
            
            else
            {
                throw new TeamNotFoundException();
            }
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new RequestResult<Double>(false, null, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static RequestResult<Boolean> addBalance(int id, double balance)
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

            if(TeamController.teamExist(id).getResult())
            {
                session.beginTransaction();

                Team grupo = TeamController.getTeam(id).getResult();

                //Editar saldo
                double nuevoSaldo = grupo.getBalance() + balance;
                grupo.setBalance(nuevoSaldo);

                session.merge(grupo);

                session.getTransaction().commit();

                return new RequestResult<Boolean>(true, null, "Team found.");

            }
            
            else
            {
                throw new TeamNotFoundException();
            }
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

    public static RequestResult<Boolean> withdrawBalance(int id, double balance)
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

            if(TeamController.teamExist(id).getResult())
            {
                session.beginTransaction();

                Team grupo = TeamController.getTeam(id).getResult();

                //Editar saldo
                double nuevoSaldo = grupo.getBalance() - balance;
                grupo.setBalance(nuevoSaldo);

                session.merge(grupo);

                session.getTransaction().commit();

                return new RequestResult<Boolean>(true, null, "Team found.");

            }
            
            else
            {
                throw new TeamNotFoundException();
            }
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
}
