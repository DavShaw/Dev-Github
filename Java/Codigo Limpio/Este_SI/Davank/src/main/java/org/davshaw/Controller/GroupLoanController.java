package org.davshaw.Controller;

import org.davshaw.Model.derivatedentities.GroupLoan;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class GroupLoanController
{

    public static Boolean hacerPrestamo(int registroId, double monto)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(GroupLoan.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //verificar que exista el registro
            if(!(GroupLogController.existeRegistro(registroId)))
            {
                throw new IllegalArgumentException("No existe ningún registro con este ID.");
            }

            //Verificar que la cantidad a prestar < depositos históricos
            else if(GroupDepositController.totalDepositos(registroId) < monto)
            {
                throw new IllegalArgumentException("El usuario ha depositado menos del valor a prestar.");
            }

            //Sino se lanzo alguna exceptión, todo está bien
            session.beginTransaction();

            GroupLoan prestamo = new GroupLoan();
            //Establecer datos con setters (Reemplazando el constructor)
            prestamo.setLogId(registroId);
            prestamo.setBalance(monto);
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

    public static Boolean existePrestamo(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(GroupLoan.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            session.beginTransaction();

            String sql = "SELECT Count(*) FROM Prestamos WHERE id = :id";
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

    public static GroupLoan obtenerPrestamo(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(GroupLoan.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista el prestamo
            if(!(GroupLoanController.existePrestamo(id)))
            {
                throw new IllegalArgumentException("No existe un prestamo con este id.");
            }

            //Sino se lanzó la exception, existe el prestamo
            else
            {
                session.beginTransaction();

                GroupLoan prestamo = session.get(GroupLoan.class, id);

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

    public static Boolean eliminarPrestamo(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(GroupLoan.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista
            if(!(GroupLoanController.existePrestamo(id)))
            {
                throw new IllegalArgumentException("No existe un prestamo registrado con este id.");
            }
            session.beginTransaction();
            GroupLoan prestamo = GroupLoanController.obtenerPrestamo(id);
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
