package org.davshaw.Controller;

import java.util.Date;
import java.util.List;

import org.davshaw.Model.derivatedentities.GroupDeposit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class GroupDepositController
{
    public static Boolean deposit(int logId, double balance)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(GroupDeposit.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que el registro exista
            if(GroupLogController.logExist(logId))
            {
                session.beginTransaction();

                //Obtener id del grupo y dni del usuario
                int grupoId = GroupLogController.getGroupId(logId);
                int titularDni = GroupLogController.getOwnerDni(logId);
                
                //Verificar que la cuenta tenga el dinero para depositar
                if(AccountController.hasEnough(titularDni, balance))
                {
                    //Retirar cantidad de la cuenta
                    AccountController.withdrawalBalance(titularDni, balance);
                    //Agregar cantidad al grupo
                    GroupController.addBalance(grupoId, balance);

                    //Crear el registro
                    GroupDeposit deposito = new GroupDeposit();
                    deposito.setDateTime(new Date());
                    deposito.setBalance(balance);
                    deposito.setLogId(logId);

                    session.persist(deposito);

                    session.getTransaction().commit();

                    
                    

                    return true;
                }
                
                else
                {
                    throw new IllegalArgumentException("No hay suficientes fondos para hacer el deposito.");
                }
            }

            else
            {
                throw new IllegalArgumentException("No existe un registro de grupo con este id.");
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
        .addAnnotatedClass(GroupDeposit.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            String sql = "SELECT count(*) FROM GroupDeposit WHERE id = :id";
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

    public static GroupDeposit getDeposit(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(GroupDeposit.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar si existe el registro del deposito
            if(!(GroupDepositController.depositExist(id)))
            {
                throw new IllegalArgumentException("No existe un registro de deposito con este id.");
            }
            session.beginTransaction();

            GroupDeposit deposito = session.get(GroupDeposit.class, id);
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
        .addAnnotatedClass(GroupDeposit.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {

            //Verificar que exista el deposito
            if(!(GroupDepositController.depositExist(id)))
            {
                throw new IllegalArgumentException("No existe un registro de deposito con este id.");
            }

            session.beginTransaction();
            GroupDeposit deposito = GroupDepositController.getDeposit(id);
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
        .addAnnotatedClass(GroupDeposit.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que el registro exista
            if(!(GroupLogController.logExist(logId)))
            {
                throw new IllegalArgumentException("No existe un registro con este id.");
            }

            //Obtener ID de registro de depositos que cumplan con el logId
            String sql = "SELECT SUM(monto) FROM GroupDeposit WHERE logId = :logId";
            Query<Double> query = session.createNativeQuery(sql, Double.class);
            query.setParameter("logId", logId);

            double total = query.uniqueResult();
            
            return total;
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
