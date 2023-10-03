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
@Table(name = "AccountTransfer")
public class AccountTransfer
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    //?Clave foranea (Con cuenta)
    @ManyToOne(targetEntity = Account.class)
    @JoinColumn(name = "originAccountNumber", referencedColumnName = "accountNumber", insertable = false, updatable = false)
    private Account originAccount;

    @Column(name = "originAccountNumber")
    private int originAccountNumber;

    //?Clave foranea (Con cuenta)
    @ManyToOne(targetEntity = Account.class)
    @JoinColumn(name = "destinationAccountNumber", referencedColumnName = "accountNumber", insertable = false, updatable = false)
    private Account destinationAccount;

    @Column(name = "destinationAccountNumber")
    private int destinationAccountNumber;

    @Column(name = "balance")
    private double balance;

    @Column(name = "dateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;
}
