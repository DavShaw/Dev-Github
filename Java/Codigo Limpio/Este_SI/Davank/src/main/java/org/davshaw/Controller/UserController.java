package org.davshaw.Controller;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.davshaw.Model.derivatedentities.TeamLog;
import org.davshaw.Model.pureentities.User;

public class UserController
{
    public static String createUser(
    int dni,
    String firstName,
    String middleName,
    String firstLastName,
    String middleLastName,
    String password)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(User.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que no exista otro usuario con el mismo dni
            if(UserController.userExist(dni))
            {
                throw new IllegalArgumentException("Ya existe un usuario con este mismo dni.");
            }

            User usuario = new User();

            usuario.setDni(dni);
            usuario.setFirstName(firstName);
            usuario.setMiddleName(middleName);
            usuario.setFirstLastName(firstLastName);
            usuario.setMiddleLastName(middleLastName);
            usuario.setPassword(password);

            session.beginTransaction();
            
            session.persist(usuario);
            
            session.getTransaction().commit();
            
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
            String sql = "SELECT COUNT(*) FROM User WHERE dni = :dni";
            Query<Long> query = session.createNativeQuery(sql, Long.class);
            query.setParameter("dni", dni);

    
            // Obtener el resultado de la consulta (cantidad de usuarios con el dni dado)
            int count = ((Number) query.uniqueResult()).intValue();
    
            // Si count es mayor que 0, significa que existe un usuario con ese userdni
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

    public String deleteUser(int userDni)
    {
        SessionFactory sessionFactory = new
        Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(User.class)
        .buildSessionFactory();
    
        Session session = sessionFactory.openSession();
    
        try
        {
            if((UserController.userExist(userDni)))
            {
                User usuario = session.get(User.class, userDni);
                
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

    public static User getUser(int userDni)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(User.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            session.beginTransaction();

            User usuario = session.get(User.class, userDni);

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

    public static String changeFirstName(int userDni, String name)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(User.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista
            if(UserController.userExist(userDni))
            {
                session.beginTransaction();

                User usuario = session.get(User.class, userDni);

                usuario.setFirstName(name);
                session.merge(usuario);

                session.getTransaction().commit();

                return "Primer name cambiado con éxito.";
                

            }

            else
            {
                throw new IllegalArgumentException("No existe un usuario con este userDni");
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

    public static String changeMiddleName(int userDni, String name)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(User.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista
            if(UserController.userExist(userDni))
            {
                session.beginTransaction();

                User usuario = session.get(User.class, userDni);

                usuario.setMiddleName(name);
                session.merge(usuario);

                session.getTransaction().commit();

                return "Segundo name cambiado con éxito.";
                

            }

            else
            {
                throw new IllegalArgumentException("No existe un usuario con este userDni");
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

    public static String changeFirstLastName(int userDni, String lastName)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(User.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista
            if(UserController.userExist(userDni))
            {
                session.beginTransaction();

                User usuario = session.get(User.class, userDni);

                usuario.setFirstLastName(lastName);
                session.merge(usuario);

                session.getTransaction().commit();

                return "Primer lastName cambiado con éxito.";
                

            }

            else
            {
                throw new IllegalArgumentException("No existe un usuario con este userDni");
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

    public static String changeMiddleLastName(int userDni, String lastName)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(User.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista
            if(UserController.userExist(userDni))
            {
                session.beginTransaction();

                User usuario = session.get(User.class, userDni);

                usuario.setMiddleLastName(lastName);
                session.merge(usuario);

                session.getTransaction().commit();

                return "Segundo lastName cambiado con éxito.";
                

            }

            else
            {
                throw new IllegalArgumentException("No existe un usuario con este userDni");
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

    public static String changePassword(int userDni, String password, String newPassword)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(User.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //!Verificar que exista
            if(UserController.userExist(userDni))
            {
                User user = UserController.getUser(userDni);

                if(user.getPassword() == null)
                {
                    session.beginTransaction();
                    user.setPassword(newPassword);
                    session.merge(user);
                    session.getTransaction().commit();
                    return "Contraseña cambiado con éxito.";
                }

                else if(user.getPassword().equals(password))
                {
                    session.beginTransaction();
                    user.setPassword(newPassword);
                    session.merge(user);
                    session.getTransaction().commit();
                    return "Contraseña cambiado con éxito.";
                }
                
                else
                {
                    throw new IllegalArgumentException("Credenciales no válidas.");
                }

                
            }

            else
            {
                throw new IllegalArgumentException("No existe un usuario con este userDni");
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

    public static Integer countGroup(int userDni)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(User.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que el usuario exista
            if(!(UserController.userExist(userDni)))
            {
                throw new IllegalArgumentException("No existe un usuario con este dni.");
            }

            session.beginTransaction();

            String sql = "SELECT Count(*) FROM TeamLog WHERE userDni = :userDni AND nativeFlag = :nativeFlag";

            Query<Long> query = session.createNativeQuery(sql, Long.class);
            query.setParameter("userDni", userDni);
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

    public static Boolean joinGroup(int userDni, int teamId)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(User.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que el grupo exista
            if(!(TeamController.groupExist(teamId)))
            {
                throw new IllegalArgumentException("No existe un grupo con este id.");
            }
            
            //Verificar que el usuario no este en mas de >= 3 grupos
            else if(UserController.countGroup(userDni) >= 3)
            {
                throw new IllegalArgumentException("El usuario está en el máximo de grupos permitidos.");
            }
            session.beginTransaction();

            TeamLog registro = new TeamLog();
            registro.setTeamId(teamId);
            registro.setNativeFlag(true);
            registro.setUserDni(userDni);

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

    public static Boolean leaveGroup(int userDni, int teamId)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(User.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que el usuario este en al menos un grupo
            if(UserController.countGroup(userDni) <= 0)
            {
                throw new IllegalArgumentException("El usuario no está en ningún grupo.");
            }

            //Verificar que el grupo exista
            else if(!(TeamController.groupExist(teamId)))
            {
                throw new IllegalArgumentException("No existe un grupo con este id.");
            }

            //Obtener ID del registro
            Integer registroId = UserController.getLogId(userDni, teamId);

            //Verificar que el registroId no sea null (No existe el registro)
            if (registroId == null)
            {
                throw new IllegalArgumentException("No se encontró que el usuario éste en un grupo con este id.");
            }

            session.beginTransaction();

            TeamLog registro = TeamLogController.getLog(registroId);
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

    public static Integer getLogId(int userDni, int teamId)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(User.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que el grupo exista
            if(!(TeamController.groupExist(teamId)))
            {
                throw new IllegalArgumentException("No existe un grupo con este id.");
            }

            //Verificar que el usuario exista
            if(!(UserController.userExist(userDni)))
            {
                throw new IllegalArgumentException("No existe un usuario con este dni.");
            }

            session.beginTransaction();

            String sql = "SELECT id FROM TeamLog WHERE teamId = :teamId AND userDni = :userDni AND nativeFlag = :nativeFlag";
            Query<Integer> query = session.createNativeQuery(sql, Integer.class);
            query.setParameter("userDni", userDni);
            query.setParameter("teamId", teamId);
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


