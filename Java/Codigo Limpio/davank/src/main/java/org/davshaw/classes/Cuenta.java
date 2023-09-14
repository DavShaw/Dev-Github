package org.davshaw.classes;

import java.util.ArrayList;
import java.util.List;

import org.davshaw.external.AccountNumberGenerator;

public class Cuenta
{

    //! VARIABLES DE CLASE:
    private List<Integer> numeroCuentaRegistrados = new ArrayList<Integer>();


    //? VARIABLES DE INSTANCIA:
    private Usuario titular;
    private int numeroCuenta;
    private double saldo;

    public Cuenta(Usuario titular)
    {
        this.titular = titular;

        //Generar número de cuenta
        while(true)
        {
            int temporalNumber = AccountNumberGenerator.generateNumber();
            if(!(this.numeroCuentaRegistrados.contains(temporalNumber)))
            {
                this.numeroCuenta = temporalNumber;
                this.numeroCuentaRegistrados.add(temporalNumber);
                break;
            }
        }
    }

    public Usuario titular()
    {
        return this.titular;
    }

    public int numeroCuenta()
    {
        return this.numeroCuenta;
    }

    public void depositar(double monto)
    {
        this.saldo += monto;
    }

    public void retirar(double monto)
    {
        try
        {
            if (this.saldo >= monto)
            {
                this.saldo -= monto;
            }
            else
            {
                throw new IllegalArgumentException("La cantidad de monto a retirar supera el saldo actual.");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


}
