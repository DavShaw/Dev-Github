package org.davshaw.controller;

import org.davshaw.model.RegistroGrupos;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class GroupLogs
{
    /*
    ! CRUD
    ! C - Create DONE
    ! R - Read TO DO
    ! U - Update TO DO
    ! D - Delete  TO DO

    ? Hibernate structure

    SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(RegistroGrupos.class)
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

    public String crearRegistro(int usuarioDni, int grupoId)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(RegistroGrupos.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista el usuario
            if(!(UserController.existeUsuario(usuarioDni)))
            {
                throw new IllegalArgumentException("No existe un usuario con este DNI.");
            }
            //Verificar que exista el grupo
            else if (!(GroupController.existeGrupo(grupoId)))
            {
                throw new IllegalArgumentException("No existe un grupo con este ID.");
            }
            //Sino se lanzaron esas exceptions, entonces tenemos todo lo necesario
            else
            {
                session.beginTransaction();

                RegistroGrupos registro = new RegistroGrupos(usuarioDni, grupoId);

                session.persist(registro);
                session.getTransaction().commit();

                return "Registro de grupo creado con éxito";
            }
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return "Error al hacer el registro de grupo";
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static boolean existeRegistro(int id)
    {
        SessionFactory sessionFactory = new
        Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(RegistroGrupos.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();
    

        try
        {
            String sql = "SELECT COUNT(*) FROM RegistroGrupos WHERE id = :di";
            Query<Long> query = session.createNativeQuery(sql, Long.class);
            query.setParameter("id", id);

    
            // Obtener el resultado de la consulta (cantidad de usuarios con el DNI dado)
            int count = ((Number) query.uniqueResult()).intValue();
    
            // Si count es mayor que 0, significa que existe un usuario con ese DNI
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

    public RegistroGrupos obtenerRegistro(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(RegistroGrupos.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            session.beginTransaction();

            RegistroGrupos registro = session.get(RegistroGrupos.class, id);

            session.getTransaction().commit();

            return registro;
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

    public Integer obtenerUsuarioDni(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(RegistroGrupos.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista el registro
            if(!(GroupLogs.existeRegistro(id)))
            {
                throw new IllegalArgumentException("No existe un registro con este id.");
            }

            //Obtener objeto
            RegistroGrupos registro = this.obtenerRegistro(id);

            return registro.getUsuarioDni();
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

    public Integer obtenerGrupoId(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(RegistroGrupos.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista el registro
            if(!(GroupLogs.existeRegistro(id)))
            {
                throw new IllegalArgumentException("No existe un registro con este id.");
            }

            //Obtener objeto
            RegistroGrupos registro = this.obtenerRegistro(id);

            return registro.getGrupoId();
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

    public Boolean obtenerNatividad(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(RegistroGrupos.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista el registro
            if(!(GroupLogs.existeRegistro(id)))
            {
                throw new IllegalArgumentException("No existe un registro con este id.");
            }

            //Obtener objeto
            RegistroGrupos registro = this.obtenerRegistro(id);

            return registro.getNativo();
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
