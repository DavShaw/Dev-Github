package org.davshaw.model;

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

    @Column(name = "registroId")
    private int registroId;

    @Column(name = "monto")
    private double monto;


    public Prestamos(int registroId, double monto)
    {
        this.registroId = registroId;
        this.monto = monto;
    }

    public Prestamos()
    {

    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRegistroId() {
        return this.registroId;
    }

    public void setRegistroId(int registroId) {
        this.registroId = registroId;
    }

    public double getMonto() {
        return this.monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }



}
