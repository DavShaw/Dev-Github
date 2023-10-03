package org.davshaw.Controller;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.davshaw.Model.derivatedentities.GroupLog;
import org.davshaw.Model.pureentities.User;

public class UserController
{
    public static String createUser(
    int dni,
    String primerNombre,
    String segundoNombre,
    String primerApellido,
    String segundoApellido,
    String contraseña)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(User.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {

            User usuario = new User();
            
            //Establecer datos con setters (Reemplazando el constructor)
            usuario.setDni(dni);
            usuario.setFirstName(primerNombre);
            usuario.setMiddleName(segundoNombre);
            usuario.setFirstLastName(primerApellido);
            usuario.setMiddleLastName(segundoApellido);
            usuario.setPassword(contraseña);

            session.beginTransaction();
            
            session.persist(usuario);
            
            session.getTransaction().commit();
            
            //Controlador de Cuentas
            AccountController.createAccount(dni);
            

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

    public static Boolean userExist(int dni)
    {
        SessionFactory sessionFactory = new
        Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(User.class)
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

    public String deleteUser(int dni)
    {
        SessionFactory sessionFactory = new
        Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(User.class)
        .buildSessionFactory();
    
        Session session = sessionFactory.openSession();
    
        try
        {
            if((UserController.userExist(dni)))
            {
                User usuario = session.get(User.class, dni);
                
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

    public static User getUser(int dni)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(User.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            session.beginTransaction();

            User usuario = session.get(User.class, dni);

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

    public static String changeFirstName(int dni, String nombre)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(User.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista
            if(UserController.userExist(dni))
            {
                session.beginTransaction();

                User usuario = session.get(User.class, dni);

                usuario.setFirstName(nombre);
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

    public static String changeMiddleName(int dni, String nombre)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(User.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista
            if(UserController.userExist(dni))
            {
                session.beginTransaction();

                User usuario = session.get(User.class, dni);

                usuario.setMiddleName(nombre);
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

    public static String changeFirstLastName(int dni, String apellido)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(User.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista
            if(UserController.userExist(dni))
            {
                session.beginTransaction();

                User usuario = session.get(User.class, dni);

                usuario.setFirstLastName(apellido);
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

    public static String changeMiddleLastName(int dni, String apellido)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(User.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista
            if(UserController.userExist(dni))
            {
                session.beginTransaction();

                User usuario = session.get(User.class, dni);

                usuario.setMiddleLastName(apellido);
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

    public static String changePassword(int dni, String contrasena, String nuevaContrasena)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(User.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //!Verificar que exista
            if(UserController.userExist(dni))
            {
                session.beginTransaction();
                User usuario = session.get(User.class, dni);
                //!Verificar que la contraseña concuerde
                if(usuario.getPassword().equals(contrasena))
                {
                    usuario.setPassword(nuevaContrasena);
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

    public static Integer countGroup(int usuariodni)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(User.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que el usuario exista
            if(!(UserController.userExist(usuariodni)))
            {
                throw new IllegalArgumentException("No existe un usuario con este dni.");
            }

            session.beginTransaction();

            String sql = "SELECT Count(*) FROM RegistroGrupo WHERE (usuariodni = :usuariodni and nativo = :nativo)";
            Query<Long> query = session.createNativeQuery(sql, Long.class);
            query.setParameter("usuariodni", usuariodni);
            query.setParameter("nativo", true);
            session.getTransaction().commit();

            int count = Integer.valueOf(query.uniqueResult().toString());
            return count;
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

    public static Boolean joinGroup(int usuariodni, int grupoid)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(User.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que el grupo exista
            if(!(GroupController.groupExist(grupoid)))
            {
                throw new IllegalArgumentException("No existe un grupo con este id.");
            }
            
            //Verificar que el usuario no este en mas de >= 3 grupos
            else if(UserController.countGroup(usuariodni) >= 3)
            {
                throw new IllegalArgumentException("El usuario está en el máximo de grupos permitidos.");
            }
            session.beginTransaction();

            GroupLog registro = new GroupLog();
            registro.setGroupId(grupoid);
            registro.setNativeFlag(true);
            registro.setOwnerDni(usuariodni);

            session.persist(registro);

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

    public static Boolean leaveGroup(int usuariodni, int grupoid)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(User.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que el usuario este en al menos un grupo
            if(UserController.countGroup(usuariodni) <= 0)
            {
                throw new IllegalArgumentException("El usuario no está en ningún grupo.");
            }

            //Verificar que el grupo exista
            else if(!(GroupController.groupExist(grupoid)))
            {
                throw new IllegalArgumentException("No existe un grupo con este id.");
            }

            //Obtener ID del registro
            Integer registroId = UserController.getLogId(usuariodni, grupoid);

            //Verificar que el registroId no sea null (No existe el registro)
            if (registroId == null)
            {
                throw new IllegalArgumentException("No se encontró que el usuario éste en un grupo con este id.");
            }

            session.beginTransaction();

            GroupLog registro = GroupLogController.getLog(registroId);
            session.remove(registro);

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

    public static Integer getLogId(int usuariodni, int grupoid)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(User.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que el grupo exista
            if(!(GroupController.groupExist(grupoid)))
            {
                throw new IllegalArgumentException("No existe un grupo con este id.");
            }

            //Verificar que el usuario exista
            else if(!(UserController.userExist(usuariodni)))
            {
                throw new IllegalArgumentException("No existe un usuario con este dni.");
            }

            session.beginTransaction();

            String sql = "SELECT id FROM RegistroGrupo WHERE (grupoid = :grupoid AND usuariodni = :usuariodni AND nativo = :nativo)";
            Query<Integer> query = session.createNativeQuery(sql, Integer.class);
            query.setParameter("usuariodni", usuariodni);
            query.setParameter("grupoid", grupoid);
            query.setParameter("nativo", true);


            Integer id = (Integer) query.uniqueResult();

            session.getTransaction().commit();

            return id;
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


