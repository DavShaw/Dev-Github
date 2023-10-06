package org.davshaw.Controller;

import java.util.Date;

import org.davshaw.Exception.InsufficientBalanceException;
import org.davshaw.Exception.RecordNotFoundException;
import org.davshaw.Model.derivatedentities.TeamDeposit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class TeamDepositController
{
    public static Boolean deposit(int logId, double balance)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(TeamDeposit.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que el registro exista
            if(TeamLogController.logExist(logId))
            {
                session.beginTransaction();

                //Obtener id del grupo y dni del usuario
                int grupoId = TeamLogController.getteamId(logId);
                int titularDni = TeamLogController.getOwnerDni(logId);
                
                //Verificar que la cuenta tenga el dinero para depositar
                if(AccountController.hasEnough(titularDni, balance))
                {
                    //Retirar cantidad de la cuenta
                    AccountController.withdrawalBalance(titularDni, balance);
                    //Agregar cantidad al grupo
                    TeamController.addBalance(grupoId, balance);

                    //Crear el registro
                    TeamDeposit deposito = new TeamDeposit();
                    deposito.setDateTime(new Date());
                    deposito.setBalance(balance);
                    deposito.setLogId(logId);

                    session.persist(deposito);

                    session.getTransaction().commit();

                    
                    

                    return true;
                }
                
                else
                {
                    throw new InsufficientBalanceException();
                }
            }

            else
            {
                throw new RecordNotFoundException();
            }
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

    public static Boolean depositExist(int id)
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

    public static TeamDeposit getDeposit(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(TeamDeposit.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar si existe el registro del deposito
            if(!(TeamDepositController.depositExist(id)))
            {
                throw new RecordNotFoundException();
            }
            session.beginTransaction();

            TeamDeposit deposito = session.get(TeamDeposit.class, id);
            session.getTransaction().commit();
            return deposito;
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

    public static Boolean deleteDeposit(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(TeamDeposit.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {

            //Verificar que exista el deposito
            if(!(TeamDepositController.depositExist(id)))
            {
                throw new RecordNotFoundException();
            }

            session.beginTransaction();
            TeamDeposit deposito = TeamDepositController.getDeposit(id);
            session.remove(deposito);
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

    public static Double totalDeposit(int logId)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(TeamDeposit.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que el registro exista
            if(!(TeamLogController.logExist(logId)))
            {
                throw new RecordNotFoundException();
            }

            //Obtener ID de registro de depositos que cumplan con el logId
            String sql = "SELECT SUM(balance) FROM TeamDeposit WHERE logId = :logId";
            Query<Double> query = session.createNativeQuery(sql, Double.class);
            query.setParameter("logId", logId);

            Double total = query.uniqueResult();
            
            //Return condition ? valueIfTrue : valueIfFalse -> Conditional operator
            return (total != null) ? total : 0.0;
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return 0.0;
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }
}
