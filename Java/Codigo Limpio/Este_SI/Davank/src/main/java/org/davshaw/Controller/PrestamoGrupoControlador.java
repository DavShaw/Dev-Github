package org.davshaw.Controller;

import org.davshaw.Model.derivatedentities.PrestamoGrupo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class PrestamoGrupoControlador
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
        .addAnnotatedClass(Prestamos.class)
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

    public static Boolean hacerPrestamo(int registroId, double monto)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(PrestamoGrupo.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //verificar que exista el registro
            if(!(RegistroGrupoControlador.existeRegistro(registroId)))
            {
                throw new IllegalArgumentException("No existe ningún registro con este ID.");
            }

            //Verificar que la cantidad a prestar < depositos históricos
            else if(DepositoGrupoControlador.totalDepositos(registroId) < monto)
            {
                throw new IllegalArgumentException("El usuario ha depositado menos del valor a prestar.");
            }

            //Sino se lanzo alguna exceptión, todo está bien
            session.beginTransaction();

            PrestamoGrupo prestamo = new PrestamoGrupo();
            //Establecer datos con setters (Reemplazando el constructor)
            prestamo.setRegistroId(registroId);
            prestamo.setMonto(monto);
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
        .addAnnotatedClass(PrestamoGrupo.class)
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

    public static PrestamoGrupo obtenerPrestamo(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(PrestamoGrupo.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista el prestamo
            if(!(PrestamoGrupoControlador.existePrestamo(id)))
            {
                throw new IllegalArgumentException("No existe un prestamo con este id.");
            }

            //Sino se lanzó la exception, existe el prestamo
            else
            {
                session.beginTransaction();

                PrestamoGrupo prestamo = session.get(PrestamoGrupo.class, id);

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
        .addAnnotatedClass(PrestamoGrupo.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista
            if(!(PrestamoGrupoControlador.existePrestamo(id)))
            {
                throw new IllegalArgumentException("No existe un prestamo registrado con este id.");
            }
            session.beginTransaction();
            PrestamoGrupo prestamo = PrestamoGrupoControlador.obtenerPrestamo(id);
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
