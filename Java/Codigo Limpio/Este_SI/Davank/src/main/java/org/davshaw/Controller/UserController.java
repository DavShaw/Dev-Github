package org.davshaw.Controller;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

@RequestMapping("/davshaw/users")
@RestController
public class UserController
{

    @GetMapping
    public ResponseEntity<User> getGame()
    {
        //Getting user
        User user = UserController.getUser(106).getResult();
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

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

    
            int count = ((Number) query.uniqueResult()).intValue();
    
            if (count > 0)
            {
                return new RequestResult<Boolean>(true, true, "User found.");
            }
            return new RequestResult<Boolean>(true, false, new RecordNotFoundException().getMessage());
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

            User user = session.get(User.class, userDni);

            session.beginTransaction();
            session.remove(user);
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

            User user = session.get(User.class, userDni);

            session.getTransaction().commit();

            return new RequestResult<User>(true, user, "User found.");
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
                return new RequestResult<Integer>(true, count, "Team info found.");
            }
            return new RequestResult<Integer>(false, 0, new RecordNotFoundException().getMessage());
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


