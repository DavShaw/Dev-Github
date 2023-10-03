package org.davshaw.Model.derivatedentities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;

import org.davshaw.Model.pureentities.Account;

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

    //?Clave foranea (Con cuenta)
    @ManyToOne(targetEntity = Account.class)
    @JoinColumn(name = "numeroCuentaOrigen", referencedColumnName = "numeroCuenta", insertable = false, updatable = false)
    private Account cuentaOrigen;

    @Column(name = "numeroCuentaOrigen")
    private int numeroCuentaOrigen;

    //?Clave foranea (Con cuenta)
    @ManyToOne(targetEntity = Account.class)
    @JoinColumn(name = "numeroCuentaDestino", referencedColumnName = "numeroCuenta", insertable = false, updatable = false)
    private Account cuentaDestino;

    @Column(name = "numeroCuentaDestino")
    private int numeroCuentaDestino;

    @Column(name = "monto")
    private double monto;

    @Column(name = "fechaHora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;
}
