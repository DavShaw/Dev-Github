package org.davshaw.model.derivatedentities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@ToString

@Entity
@Table(name = "TransferenciaCuenta")
public class TransferenciaCuenta
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    //?Clave foranea (Con grupos)
    @Column(name = "numeroCuentaOrigen")
    private int numeroCuentaOrigen;

    //?Clave foranea (Con grupos)
    @Column(name = "numeroCuentaDestino")
    private int numeroCuentaDestino;

    @Column(name = "monto")
    private double monto;

    @Column(name = "fechaHora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;
}
