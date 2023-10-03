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
@Table(name = "RetiroCuenta")
public class AccountWithdrawal
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    //? Clave foranea (Con Cuenta)
    @ManyToOne(targetEntity = Account.class)
    @JoinColumn(name = "numeroCuenta", referencedColumnName = "numeroCuenta", insertable = false, updatable = false)
    private Account cuenta;

    @Column(name = "numeroCuenta")
    private int numeroCuenta;

    @Column(name = "monto")
    private double monto;

    @Column(name = "fechaHora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;
}
