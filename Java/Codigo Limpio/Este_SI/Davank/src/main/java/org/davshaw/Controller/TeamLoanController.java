package org.davshaw.Controller;

import org.davshaw.Exception.HaveNotDepositEnoughException;
import org.davshaw.Exception.InsufficientBalanceException;
import org.davshaw.Exception.RecordNotFoundException;
import org.davshaw.External.RequestResult;
import org.davshaw.Model.derivatedentities.TeamLoan;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class TeamLoanController
{
    public static RequestResult<Boolean> loan(int logId, double balance)
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

            session.persist(loan);

            //Withdraw balance from team
            int teamId = TeamLogController.getLog(logId).getResult().getTeamId();
            TeamController.withdrawBalance(teamId, balance);

            //Deposit balance to account
            int ownerDni = TeamLogController.getLog(logId).getResult().getUserDni();

            AccountController.addBalance(ownerDni, balance);
            session.getTransaction().commit();
                
            return new RequestResult<Boolean>(true, null, "The loan has been done successfully.");
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

    public static RequestResult<Boolean> loanExist(int id)
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
                return new RequestResult<Boolean>(true, true, "Loan found.");
            }

            else
            {
                return new RequestResult<Boolean>(true, false, new RecordNotFoundException().getMessage());
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

    public static RequestResult<TeamLoan> getLoan(int id)
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

            return new RequestResult<TeamLoan>(true, loan, "Loan found.");
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new RequestResult<TeamLoan>(false, null, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static RequestResult<Boolean> deleteLoan(int id)
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

            return new RequestResult<Boolean>(true, null, "The loan has been deleted successfully.");
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
