package org.davshaw.Controller;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;

import org.davshaw.Exception.DuplicateUserDNIException;
import org.davshaw.Exception.InvalidLoginException;
import org.davshaw.Exception.RecordNotFoundException;
import org.davshaw.Exception.TeamNotFoundException;
import org.davshaw.Exception.UserAlreadyOnTeamsLimitException;
import org.davshaw.Exception.UserAlreadyOnTeamException;
import org.davshaw.Exception.UserNotFoundException;
import org.davshaw.Exception.UserNotInAnyTeamException;
import org.davshaw.External.RequestResult;
import org.davshaw.Model.derivatedentities.TeamLog;
import org.davshaw.Model.pureentities.User;

public class UserController
{
    public static RequestResult<Boolean> createUser(
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
            if(UserController.userExist(dni).getResult())
            {
                throw new DuplicateUserDNIException();
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
            

            return new RequestResult<Boolean>(true, null, "The user has been created successfully.");
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new RequestResult<Boolean>(false, null, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }

    }

    public static RequestResult<Boolean> userExist(int dni)
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
            if (count > 0)
            {
                return new RequestResult<Boolean>(true, true, "User found.");
            }

            else
            {
                return new RequestResult<Boolean>(true, false, new RecordNotFoundException().getMessage());
            }
        }
        
        catch (Exception e)
        {
            e.printStackTrace();
            return new RequestResult<Boolean>(false, false, e.getMessage());
        }
        
        finally
        {
            session.close();
            sessionFactory.close();
        }
    
    }

    public static RequestResult<Boolean> deleteUser(int userDni)
    {
        SessionFactory sessionFactory = new
        Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(User.class)
        .buildSessionFactory();
    
        Session session = sessionFactory.openSession();
    
        try
        {
            if(!(UserController.userExist(userDni).getResult()))
            {
                throw new UserNotFoundException();   
            }

            User usuario = session.get(User.class, userDni);

            session.beginTransaction();
            session.remove(usuario);
            session.getTransaction().commit();
            sessionFactory.close();            

            return new RequestResult<Boolean>(true, null, "The user has been deleted successfully");

        }
        
        catch (Exception e)
        {
            e.printStackTrace();
            return new RequestResult<Boolean>(false, null, e.getMessage());
        }
        
        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static RequestResult<User> getUser(int userDni)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(User.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            if(!(UserController.userExist(userDni).getResult()))
            {
                throw new UserNotFoundException();
            }
            session.beginTransaction();

            User usuario = session.get(User.class, userDni);

            session.getTransaction().commit();

            return new RequestResult<User>(true, usuario, "User found.");
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new RequestResult<User>(false, null, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static RequestResult<Boolean> changeFirstName(int userDni, String name)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(User.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista
            if(!(UserController.userExist(userDni).getResult()))
            {
                throw new UserNotFoundException();
            }

            session.beginTransaction();

            User usuario = session.get(User.class, userDni);

            usuario.setFirstName(name);
            session.merge(usuario);

            session.getTransaction().commit();
            return new RequestResult<Boolean>(true, null, "User found.");

        }
            
        catch (Exception e)
        {
            e.printStackTrace();
            return new RequestResult<Boolean>(false, null, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static RequestResult<Boolean> changeMiddleName(int userDni, String name)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(User.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista
            if(!(UserController.userExist(userDni).getResult()))
            {
                throw new UserNotFoundException();   
            }
            
            session.beginTransaction();

            User usuario = session.get(User.class, userDni);

            usuario.setMiddleName(name);
            session.merge(usuario);

            session.getTransaction().commit();

            return new RequestResult<Boolean>(true, null, "User found.");
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new RequestResult<Boolean>(false, null, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static RequestResult<Boolean> changeFirstLastName(int userDni, String lastName)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(User.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista
            if(!(UserController.userExist(userDni).getResult()))
            {
                throw new UserNotFoundException();   
            }
            
            session.beginTransaction();

            User usuario = session.get(User.class, userDni);

            usuario.setFirstLastName(lastName);
            session.merge(usuario);

            session.getTransaction().commit();

            return new RequestResult<Boolean>(true, null, "User found.");
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new RequestResult<Boolean>(false, null, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static RequestResult<Boolean> changeMiddleLastName(int userDni, String lastName)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(User.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista
            if(!(UserController.userExist(userDni).getResult()))
            {
                throw new UserNotFoundException();   
            }
            
            session.beginTransaction();

            User usuario = session.get(User.class, userDni);

            usuario.setMiddleLastName(lastName);
            session.merge(usuario);

            session.getTransaction().commit();

            return new RequestResult<Boolean>(true, null, "User found.");
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new RequestResult<Boolean>(false, null, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static RequestResult<Boolean> changePassword(int userDni, String password, String newPassword)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(User.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Checking if user exists
            if(!(UserController.userExist(userDni).getResult()))
            {
                throw new UserNotFoundException();
            }

            //!(This check depends on the previous)
            //Checking if pass is correct

            String currentPassword = UserController.getUser(userDni).getResult().getPassword();
            System.out.println("Current password -> " + currentPassword);

            if(!(currentPassword.equals(password)))
            {
                throw new InvalidLoginException();
            }

            session.beginTransaction();

            User user = UserController.getUser(userDni).getResult();

            user.setPassword(newPassword);
            session.merge(user);
            session.getTransaction().commit();

            return new RequestResult<Boolean>(true, null, "User found.");
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new RequestResult<Boolean>(false, null, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static RequestResult<Integer> countTeam(int userDni)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(User.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que el usuario exista
            if(!(UserController.userExist(userDni).getResult()))
            {
                throw new UserNotFoundException();
            }

            session.beginTransaction();

            String sql = "SELECT Count(*) FROM TeamLog WHERE userDni = :userDni AND nativeFlag = :nativeFlag";

            Query<Long> query = session.createNativeQuery(sql, Long.class);
            query.setParameter("userDni", userDni);
            query.setParameter("nativeFlag", true);
            session.getTransaction().commit();

            Integer count = Integer.valueOf(query.uniqueResult().toString());

            //Return condition ? valueIfTrue : valueIfFalse -> Conditional operator
            RequestResult<Integer> returnIfTrue = new RequestResult<Integer>(true, count, "Team info found.");
            RequestResult<Integer> requestIfFalse = new RequestResult<Integer>(false, 0, "Unknown error... plz fixme");

            return (count != null) ? returnIfTrue : requestIfFalse;
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new RequestResult<Integer>(false, null, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static RequestResult<Boolean> joinTeam(int userDni, int teamId)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(User.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que el grupo exista
            if(!(TeamController.teamExist(teamId).getResult()))
            {
                throw new TeamNotFoundException();
            }
            
            //Verificar que el usuario no este en mas de >= 3 grupos
            if(UserController.countTeam(userDni).getResult() >= 3)
            {
                throw new UserAlreadyOnTeamsLimitException();
            }

            //Verificar que el usuario no este en ese grupo
            if(TeamLogController.userOnTeam(userDni, teamId).getResult())
            {
                throw new UserAlreadyOnTeamException();
            }

            session.beginTransaction();

            TeamLog registro = new TeamLog();
            registro.setTeamId(teamId);
            registro.setNativeFlag(true);
            registro.setUserDni(userDni);

            session.persist(registro);

            session.getTransaction().commit();

            return new RequestResult<Boolean>(true, null, "The user has joined to the team successfully.");
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new RequestResult<Boolean>(false, null, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static RequestResult<Boolean> leaveTeam(int userDni, int teamId)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(User.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que el usuario este en al menos un grupo
            if(UserController.countTeam(userDni).getResult() <= 0)
            {
                throw new UserNotInAnyTeamException();
            }

            //Verificar que el grupo exista
            if(!(TeamController.teamExist(teamId).getResult()))
            {
                throw new TeamNotFoundException();
            }

            //Obtener ID del registro
            Integer registroId = UserController.getLogId(userDni, teamId).getResult();

            //Verificar que el registroId no sea null (No existe el registro)
            if (registroId == null)
            {
                throw new RecordNotFoundException();
            }

            session.beginTransaction();

            TeamLogController.deleteLog(registroId);

            session.getTransaction().commit();

            return new RequestResult<Boolean>(true, null, "The user has leave from the team successfully.");
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new RequestResult<Boolean>(false, null, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static RequestResult<Integer> getLogId(int userDni, int teamId)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(User.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que el grupo exista
            if(!(TeamController.teamExist(teamId).getResult()))
            {
                throw new TeamNotFoundException();
            }

            //Verificar que el usuario exista
            if(!(UserController.userExist(userDni).getResult()))
            {
                throw new UserNotFoundException();
            }

            session.beginTransaction();

            String sql = "SELECT id FROM TeamLog WHERE teamId = :teamId AND userDni = :userDni AND nativeFlag = :nativeFlag LIMIT 1";
            Query<Integer> query = session.createNativeQuery(sql, Integer.class);
            query.setParameter("userDni", userDni);
            query.setParameter("teamId", teamId);
            query.setParameter("nativeFlag", true);


            Integer id = (Integer) query.uniqueResult();

            session.getTransaction().commit();

            return new RequestResult<Integer>(true, id, "Log found.");
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new RequestResult<Integer>(false, null, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static RequestResult<List<Integer>> getTeamList(int userDni)
    {
        SessionFactory sessionFactory = new
        Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(User.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();
    
        try
        {
            //Verify that user exist!
            if(!(UserController.userExist(userDni).getResult()))
            {
                throw new UserNotFoundException();
            }

            String sql = "SELECT teamId FROM TeamLog WHERE(userDni = :userDni and nativeFlag = :nativeFlag)";
            Query<Integer> query = session.createNativeQuery(sql, Integer.class);
            query.setParameter("nativeFlag", true);
            query.setParameter("userDni", userDni);

            List<Integer> result = query.getResultList();

            if(result.isEmpty())
            {
                throw new UserNotInAnyTeamException();
            }

            return new RequestResult<>(true, result, "Log found.");
            
        }
        
        catch (Exception e)
        {
            e.printStackTrace();
            return new RequestResult<>(false, null, e.getMessage());
        }
        
        finally
        {
            session.close();
            sessionFactory.close();
        }
    }
}


