package org.davshaw.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.davshaw.Exception.HaveNotDepositEnoughException;
import org.davshaw.Exception.InsufficientBalanceException;
import org.davshaw.Exception.RecordNotFoundException;
import org.davshaw.Exception.UserNotFoundException;
import org.davshaw.External.ResultPack;
import org.davshaw.Model.derivatedentities.TeamLoan;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class TeamLoanController
{
    public static ResultPack<Boolean> loan(int logId, double balance)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(TeamLoan.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Checking log exists
            if(!(TeamLogController.logExist(logId).getResult()))
            {
                throw new RecordNotFoundException();
            }

            //Checking balance to loan is less than historical deposit amount
            if(TeamDepositController.totalDeposit(logId).getResult() < balance)
            {
                throw new HaveNotDepositEnoughException();
            }

            //Checking team has enough balance
            if(TeamLogController.getLog(logId).getResult().getTeam().getBalance() < balance)
            {
                throw new InsufficientBalanceException();
            }

            session.beginTransaction();

            TeamLoan loan = new TeamLoan();
            loan.setLogId(logId);
            loan.setBalance(balance);
            loan.setDateTime(new Date());

            session.persist(loan);

            //Withdraw balance from team
            int teamId = TeamLogController.getLog(logId).getResult().getTeamId();
            TeamController.withdrawBalance(teamId, balance);

            //Deposit balance to account
            int ownerDni = TeamLogController.getLog(logId).getResult().getUserDni();

            AccountController.addBalance(ownerDni, balance);
            session.getTransaction().commit();
                
            return new ResultPack<Boolean>(true, null, "The loan has been done successfully.");
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

    public static ResultPack<Boolean> loanExist(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(TeamLoan.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            session.beginTransaction();

            String sql = "SELECT Count(*) FROM TeamLoan WHERE id = :id";
            Query<Long> query = session.createQuery(sql, Long.class);
            query.setParameter("id", id);

            int count =  ((Number) query.uniqueResult()).intValue();

            if (count > 0)
            {
                return new ResultPack<Boolean>(true, true, "Loan found.");
            }

            else
            {
                return new ResultPack<Boolean>(true, false, new RecordNotFoundException().getMessage());
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

    public static ResultPack<TeamLoan> getLoan(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(TeamLoan.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Checking loan exists
            if(!(TeamLoanController.loanExist(id).getResult()))
            {
                throw new RecordNotFoundException();
            }

            session.beginTransaction();

            TeamLoan loan = session.get(TeamLoan.class, id);

            session.getTransaction().commit();;

            return new ResultPack<TeamLoan>(true, loan, "Loan found.");
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new ResultPack<TeamLoan>(false, null, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static ResultPack<Boolean> deleteLoan(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(TeamLoan.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Checking loan exists
            if(!(TeamLoanController.loanExist(id).getResult()))
            {
                throw new RecordNotFoundException();
            }

            session.beginTransaction();
            TeamLoan loan = TeamLoanController.getLoan(id).getResult();
            session.remove(loan);
            session.getTransaction().commit();

            return new ResultPack<Boolean>(true, null, "The loan has been deleted successfully.");
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

    public static ResultPack<List<Integer>> getLoanReport(int userDni)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(TeamLoan.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Checking user exists
            if(!(UserController.userExist(userDni).getResult()))
            {
                throw new UserNotFoundException();
            }

            List<Integer> teamLogIdReport = UserController.getLogIdReport(userDni).getResult();
            List<Integer> teamLoanIdReport = new ArrayList<Integer>();

            session.beginTransaction();

            for (Integer logId : teamLogIdReport) {
                String sql = "SELECT id FROM TeamLoan WHERE logId = :logId LIMIT 1";
                Query<Integer> query = session.createNativeQuery(sql, Integer.class);
                query.setParameter("logId", logId);
                teamLoanIdReport.add(query.uniqueResult());
            }

            session.getTransaction().commit();

            return new ResultPack<List<Integer>>(true, teamLoanIdReport, "The team loan report has been given.");
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new ResultPack<List<Integer>>(false, null, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }
}
