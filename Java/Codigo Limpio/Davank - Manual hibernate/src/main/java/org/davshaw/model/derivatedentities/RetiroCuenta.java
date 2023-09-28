package org.davshaw.model.derivatedentities;

import java.util.Date;

import org.davshaw.model.pureentities.Cuenta;

import jakarta.persistence.CascadeType;
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
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString

@Entity
@Table(name = "RetiroCuenta")
public class RetiroCuenta
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    //? Clave foranea (Con Cuenta)
    @ManyToOne(targetEntity = Cuenta.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "numeroCuenta", referencedColumnName = "numeroCuenta", insertable = false, updatable = false)
    private Cuenta cuenta;

    @Column(name = "numeroCuenta")
    private int numeroCuenta;

    @Column(name = "monto")
    private double monto;

    @Column(name = "fechaHora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;
}
