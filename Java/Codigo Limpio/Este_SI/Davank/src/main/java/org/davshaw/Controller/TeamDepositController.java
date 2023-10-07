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
            //Verificar que el registro exista
            if(TeamLogController.logExist(logId).getResult())
            {
                throw new RecordNotFoundException();
            }

            //! (La validación depende de la pasada)
            //Verificar que la cuenta tenga el dinero para depositar
            int grupoId = TeamLogController.getteamId(logId).getResult();
            int titularDni = TeamLogController.getOwnerDni(logId).getResult();

            if(AccountController.hasEnough(titularDni, balance).getResult())
            {
                throw new InsufficientBalanceException();
            }
            
            session.beginTransaction();
                
            //Retirar cantidad de la cuenta
            AccountController.withdrawBalance(titularDni, balance);
            //Agregar cantidad al grupo
            TeamController.addBalance(grupoId, balance);

            //Crear el registro
            TeamDeposit deposito = new TeamDeposit();
            deposito.setDateTime(new Date());
            deposito.setBalance(balance);
            deposito.setLogId(logId);

            session.persist(deposito);

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
            //Verificar si existe el registro del deposito
            if(!(TeamDepositController.depositExist(id).getResult()))
            {
                throw new RecordNotFoundException();
            }
            session.beginTransaction();

            TeamDeposit deposito = session.get(TeamDeposit.class, id);
            session.getTransaction().commit();

            return new RequestResult<TeamDeposit>(true, deposito, "Deposit found.");
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

            //Verificar que exista el deposito
            if(!(TeamDepositController.depositExist(id).getResult()))
            {
                throw new RecordNotFoundException();
            }

            session.beginTransaction();
            TeamDeposit deposito = TeamDepositController.getDeposit(id).getResult();
            session.remove(deposito);
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
            //Verificar que el registro exista
            if(!(TeamLogController.logExist(logId).getResult()))
            {
                throw new RecordNotFoundException();
            }

            //Obtener ID de registro de depositos que cumplan con el logId
            String sql = "SELECT SUM(balance) FROM TeamDeposit WHERE logId = :logId";
            Query<Double> query = session.createNativeQuery(sql, Double.class);
            query.setParameter("logId", logId);

            Double total = query.uniqueResult();
            
            //Return condition ? valueIfTrue : valueIfFalse -> Conditional operator
            RequestResult<Double> returnIfTrue = new RequestResult<Double>(true, total, "Deposit found.");
            RequestResult<Double> returnIfFalse = new RequestResult<Double>(false, 0.0, "Unknown error... Plz fixme");
            return (total != null) ? returnIfTrue : returnIfFalse;
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
