package org.davshaw.model.derivatedentities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Retiro")
public class Retiro
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    //!Clave foranea (Conexión con grupos)
    @Column(name = "cuenta")
    private int cuenta;

    @Column(name = "monto")
    private double monto;

    public Retiro()
    {
        /*
        ! Constructor vacío para mapeo de Hibernate -> Código 
        */
    }


}
