package org.davshaw.Controller;

import org.davshaw.Exception.NegativeAmountException;
import org.davshaw.Exception.RecordNotFoundException;
import org.davshaw.Exception.TeamNotFoundException;
import org.davshaw.External.ResultPack;
import org.davshaw.Model.pureentities.Team;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class TeamController
{
    public static ResultPack<Boolean> createTeam(String name)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Team.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            session.beginTransaction();
            
            Team team = new Team();
            team.setName(name);
            
            session.persist(team);
            session.getTransaction().commit();
            
            return new ResultPack<Boolean>(true, null, "Team has been created successfully.");
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new ResultPack<Boolean>(false, null, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static ResultPack<Boolean> teamExist(int id)
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
                return new ResultPack<Boolean>(true, true, "Team found.");
            }
            
            return new ResultPack<Boolean>(true, false, new RecordNotFoundException().getMessage());
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new ResultPack<Boolean>(false, false, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static ResultPack<Team> getTeam(int id)
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

                Team team = session.get(Team.class, id);

                session.getTransaction().commit();

                return new ResultPack<Team>(true, team, "Team found.");
            }
            
            else
            {
                throw new TeamNotFoundException();
            }
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new ResultPack<Team>(false, null, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static ResultPack<Double> getBalance(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Team.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            if(!(TeamController.teamExist(id).getResult()))
            {
                throw new TeamNotFoundException();
            }

            session.beginTransaction();

            Team team = TeamController.getTeam(id).getResult();

            session.getTransaction().commit();

            return new ResultPack<Double>(true, team.getBalance(), "Team found.");

        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new ResultPack<Double>(false, null, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static ResultPack<Boolean> addBalance(int id, double balance)
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

            if(!(TeamController.teamExist(id).getResult()))
            {
                throw new TeamNotFoundException();
            }

            session.beginTransaction();

            Team team = TeamController.getTeam(id).getResult();

            //Editing balance
            double newBalance = team.getBalance() + balance;
            team.setBalance(newBalance);

            session.merge(team);

            session.getTransaction().commit();

            return new ResultPack<Boolean>(true, null, "Team found.");
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new ResultPack<Boolean>(false, null, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static ResultPack<Boolean> withdrawBalance(int id, double balance)
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

                Team team = TeamController.getTeam(id).getResult();

                //Editing balance
                double newBalance = team.getBalance() - balance;
                team.setBalance(newBalance);

                session.merge(team);

                session.getTransaction().commit();

                return new ResultPack<Boolean>(true, null, "Team found.");

            }
            
            else
            {
                throw new TeamNotFoundException();
            }
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new ResultPack<Boolean>(false, null, e.getMessage());

        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static ResultPack<Boolean> deleteTeam(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Team.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Checking if team exists
            if(!(TeamController.teamExist(id).getResult()))
            {
                throw new TeamNotFoundException();
            }

            session.beginTransaction();
            Team team = TeamController.getTeam(id).getResult();

            session.remove(team);
            session.getTransaction().commit();
            
            return new ResultPack<Boolean>(true, null, "Team has been deleted successfully.");
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new ResultPack<Boolean>(false, null, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

}
