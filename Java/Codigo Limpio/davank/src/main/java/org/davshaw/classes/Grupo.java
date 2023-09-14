package org.davshaw.classes;

import java.rmi.NoSuchObjectException;
import java.util.HashMap;
import java.util.List;

public class Grupo
{
    private Usuario lider;
    private String nombre;
    private List<Usuario> integrantes;
    private double saldo = 0;
    private HashMap<Usuario, Double> registroDepositos = new HashMap<Usuario, Double>();//BASE DE DATOS!

    public Grupo(Usuario lider, String nombre)
    {
        this.lider = lider;
        this.nombre = nombre;
    }
    
    public void agregarIntegrante(Usuario usuario)
    {
        try
        {
            if(this.integrantes.size() < 3)
            {
                this.integrantes.add(usuario);
            }
            else
            {
                throw new IndexOutOfBoundsException("Ya hay la cantidad máxima de integrantes en el grupo.");   
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void retirarIntegrante(Usuario usuario)
    {
        try
        {
            if(this.integrantes.contains(usuario))
            {
                this.integrantes.remove(usuario);
            }
            else
            {
                throw new NoSuchObjectException("Este usuario no está en el grupo.");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public List<Usuario> integrantes()
    {
        return this.integrantes;
    }

    public Usuario lider()
    {
        return this.lider;
    }

    public String nombre()
    {
        return this.nombre;
    }

    public void cambiarLider(Usuario lider)
    {
        this.lider = lider;
    }

    public void depositar(Usuario integrante, double monto)
    {
        try
        {
            //Si la persona no pertenece al grupo
            if(!(this.perteneceAlGrupo(integrante)))
            {
                throw new NoSuchObjectException("Esta persona no pertenece al grupo.");
            }

            //Si la persona no tiene suficiente dinero
            else if(!(this.personaTieneSuficiente(integrante, monto)))
            {
                throw new IllegalArgumentException("Esta persona no tiene suficiente dinero para depositar esta cantidad.");
            }

            //Si nada de lo anterior se ejecutó, entonces pertenece y tiene el suficiente dinero
            else
            {
                this.saldo += monto;
                this.registroDepositos.put(integrante, this.registroDepositos.get(integrante) + monto);
                integrante.retirarEnBolsillo(monto);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public double saldo()
    {
        return this.saldo;
    }

    public void retirar(Usuario integrante, double monto)
    {
        try
        {
            //Si la persona no pertenece al grupo
            if(!(this.perteneceAlGrupo(integrante)))
            {
                throw new NoSuchObjectException("Esta persona no pertenece al grupo.");
            }

            //Si la persona no tiene suficiente dinero
            else if(!(integrante.suficienteDineroPara(monto)))
            {
                throw new IllegalArgumentException("Esta persona no tiene suficiente dinero para depositar esta cantidad.");
            }

            //Si nada de lo anterior se ejecutó, entonces pertenece y tiene el suficiente dinero
            else
            {
                this.saldo += monto;
                this.registroDepositos.put(integrante, this.registroDepositos.get(integrante) + monto);
                integrante.retirarEnBolsillo(monto);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private boolean perteneceAlGrupo(Usuario usuario)
    {
        return this.integrantes.contains(usuario);
    }

    private boolean personaTieneSuficiente(Usuario integrante, double monto)
    {
        try
        {
            //Si la persona no pertenece al grupo
            if(!(this.perteneceAlGrupo(integrante)))
            {
                throw new NoSuchObjectException("Esta persona no pertenece al grupo.");
            }
            else
            {
                return this.registroDepositos.get(integrante) >= monto;
            }
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

}
