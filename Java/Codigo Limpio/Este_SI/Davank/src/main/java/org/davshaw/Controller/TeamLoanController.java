package org.davshaw.Controller;

import org.davshaw.Exception.HaventDepositEnoughException;
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
            //verificar que exista el registro
            if(!(TeamLogController.logExist(logId).getResult()))
            {
                throw new RecordNotFoundException();
            }

            //Verificar que la cantidad a prestar < depositos históricos
            if(TeamDepositController.totalDeposit(logId).getResult() < balance)
            {
                throw new HaventDepositEnoughException();
            }

            //Verificar que el grupo tenga la cantidad necesaria
            if(TeamLogController.getLog(logId).getResult().getTeam().getBalance() < balance)
            {
                throw new InsufficientBalanceException();
            }

            //Sino se lanzo alguna exceptión, todo está bien
            session.beginTransaction();

            TeamLoan prestamo = new TeamLoan();
            //Establecer datos con setters (Reemplazando el constructor)
            prestamo.setLogId(logId);
            prestamo.setBalance(balance);
            session.persist(prestamo);

            //Retirar saldo del equipo
            int teamId = TeamLogController.getLog(logId).getResult().getTeamId();
            TeamController.withdrawBalance(teamId, balance);

            //Añadir saldo a la cuenta
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
            //Verificar que exista el prestamo
            if(!(TeamLoanController.loanExist(id).getResult()))
            {
                throw new RecordNotFoundException();
            }

            session.beginTransaction();

            TeamLoan prestamo = session.get(TeamLoan.class, id);

            session.getTransaction().commit();;

            return new RequestResult<TeamLoan>(true, prestamo, "Loan found.");
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
            //Verificar que exista
            if(!(TeamLoanController.loanExist(id).getResult()))
            {
                throw new RecordNotFoundException();
            }

            session.beginTransaction();
            TeamLoan prestamo = TeamLoanController.getLoan(id).getResult();
            session.remove(prestamo);
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
