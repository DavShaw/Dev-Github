package org.davshaw.controller;

import org.davshaw.classes.Cuenta;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CuentaController
{

    /*
    ! CRUD
    ! C - Create DONE
    ! R - Read DONE
    ! U - Update DONE
    ! D - Delete  DONE

    ? Hibernate structure

    SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Cuenta.class)
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

    public String crearCuenta(int dni)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Cuenta.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que no exista otra cuenta con el titularDni igual
            if(!this.existeCuenta(dni))
            {
                Cuenta cuenta = new Cuenta(dni);
                session.beginTransaction();
                session.persist(cuenta);
                session.getTransaction().commit();
                return "Cuenta creada con éxito.";
            }

            else
            {
                throw new IllegalArgumentException("Ya existe una cuenta asociada a este usuario.");
            }
            

        }

        catch (Exception e)
        {
            e.printStackTrace();
            return "Error al crear cuenta.";
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public Boolean existeCuenta(int titularDni)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Cuenta.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            String sql = "SELECT count(*) FROM Cuenta WHERE titularDni = :titularDni";
            Query<Long> query = session.createNativeQuery(sql, Long.class);
            query.setParameter("titularDni", titularDni);
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

    public Integer obtenerNumeroCuenta(int titularDni)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Cuenta.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            String sql = "SELECT numeroCuenta FROM Cuenta WHERE titularDni = :titularDni LIMIT 1;";
            Query<Long> query = session.createNativeQuery(sql, Long.class);
            query.setParameter("titularDni", titularDni);
            int numeroCuenta = ((Number) query.uniqueResult()).intValue();

            return numeroCuenta;
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

    public Cuenta obtenerCuenta(int titularDni)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Cuenta.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar si existe cuenta con titularDni
            if(this.existeCuenta(titularDni))
            {
                session.beginTransaction();

                Cuenta cuenta = session.get(Cuenta.class, this.obtenerNumeroCuenta(titularDni));

                session.getTransaction().commit();
                return cuenta;
            }
            else
            {
                throw new IllegalArgumentException("No existe una cuenta asociada a este titular.");
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

    public String agregarSaldo(int titularDni, double monto)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Cuenta.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            if (monto < 0)
            {
                throw new IllegalArgumentException("El monto no puede ser negativo");
            }

            else if(this.existeCuenta(titularDni))
            {
                session.beginTransaction();

                Cuenta cuenta = session.get(Cuenta.class, this.obtenerNumeroCuenta(titularDni));

                //Obtener saldo actual
                double nuevoSaldo = cuenta.getSaldo() + monto;
                cuenta.setSaldo(nuevoSaldo);

                session.merge(cuenta);

                session.getTransaction().commit();

                return "Saldo añadido con éxito.";
            }
            
            else
            {
                throw new IllegalArgumentException("No existe una cuenta asociada a este titular.");
            }
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return "Error al agregar saldo.";
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public String retirarSaldo(int titularDni, double monto)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Cuenta.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            if (monto < 0)
            {
                throw new IllegalArgumentException("El monto no puede ser negativo");
            }

            else if(this.existeCuenta(titularDni))
            {
                session.beginTransaction();

                Cuenta cuenta = session.get(Cuenta.class, this.obtenerNumeroCuenta(titularDni));

                //Obtener saldo actual
                double nuevoSaldo = cuenta.getSaldo() - monto;
                cuenta.setSaldo(nuevoSaldo);

                session.merge(cuenta);

                session.getTransaction().commit();

                return "Saldo retirado con éxito.";
            }
            
            else
            {
                throw new IllegalArgumentException("No existe una cuenta asociada a este titular.");
            }
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return "Error al retirar saldo.";
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public Double obtenerSaldo(int titularDni)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Cuenta.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            if(this.existeCuenta(titularDni))
            {
                Cuenta cuenta = this.obtenerCuenta(titularDni);
                return cuenta.getSaldo();
            }
            
            else
            {
                throw new IllegalArgumentException("No existe una cuenta asociada a este titular.");
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

    public String eliminarCuenta(int titularDni)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Cuenta.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            if(this.existeCuenta(titularDni))
            {
                session.beginTransaction();

                Cuenta cuenta = session.get(Cuenta.class, this.obtenerNumeroCuenta(titularDni));

                session.remove(cuenta);

                session.getTransaction().commit();

                return "Cuenta eliminada con éxito.";
            }
            
            else
            {
                throw new IllegalArgumentException("No existe una cuenta asociada a este titular.");
            }
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return "Error al eliminar cuenta.";
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }



}