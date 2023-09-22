package org.davshaw.classes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cuenta")
public class Cuenta
{
    @Id
    @Column(name = "numeroCuenta")
    private int numeroCuenta;

    @Column(name = "titular")
    private Usuario titular;

    @Column(name = "saldo")
    private double saldo;


    public Cuenta(Usuario titular)
    {
        this.titular = titular;
        this.saldo = 0.0;
        this.numeroCuenta = 0;
    }


}
