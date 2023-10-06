package org.davshaw.Controller;

import org.davshaw.Exception.InsufficientBalanceException;
import org.davshaw.Exception.RecordNotFoundException;
import org.davshaw.Model.derivatedentities.TeamLoan;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class TeamLoanController
{
    public static Boolean loan(int logId, double balance)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(TeamLoan.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //verificar que exista el registro
            if(!(TeamLogController.logExist(logId)))
            {
                throw new RecordNotFoundException();
            }

            //Verificar que la cantidad a prestar < depositos históricos
            else if(TeamDepositController.totalDeposit(logId) < balance)
            {
                throw new InsufficientBalanceException();
            }

            //Verificar que el grupo tenga la cantidad necesaria
            else if(TeamLogController.getLog(logId).getTeam().getBalance() < balance)
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
            int teamId = TeamLogController.getLog(logId).getTeamId();
            TeamController.withdrawalBalance(teamId, balance);

            //Añadir saldo a la cuenta
            int ownerDni = TeamLogController.getLog(logId).getUserDni();
            AccountController.addBalance(ownerDni, balance);
            

            session.getTransaction().commit();
                
                return true;
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

    public static Boolean loanExist(int id)
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

    public static TeamLoan getLoan(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(TeamLoan.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista el prestamo
            if(!(TeamLoanController.loanExist(id)))
            {
                throw new RecordNotFoundException();
            }

            //Sino se lanzó la exception, existe el prestamo
            else
            {
                session.beginTransaction();

                TeamLoan prestamo = session.get(TeamLoan.class, id);

                session.getTransaction().commit();;

                return prestamo;
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

    public static Boolean deleteLoan(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(TeamLoan.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista
            if(!(TeamLoanController.loanExist(id)))
            {
                throw new RecordNotFoundException();
            }

            session.beginTransaction();
            TeamLoan prestamo = TeamLoanController.getLoan(id);
            session.remove(prestamo);
            session.getTransaction().commit();

            return true;
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
