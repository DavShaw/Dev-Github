package org.davshaw.Controller;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Date;

import org.davshaw.Model.derivatedentities.AccountTransfer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AccountTransferController
{
    public static Boolean transfer(int titularDniCuentaOrigen, int titularDniCuentaDestino, double monto)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(AccountTransfer.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar si las dos cuentas existen
            if(!(AccountController.accountExist(titularDniCuentaOrigen)) || !(AccountController.accountExist(titularDniCuentaDestino)))
            {
                throw new IllegalArgumentException("La cuenta ingresada no existe.");
            }

            //Verificar si la cuenta de origen tiene el saldo suficiente para realizar la transferencia
            else if (AccountController.getBalance(titularDniCuentaOrigen) < monto)
            {
                throw new IllegalArgumentException("La cuenta de origen tiene el saldo");
            }

            session.beginTransaction();

            //Retirar dinero de la cuenta de origen
            AccountController.withdrawalBalance(titularDniCuentaOrigen, monto);
            //Agregar dinero a la cuenta de destino
            AccountController.addBalance(titularDniCuentaDestino, monto);

            //Iniciar creación del registro de la transferencia
            AccountTransfer transferencia = new AccountTransfer();
            transferencia.setDateTime(new Date());
            transferencia.setBalance(monto);
            transferencia.setDestinationAccountNumber(AccountController.getAccountNumber(titularDniCuentaDestino));
            transferencia.setOriginAccountNumber(AccountController.getAccountNumber(titularDniCuentaOrigen));

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
            String sql = "SELECT count(*) FROM accountTransfer WHERE id = :id";
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
                throw new IllegalArgumentException("No existe una transferencia con este id.");
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
                throw new IllegalArgumentException("No existe un registro de transferencia con este id.");
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