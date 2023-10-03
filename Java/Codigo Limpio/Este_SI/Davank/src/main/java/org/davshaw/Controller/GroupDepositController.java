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

    public static Boolean hacerDeposito(int registroId, double monto)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(GroupDeposit.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que el registro exista
            if(GroupLogController.existeRegistro(registroId))
            {
                session.beginTransaction();

                //Obtener id del grupo y dni del usuario
                int grupoId = GroupLogController.obtenerGrupoId(registroId);
                int titularDni = GroupLogController.obtenerUsuarioDni(registroId);
                
                //Verificar que la cuenta tenga el dinero para depositar
                if(AccountController.tieneCantidad(titularDni, monto))
                {
                    //Retirar cantidad de la cuenta
                    AccountController.retirarSaldo(titularDni, monto);
                    //Agregar cantidad al grupo
                    GroupController.agregarSaldo(grupoId, monto);

                    //Crear el registro
                    GroupDeposit deposito = new GroupDeposit();
                    deposito.setDateTime(new Date());
                    deposito.setBalance(monto);
                    deposito.setLogId(registroId);

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

    public static Boolean existeDeposito(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(GroupDeposit.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            String sql = "SELECT count(*) FROM DepositoGrupo WHERE id = :id";
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

    public static GroupDeposit obtenerDeposito(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(GroupDeposit.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar si existe el registro del deposito
            if(!(GroupDepositController.existeDeposito(id)))
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

    public static Boolean eliminarDeposito(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(GroupDeposit.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {

            //Verificar que exista el deposito
            if(!(GroupDepositController.existeDeposito(id)))
            {
                throw new IllegalArgumentException("No existe un registro de deposito con este id.");
            }

            session.beginTransaction();
            GroupDeposit deposito = GroupDepositController.obtenerDeposito(id);
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

    public static Double totalDepositos(int registroId)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(GroupDeposit.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que el registro exista
            if(!(GroupLogController.existeRegistro(registroId)))
            {
                throw new IllegalArgumentException("No existe un registro con este id.");
            }

            //Obtener ID de registro de depositos que cumplan con el registroId
            String sql = "SELECT monto FROM DepositoGrupo WHERE (registroId = :registroId)";
            Query<Double> query = session.createNativeQuery(sql, Double.class);
            query.setParameter("registroId", registroId);

                        // Cambia de Double[] a List<Double>
            List<Double> totalesList = query.list();

            Double totalDepositado = 0.0;

            for (Double monto : totalesList)
            {
                totalDepositado += monto;
            }

            return totalDepositado;

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
