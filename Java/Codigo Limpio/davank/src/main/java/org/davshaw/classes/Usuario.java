package org.davshaw.classes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "Usuario")
public class Usuario
{

    @Id
    @Column(name = "dni")
    private int dni;
    
    @Column(name = "Cuenta")
    private Cuenta cuenta;

    @Column(name = "primerNombre")
    private String primerNombre;

    @Column(name = "segundoNombre")
    private String segundoNombre;

    @Column(name = "primerApellido")
    private String primerApellido;

    @Column(name = "segundoApellido")
    private String segundoApellido;

    @Column(name = "contraseña")
    private String contraseña;

    @Column(name = "dinero")
    private double dinero;


    public Usuario(
    int dni,
    String primerNombre,
    String segundoNombre,
    String primerApellido,
    String segundoApellido,
    String contraseña)
    {
        this.dni = dni;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.contraseña = contraseña;

        //Intanciar cuenta
        this.cuenta = new Cuenta(this);
    }
    
}
