package org.davshaw.Controller;

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
                throw new IllegalArgumentException("No existe ningún registro con este ID.");
            }

            //Verificar que la cantidad a prestar < depositos históricos
            else if(TeamDepositController.totalDeposit(logId) < balance)
            {
                throw new IllegalArgumentException("El usuario ha depositado menos del valor a prestar.");
            }

            //Sino se lanzo alguna exceptión, todo está bien
            session.beginTransaction();

            TeamLoan prestamo = new TeamLoan();
            //Establecer datos con setters (Reemplazando el constructor)
            prestamo.setLogId(logId);
            prestamo.setBalance(balance);
            session.persist(prestamo);

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
            query.setParameter(sql, id);

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
                throw new IllegalArgumentException("No existe un prestamo con este id.");
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
                throw new IllegalArgumentException("No existe un prestamo registrado con este id.");
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
