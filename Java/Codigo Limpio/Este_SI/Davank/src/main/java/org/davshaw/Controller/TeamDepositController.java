package org.davshaw.Controller;

import java.util.Date;

import org.davshaw.Exception.InsufficientBalanceException;
import org.davshaw.Exception.RecordNotFoundException;
import org.davshaw.External.RequestResult;
import org.davshaw.Model.derivatedentities.TeamDeposit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class TeamDepositController
{
    public static RequestResult<Boolean> deposit(int logId, double balance)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(TeamDeposit.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Checking log exists
            if(!(TeamLogController.logExist(logId).getResult()))
            {
                throw new RecordNotFoundException();
            }

            //! (This checking depends on previous checking)
            //Checking account has enough balance
            int teamId = TeamLogController.getTeamId(logId).getResult();
            int userDni = TeamLogController.getOwnerDni(logId).getResult();

            if(!(AccountController.hasEnough(userDni, balance).getResult()))
            {
                throw new InsufficientBalanceException();
            }
            
            session.beginTransaction();
                
            //Withdraw balance from account
            AccountController.withdrawBalance(userDni, balance);
            //Deposit balance to team
            TeamController.addBalance(teamId, balance);

            //Registering deposit
            TeamDeposit deposit = new TeamDeposit();
            deposit.setDateTime(new Date());
            deposit.setBalance(balance);
            deposit.setLogId(logId);

            session.persist(deposit);

            session.getTransaction().commit();

            return new RequestResult<Boolean>(true, null, "The deposit has been done successfully.");
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

    public static RequestResult<Boolean> depositExist(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(TeamDeposit.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            String sql = "SELECT count(*) FROM TeamDeposit WHERE id = :id";
            Query<Long> query = session.createNativeQuery(sql, Long.class);
            query.setParameter("id", id);
            int count = ((Number) query.uniqueResult()).intValue();

            if (count > 0)
            {
                return new RequestResult<Boolean>(true, true, "Deposit found.");
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

    public static RequestResult<TeamDeposit> getDeposit(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(TeamDeposit.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Checking if deposit exists
            if(!(TeamDepositController.depositExist(id).getResult()))
            {
                throw new RecordNotFoundException();
            }
            session.beginTransaction();

            TeamDeposit deposit = session.get(TeamDeposit.class, id);
            session.getTransaction().commit();

            return new RequestResult<TeamDeposit>(true, deposit, "Deposit found.");
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new RequestResult<TeamDeposit>(false, null, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    } 

    public static RequestResult<Boolean> deleteDeposit(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(TeamDeposit.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {

            //Checking deposit exists
            if(!(TeamDepositController.depositExist(id).getResult()))
            {
                throw new RecordNotFoundException();
            }

            session.beginTransaction();
            TeamDeposit deposit = TeamDepositController.getDeposit(id).getResult();
            session.remove(deposit);
            session.getTransaction().commit();

            return new RequestResult<Boolean>(true, null, "The deposit has been deleted successfully.");
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

    public static RequestResult<Double> totalDeposit(int logId)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(TeamDeposit.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Checking deposit exists
            if(!(TeamLogController.logExist(logId).getResult()))
            {
                throw new RecordNotFoundException();
            }

            //Obtaining the primary key of rows in the TeamLog table that meet the condition.
            String sql = "SELECT SUM(balance) FROM TeamDeposit WHERE logId = :logId";
            Query<Double> query = session.createNativeQuery(sql, Double.class);
            query.setParameter("logId", logId);

            Double total = query.uniqueResult();
            
            if(total != null)
            {

                return new RequestResult<Double>(true, total, "Deposit found.");
            }

            return new RequestResult<Double>(false, 0.0, new RecordNotFoundException().getMessage());
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
}
