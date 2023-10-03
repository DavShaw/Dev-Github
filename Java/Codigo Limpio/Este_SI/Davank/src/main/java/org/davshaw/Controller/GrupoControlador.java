package org.davshaw.Controller;

import org.davshaw.Model.pureentities.Group;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class GrupoControlador
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
        .addAnnotatedClass(Grupo.class)
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

    public static String crearGrupo(String nombre)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Group.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            session.beginTransaction();
            
            Group grupo = new Group();
            //Establecer datos con setters (Reemplazando el constructor)
            grupo.setNombre(nombre);

            session.persist(grupo);

            session.getTransaction().commit();
            return "Grupo creado con éxito.";
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return "Error al crear el grupo.";
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static Boolean existeGrupo(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Group.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            String sql = "SELECT count(*) FROM Grupo WHERE id = :id";
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

    public static Group obtenerGrupo(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Group.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            if(GrupoControlador.existeGrupo(id))
            {
                session.beginTransaction();

                Group grupo = session.get(Group.class, id);

                session.getTransaction().commit();

                return grupo;
            }
            
            else
            {
                throw new IllegalArgumentException("No existe un grupo con este id.");
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

    public static Integer obtenerNumeroIntegrates(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Group.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            if(GrupoControlador.existeGrupo(id))
            {
                session.beginTransaction();

                Group grupo = session.get(Group.class, id);

                session.getTransaction().commit();

                return grupo.getNumeroIntegrantes();
            }
            
            else
            {
                throw new IllegalArgumentException("No existe un grupo con este id.");
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

    public static String agregarIntegrante(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Group.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            if(GrupoControlador.existeGrupo(id))
            {
                session.beginTransaction();

                Group grupo = GrupoControlador.obtenerGrupo(id);

                //Editar número integrantes
                int nuevoNumeroIntegrantes = grupo.getNumeroIntegrantes() + 1;
                grupo.setNumeroIntegrantes(nuevoNumeroIntegrantes);

                session.merge(grupo);

                session.getTransaction().commit();

                return "Se ha añadido un integrante al grupo";

            }
            
            else
            {
                throw new IllegalArgumentException("No existe un grupo con este id.");
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

    public static String retirarIntegrante(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Group.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            if(GrupoControlador.existeGrupo(id))
            {
                session.beginTransaction();

                Group grupo = GrupoControlador.obtenerGrupo(id);

                //Editar número integrantes
                int nuevoNumeroIntegrantes = grupo.getNumeroIntegrantes() - 1;
                grupo.setNumeroIntegrantes(nuevoNumeroIntegrantes);

                session.merge(grupo);

                session.getTransaction().commit();

                return "Se ha removido un integrante al grupo";

            }
            
            else
            {
                throw new IllegalArgumentException("No existe un grupo con este id.");
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

    public static Double obtenersaldo(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Group.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            if(GrupoControlador.existeGrupo(id))
            {
                session.beginTransaction();

                Group grupo = session.get(Group.class, id);

                session.getTransaction().commit();

                return grupo.getSaldo();
            }
            
            else
            {
                throw new IllegalArgumentException("No existe un grupo con este id.");
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

    public static String agregarSaldo(int id, double monto)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Group.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            if(monto < 0)
            {
                throw new IllegalArgumentException("El monto no puede ser negativo.");
            }

            else if(GrupoControlador.existeGrupo(id))
            {
                session.beginTransaction();

                Group grupo = GrupoControlador.obtenerGrupo(id);

                //Editar saldo
                double nuevoSaldo = grupo.getSaldo() + monto;
                grupo.setSaldo(nuevoSaldo);

                session.merge(grupo);

                session.getTransaction().commit();

                return "Se ha agregado saldo al grupo.";

            }
            
            else
            {
                throw new IllegalArgumentException("No existe un grupo con este id.");
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

    public static String retirarSaldo(int id, double monto)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Group.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            if(monto < 0)
            {
                throw new IllegalArgumentException("El monto no puede ser negativo.");
            }

            else if(GrupoControlador.existeGrupo(id))
            {
                session.beginTransaction();

                Group grupo = GrupoControlador.obtenerGrupo(id);

                //Editar saldo
                double nuevoSaldo = grupo.getSaldo() - monto;
                grupo.setSaldo(nuevoSaldo);

                session.merge(grupo);

                session.getTransaction().commit();

                return "Se ha retirado saldo al grupo.";

            }
            
            else
            {
                throw new IllegalArgumentException("No existe un grupo con este id.");
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




}
