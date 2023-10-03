package org.davshaw.Controller;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Date;

import org.davshaw.Model.derivatedentities.AccountTransfer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TransferenciaCuentaControlador
{

    /*
    ! CRUD
    ! C - Create DONE
    ! R - Read DONE
    ! U - Update DOESNT APPLY
    ! D - Delete  DONE

    ? Hibernate structure

    SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(TransferenciaCuenta.class)
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

    public static Boolean hacerTransferencia(int titularDniCuentaOrigen, int titularDniCuentaDestino, double monto)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(AccountTransfer.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar si las dos cuentas existen
            if(!(CuentaControlador.existeCuenta(titularDniCuentaOrigen)) || !(CuentaControlador.existeCuenta(titularDniCuentaDestino)))
            {
                throw new IllegalArgumentException("La cuenta ingresada no existe.");
            }

            //Verificar si la cuenta de origen tiene el saldo suficiente para realizar la transferencia
            else if (CuentaControlador.obtenerSaldo(titularDniCuentaOrigen) < monto)
            {
                throw new IllegalArgumentException("La cuenta de origen tiene el saldo");
            }

            session.beginTransaction();

            //Retirar dinero de la cuenta de origen
            CuentaControlador.retirarSaldo(titularDniCuentaOrigen, monto);
            //Agregar dinero a la cuenta de destino
            CuentaControlador.agregarSaldo(titularDniCuentaDestino, monto);

            //Iniciar creación del registro de la transferencia
            AccountTransfer transferencia = new AccountTransfer();
            transferencia.setFechaHora(new Date());
            transferencia.setMonto(monto);
            transferencia.setNumeroCuentaDestino(CuentaControlador.obtenerNumeroCuenta(titularDniCuentaDestino));
            transferencia.setNumeroCuentaOrigen(CuentaControlador.obtenerNumeroCuenta(titularDniCuentaOrigen));

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

    public static Boolean existeTransferencia(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(AccountTransfer.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            String sql = "SELECT count(*) FROM TransferenciaCuenta WHERE id = :id";
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

    public static AccountTransfer obtenerTransferencia(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(AccountTransfer.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            if(!(TransferenciaCuentaControlador.existeTransferencia(id)))
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

    public static Boolean eliminarTransferencia(int id)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(AccountTransfer.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar si existe
            if(!(TransferenciaCuentaControlador.existeTransferencia(id)))
            {
                throw new IllegalArgumentException("No existe un registro de transferencia con este id.");
            }

            session.beginTransaction();
            AccountTransfer transferencia = TransferenciaCuentaControlador.obtenerTransferencia(id);

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