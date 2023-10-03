package org.davshaw.Model.derivatedentities;

import java.util.Date;


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
import org.davshaw.Model.pureentities.Account;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString

@Entity
@Table(name = "DepositoCuenta")
public class AccountDeposit
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    //? Clave foranea (Con cuenta)
    @ManyToOne(targetEntity = Account.class)
    @JoinColumn(name = "CuentaId", referencedColumnName = "numeroCuenta", insertable = false, updatable = false)
    private Account cuenta;

    @Column(name = "cuentaId")
    private int cuentaId;

    @Column(name = "monto")
    private double monto;

    @Column(name = "fechaHora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;
}
