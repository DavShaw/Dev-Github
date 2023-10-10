package org.davshaw.Controller;

import java.util.Date;

import org.davshaw.Exception.RecordNotFoundException;
import org.davshaw.External.RequestResult;
import org.davshaw.Model.derivatedentities.TeamDebLog;
import org.davshaw.Model.derivatedentities.TeamLog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TeamDebLogController
{
    public RequestResult<Boolean> createLog(int logId, double amount)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(TeamLog.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Checking log exists
            if(!(TeamLogController.logExist(logId).getResult()))
            {
                throw new RecordNotFoundException();
            }
            
            session.beginTransaction();
            
            TeamDebLog log = new TeamDebLog();

            log.setAmount(amount);
            log.setLastPayment(new Date());
            log.setLogId(logId);

            session.persist(log);

            session.getTransaction().commit();

            return new RequestResult<Boolean>(false, null, "Log found.");
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



}
