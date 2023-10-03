package org.davshaw.Model.pureentities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString

@Entity
@Table(name = "Cuenta")
public class Account
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "numeroCuenta")
    private int numeroCuenta;

    //? Clave foranea (Con usuario)
    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "titularDni", referencedColumnName = "dni", insertable = false, updatable = false)
    private User titular;

    @Column(name = "titularDni")
    private int titularDni;

    @Column(name = "saldo")
    private double saldo;
}
