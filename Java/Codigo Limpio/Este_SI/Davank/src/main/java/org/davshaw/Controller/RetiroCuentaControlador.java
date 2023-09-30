package org.davshaw.Controller;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Date;

import org.davshaw.Model.derivatedentities.DepositoCuenta;
import org.davshaw.Model.derivatedentities.RetiroCuenta;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RetiroCuentaControlador
{

    /*
    ! CRUD
    ! C - Create DONE
    ! R - Read DONE
    ! U - Update DOESNT APPLY
    ! D - Delete  DONE

    ? Hibernate structure

    SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(RetiroCuenta.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            session.beginTransaction();
            session.persist(usuario);
            session.getTransaction().commit();
            

            return TORETURN;
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return TORETURN;
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    */

    public static Boolean hacerRetiro(int titularDniCuenta, double monto)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(DepositoCuenta.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar si existe una cuenta asociada a este dni
            if(!(CuentaControlador.existeCuenta(titularDniCuenta)))
            {
                throw new IllegalArgumentException("No existe una cuenta asociada a este dni.");
            }
            //Verificar que el monto de la cuenta sea mayor o igual al monto a retirar
            if(!(CuentaControlador.obtenerSaldo(titularDniCuenta) >= monto))
            {
                throw new IllegalArgumentException("El monto a retirar supera el saldo de la cuenta.");
            }

            //Si ninguna de las anteriores se lanzó, podemos hacer el retiro
            else
            {
                session.beginTransaction();

                CuentaControlador.retirarSaldo(titularDniCuenta, monto);
                //Crear registro del retiro
                RetiroCuenta retiro = new RetiroCuenta();
                retiro.setFechaHora(new Date());
                retiro.setMonto(monto);
                retiro.setNumeroCuenta(CuentaControlador.obtenerNumeroCuenta(titularDniCuenta));

                session.persist(retiro);
                session.getTransaction().commit();
                return true;
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

    public static Boolean existeRetiro(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(RetiroCuenta.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            String sql = "SELECT count(*) FROM RetiroCuenta WHERE id = :id";
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

    public static RetiroCuenta obtenerRetiro(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(RetiroCuenta.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista el registro del deposito
            if(!(RetiroCuentaControlador.existeRetiro(id)))
            {
                throw new IllegalArgumentException("No existe un retiro registrado con este id.");
            }

            else
            {
                session.beginTransaction();

                RetiroCuenta retiro = session.get(RetiroCuenta.class, id);

                session.getTransaction().commit();

                return retiro;
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

    public static Boolean eliminarRetiro(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(RetiroCuenta.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista el registro del deposito
            if(!(RetiroCuentaControlador.existeRetiro(id)))
            {
                throw new IllegalArgumentException("No existe un retiro registrado con este id.");
            }

            else
            {
                session.beginTransaction();

                RetiroCuenta retiro = RetiroCuentaControlador.obtenerRetiro(id);
                
                session.remove(retiro);
                
                session.getTransaction().commit();

                return true;
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

}