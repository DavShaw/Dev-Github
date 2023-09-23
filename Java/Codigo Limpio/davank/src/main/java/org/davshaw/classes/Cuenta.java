package org.davshaw.classes;

import jakarta.persistence.*;

@Entity
@Table(name = "Cuenta")
public class Cuenta
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "numeroCuenta")
    private int numeroCuenta;

    @Column(name = "titularDni")
    private int titularDni;

    @Column(name = "saldo")
    private double saldo;

    public Cuenta() 
    {
    }

    public Cuenta(int titularDni)
    {
        this.titularDni = titularDni;
    }


    public int getNumeroCuenta() {
        return this.numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public int getTitularDni() {
        return this.titularDni;
    }

    public void setTitularDni(int titularDni) {
        this.titularDni = titularDni;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
  
}
