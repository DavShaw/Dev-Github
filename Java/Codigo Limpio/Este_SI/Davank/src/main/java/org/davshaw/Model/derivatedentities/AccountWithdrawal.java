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
@Table(name = "AccountWithdrawal")
public class AccountWithdrawal
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    //? Clave foranea (Con Cuenta)
    @ManyToOne(targetEntity = Account.class)
    @JoinColumn(name = "accountNumber", referencedColumnName = "accountNumber", insertable = false, updatable = false)
    private Account account;

    @Column(name = "accountNumber")
    private int accountNumber;

    @Column(name = "balance")
    private double balance;

    @Column(name = "dateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;
}
