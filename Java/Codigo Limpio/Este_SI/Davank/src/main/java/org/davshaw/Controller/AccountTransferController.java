package org.davshaw.Controller;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Date;

import org.davshaw.Exception.AccountNotFoundException;
import org.davshaw.Exception.InsufficientBalanceException;
import org.davshaw.Exception.RecordNotFoundException;
import org.davshaw.Model.derivatedentities.AccountTransfer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AccountTransferController
{
    public static Boolean transfer(int originOwnerDni, int destinationOwnerDni, double balance)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(AccountTransfer.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar si la cuenta origen existe
            if(!(AccountController.accountExist(originOwnerDni)))
            {
                throw new AccountNotFoundException();
            }

            //Verificar si cuenta destino existe
            else if(!(AccountController.accountExist(destinationOwnerDni)))
            {
                throw new AccountNotFoundException();
            }

            //Verificar si la cuenta de origen tiene el saldo suficiente para realizar la transferencia
            else if (AccountController.getBalance(originOwnerDni) < balance)
            {
                throw new InsufficientBalanceException();
            }

            session.beginTransaction();

            //Retirar dinero de la cuenta de origen
            AccountController.withdrawBalance(originOwnerDni, balance);
            //Agregar dinero a la cuenta de destino
            AccountController.addBalance(destinationOwnerDni, balance);

            //Iniciar creación del registro de la transferencia
            AccountTransfer transferencia = new AccountTransfer();
            transferencia.setDateTime(new Date());
            transferencia.setBalance(balance);
            transferencia.setDestinationAccountNumber(AccountController.getAccountNumber(destinationOwnerDni));
            transferencia.setOriginAccountNumber(AccountController.getAccountNumber(originOwnerDni));

            session.persist(transferencia);

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

    public static Boolean transferExist(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(AccountTransfer.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            String sql = "SELECT count(*) FROM AccountTransfer WHERE id = :id";
            Query<Long> query = session.createQuery(sql, Long.class);
            query.setParameter("id", id);
            int count = Integer.valueOf(query.uniqueResult().toString());

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

    public static AccountTransfer getTransfer(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(AccountTransfer.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            if(!(AccountTransferController.transferExist(id)))
            {
                throw new RecordNotFoundException();
            }

            else
            {
                session.beginTransaction();
                AccountTransfer transferencia = session.get(AccountTransfer.class, id);
                session.getTransaction().commit();

                return transferencia;

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

    public static Boolean deleteTransfer(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(AccountTransfer.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar si existe
            if(!(AccountTransferController.transferExist(id)))
            {
                throw new RecordNotFoundException();
            }

            session.beginTransaction();
            AccountTransfer transferencia = AccountTransferController.getTransfer(id);

            session.remove(transferencia);
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
}