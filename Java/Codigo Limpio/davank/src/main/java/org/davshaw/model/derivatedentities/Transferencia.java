package org.davshaw.model.derivatedentities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Transferencia")
public class Transferencia
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    //!Clave foranea (Conexión con grupos)
    @Column(name = "cuentaOrigen")
    private int cuentaOrigenId;

    //!Clave foranea (Conexión con grupos)
    @Column(name = "cuentaDestino")
    private int cuentaDestinoId;

    @Column(name = "monto")
    private double monto;

    public Transferencia()
    {
        /*
        ! Constructor vacío para mapeo de Hibernate -> Código 
        */
    }


}
