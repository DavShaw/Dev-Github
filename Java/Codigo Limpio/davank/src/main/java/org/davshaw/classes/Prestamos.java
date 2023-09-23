package org.davshaw.classes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Prestamos")
public class Prestamos
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "usuario")
    private Usuario usuario;
    
    @Column(name = "grupo")
    private Grupo grupo;

    @Column(name = "monto")
    private double monto;


    public Prestamos(Usuario usuario, Grupo grupo, double monto)
    {
        this.usuario = usuario;
        this.grupo = grupo;
        this.monto = monto;
    }


}
