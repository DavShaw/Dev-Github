package org.davshaw.classes;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Grupo")
public class Grupo
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "lider")
    private Usuario lider;
    
    @Column(name = "integrantes")
    private List<Usuario> integrantes;

    @Column(name = "saldo")
    private double saldo = 0;

    public Grupo(Usuario lider, String nombre)
    {
        this.lider = lider;
        this.nombre = nombre;
    }

}
