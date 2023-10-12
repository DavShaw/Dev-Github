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
import org.davshaw.External.ResultPack;
import org.davshaw.Model.derivatedentities.TeamLog;
import org.davshaw.Model.pureentities.User;

public class UserController
{
    public static ResultPack<Boolean> createUser(
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
            //Checking there's not another user with the same DNI.
            if(UserController.userExist(dni).getResult())
            {
                throw new DuplicateUserDNIException();
            }

            User user = new User();

            user.setDni(dni);
            user.setFirstName(firstName);
            user.setMiddleName(middleName);
            user.setFirstLastName(firstLastName);
            user.setMiddleLastName(middleLastName);
            user.setPassword(password);

            session.beginTransaction();
            
            session.persist(user);
            
            session.getTransaction().commit();
            
            AccountController.createAccount(dni);
            

            return new ResultPack<Boolean>(true, null, "The user has been created successfully.");
        }

        catch (DuplicateUserDNIException e)
        {
            //e.printStackTrace();
            return new ResultPack<Boolean>(false, null, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }

    }

    public static ResultPack<Boolean> userExist(int dni)
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

    
            int count = ((Number) query.uniqueResult()).intValue();
    
            if (count > 0)
            {
                return new ResultPack<Boolean>(true, true, "User found.");
            }
            return new ResultPack<Boolean>(true, false, new RecordNotFoundException().getMessage());
        }
        
        catch (Exception e)
        {
            e.printStackTrace();
            return new ResultPack<Boolean>(false, false, e.getMessage());
        }
        
        finally
        {
            session.close();
            sessionFactory.close();
        }
    
    }

    public static ResultPack<Boolean> deleteUser(int userDni)
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

            User user = session.get(User.class, userDni);

            session.beginTransaction();
            session.remove(user);
            session.getTransaction().commit();
            sessionFactory.close();            

            return new ResultPack<Boolean>(true, null, "The user has been deleted successfully");

        }
        
        catch (Exception e)
        {
            e.printStackTrace();
            return new ResultPack<Boolean>(false, null, e.getMessage());
        }
        
        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static ResultPack<User> getUser(int userDni)
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

            User user = session.get(User.class, userDni);

            session.getTransaction().commit();

            return new ResultPack<User>(true, user, "User found.");
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new ResultPack<User>(false, null, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static ResultPack<Boolean> changeFirstName(int userDni, String name)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(User.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Checking user exists
            if(!(UserController.userExist(userDni).getResult()))
            {
                throw new UserNotFoundException();
            }

            session.beginTransaction();

            User user = session.get(User.class, userDni);

            user.setFirstName(name);
            session.merge(user);

            session.getTransaction().commit();
            return new ResultPack<Boolean>(true, null, "User found.");

        }
            
        catch (Exception e)
        {
            e.printStackTrace();
            return new ResultPack<Boolean>(false, null, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static ResultPack<Boolean> changeMiddleName(int userDni, String name)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(User.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Checking user exists
            if(!(UserController.userExist(userDni).getResult()))
            {
                throw new UserNotFoundException();   
            }
            
            session.beginTransaction();

            User user = session.get(User.class, userDni);

            user.setMiddleName(name);
            session.merge(user);

            session.getTransaction().commit();

            return new ResultPack<Boolean>(true, null, "User found.");
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new ResultPack<Boolean>(false, null, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static ResultPack<Boolean> changeFirstLastName(int userDni, String lastName)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(User.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Checking user exists
            if(!(UserController.userExist(userDni).getResult()))
            {
                throw new UserNotFoundException();   
            }
            
            session.beginTransaction();

            User user = session.get(User.class, userDni);

            user.setFirstLastName(lastName);
            session.merge(user);

            session.getTransaction().commit();

            return new ResultPack<Boolean>(true, null, "User found.");
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new ResultPack<Boolean>(false, null, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static ResultPack<Boolean> changeMiddleLastName(int userDni, String lastName)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(User.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Checking user exists
            if(!(UserController.userExist(userDni).getResult()))
            {
                throw new UserNotFoundException();   
            }
            
            session.beginTransaction();

            User user = session.get(User.class, userDni);

            user.setMiddleLastName(lastName);
            session.merge(user);

            session.getTransaction().commit();

            return new ResultPack<Boolean>(true, null, "User found.");
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new ResultPack<Boolean>(false, null, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static ResultPack<Boolean> changePassword(int userDni, String password, String newPassword)
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

            return new ResultPack<Boolean>(true, null, "User found.");
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new ResultPack<Boolean>(false, null, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static ResultPack<Integer> countTeam(int userDni)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(User.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Checking user exists
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

            if(count != null)
            {
                return new ResultPack<Integer>(true, count, "Team info found.");
            }
            return new ResultPack<Integer>(false, 0, new RecordNotFoundException().getMessage());
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new ResultPack<Integer>(false, null, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static ResultPack<Boolean> joinTeam(int userDni, int teamId)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(User.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Checking team exists
            if(!(TeamController.teamExist(teamId).getResult()))
            {
                throw new TeamNotFoundException();
            }
            
            //Checking user aren't on the limit team
            if(UserController.countTeam(userDni).getResult() >= 3)
            {
                throw new UserAlreadyOnTeamsLimitException();
            }

            //Checking user aren't on the team
            if(TeamLogController.userOnTeam(userDni, teamId).getResult())
            {
                throw new UserAlreadyOnTeamException();
            }

            session.beginTransaction();

            TeamLog log = new TeamLog();
            log.setTeamId(teamId);
            log.setNativeFlag(true);
            log.setUserDni(userDni);

            session.persist(log);

            session.getTransaction().commit();

            return new ResultPack<Boolean>(true, null, "The user has joined to the team successfully.");
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new ResultPack<Boolean>(false, null, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static ResultPack<Boolean> leaveTeam(int userDni, int teamId)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(User.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Checking user are on at less on one team
            if(UserController.countTeam(userDni).getResult() <= 0)
            {
                throw new UserNotInAnyTeamException();
            }

            //Checking team exists
            if(!(TeamController.teamExist(teamId).getResult()))
            {
                throw new TeamNotFoundException();
            }

            //Getting log id that meet the condition (userDni and teamId are the same)
            Integer logId = UserController.getLogId(userDni, teamId).getResult();

            //Checking logId isn't null
            if (logId == null)
            {
                throw new RecordNotFoundException();
            }

            session.beginTransaction();

            TeamLogController.deleteLog(logId);

            session.getTransaction().commit();

            return new ResultPack<Boolean>(true, null, "The user has leave from the team successfully.");
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new ResultPack<Boolean>(false, null, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static ResultPack<Integer> getLogId(int userDni, int teamId)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(User.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Checking team exists
            if(!(TeamController.teamExist(teamId).getResult()))
            {
                throw new TeamNotFoundException();
            }

            //Checking user exists
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

            return new ResultPack<Integer>(true, id, "Log found.");
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return new ResultPack<Integer>(false, null, e.getMessage());
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static ResultPack<List<Integer>> getTeamList(int userDni)
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

            return new ResultPack<>(true, result, "Log found.");
            
        }
        
        catch (Exception e)
        {
            e.printStackTrace();
            return new ResultPack<>(false, null, e.getMessage());
        }
        
        finally
        {
            session.close();
            sessionFactory.close();
        }
    }
}


