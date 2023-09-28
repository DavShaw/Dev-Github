package org.davshaw.model.pureentities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString

@Entity
@Table(name = "Grupo")
public class Grupo
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "saldo")
    private double saldo = 0;

    @Column(name = "numeroIntegrantes")
    private int numeroIntegrantes = 0;

    public Grupo(String nombre)
    {
        this.nombre = nombre;

        /*
        ! Constructor para mapear Código -> Hibernate 
        */
    }
}
