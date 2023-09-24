package org.davshaw.model;

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

        //?En el controlador de usuario se instancia la cuenta y se guarda

        /*
        ! Constructor para el mapeo de Código -> DB ! 
        */
    }

    public Usuario()
    {
        /*
        ! Constructor para el mapeo de DB -> Código ! 
        */
    }


    public int getDni() {
        return this.dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }


    public String getPrimerNombre() {
        return this.primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return this.segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return this.primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return this.segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getContraseña() {
        return this.contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public double getDinero() {
        return this.dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

}
