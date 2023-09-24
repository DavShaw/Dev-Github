package org.davshaw.controller;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.davshaw.model.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UserController
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
        .addAnnotatedClass(Usuario.class)
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

    public String crearUsuario(
    int dni,
    String primerNombre,
    String segundoNombre,
    String primerApellido,
    String segundoApellido,
    String contraseña)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Usuario.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {

            Usuario usuario = new
            Usuario(
            dni,
            primerNombre,
            segundoNombre,
            primerApellido,
            segundoApellido,
            contraseña);

            session.beginTransaction();
            session.persist(usuario);
            
            //Controlador de Cuentas
            AccountController.crearCuenta(dni);
            
            session.getTransaction().commit();

            return "Usuario creado correctamente.";
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return "Error al crear usuario.";
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }

    }

    public static Boolean existeUsuario(int dni)
    {
        SessionFactory sessionFactory = new
        Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Usuario.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();
    

        try
        {
            String sql = "SELECT COUNT(*) FROM Usuario WHERE dni = :dni";
            Query<Long> query = session.createNativeQuery(sql, Long.class);
            query.setParameter("dni", dni);

    
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

    public String eliminarUsuario(int dni)
    {
        SessionFactory sessionFactory = new
        Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Usuario.class)
        .buildSessionFactory();
    
        Session session = sessionFactory.openSession();
    
        try
        {
            if((UserController.existeUsuario(dni)))
            {
                Usuario usuario = session.get(Usuario.class, dni);
                
                session.beginTransaction();
                session.remove(usuario);
                session.getTransaction().commit();
                sessionFactory.close();
                
                return "Usuario eliminado con éxito.";    
            }

            else
            {
                throw new IllegalStateException("Aja");
            }
            

        }
        
        catch (Exception e)
        {
            e.printStackTrace();
            return "Error al eliminar usuario.";
        }
        
        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public Usuario obtenerUsuario(int dni)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Usuario.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            session.beginTransaction();

            Usuario usuario = session.get(Usuario.class, dni);

            session.getTransaction().commit();

            return usuario;
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

    public String cambiarPrimerNombre(int dni, String nombre)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Usuario.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista
            if(UserController.existeUsuario(dni))
            {
                session.beginTransaction();

                Usuario usuario = session.get(Usuario.class, dni);

                usuario.setPrimerNombre(nombre);
                session.merge(usuario);

                session.getTransaction().commit();

                return "Primer nombre cambiado con éxito.";
                

            }

            else
            {
                throw new IllegalArgumentException("No existe un usuario con este DNI");
            }

        }

        catch (Exception e)
        {
            e.printStackTrace();
            return "Error al cambiar el primer nombre.";
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public String cambiarSegundoNombre(int dni, String nombre)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Usuario.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista
            if(UserController.existeUsuario(dni))
            {
                session.beginTransaction();

                Usuario usuario = session.get(Usuario.class, dni);

                usuario.setSegundoNombre(nombre);
                session.merge(usuario);

                session.getTransaction().commit();

                return "Segundo nombre cambiado con éxito.";
                

            }

            else
            {
                throw new IllegalArgumentException("No existe un usuario con este DNI");
            }

        }

        catch (Exception e)
        {
            e.printStackTrace();
            return "Error al cambiar el segundo nombre.";
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public String cambiarPrimerApellido(int dni, String apellido)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Usuario.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista
            if(UserController.existeUsuario(dni))
            {
                session.beginTransaction();

                Usuario usuario = session.get(Usuario.class, dni);

                usuario.setPrimerApellido(apellido);
                session.merge(usuario);

                session.getTransaction().commit();

                return "Primer apellido cambiado con éxito.";
                

            }

            else
            {
                throw new IllegalArgumentException("No existe un usuario con este DNI");
            }

        }

        catch (Exception e)
        {
            e.printStackTrace();
            return "Error al cambiar el primer apellido.";
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public String cambiarSegundoApellido(int dni, String apellido)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Usuario.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista
            if(UserController.existeUsuario(dni))
            {
                session.beginTransaction();

                Usuario usuario = session.get(Usuario.class, dni);

                usuario.setSegundoApellido(apellido);
                session.merge(usuario);

                session.getTransaction().commit();

                return "Segundo appelido cambiado con éxito.";
                

            }

            else
            {
                throw new IllegalArgumentException("No existe un usuario con este DNI");
            }

        }

        catch (Exception e)
        {
            e.printStackTrace();
            return "Error al cambiar el segundo apellido.";
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public String cambiarContrasena(int dni, String contrasena, String nuevaContrasena)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Usuario.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //!Verificar que exista
            if(UserController.existeUsuario(dni))
            {
                session.beginTransaction();
                Usuario usuario = session.get(Usuario.class, dni);
                //!Verificar que la contraseña concuerde
                if(usuario.getContraseña().equals(contrasena))
                {
                    usuario.setContraseña(nuevaContrasena);
                    session.merge(usuario);
    
                    session.getTransaction().commit();
    
                    return "Contraseña cambiado con éxito.";
                }

                else
                {
                throw new IllegalArgumentException("Credenciales inválidas.");
                }
            }

            else
            {
                throw new IllegalArgumentException("No existe un usuario con este DNI");
            }

        }

        catch (Exception e)
        {
            e.printStackTrace();
            return "Error al cambiar la contraseña.";
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }
}


