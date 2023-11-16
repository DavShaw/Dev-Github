package org.davshaw.Model.derivatedentities;

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
    private Integer id;

    @ManyToOne(targetEntity = Account.class, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "originAccountNumber", referencedColumnName = "accountNumber", insertable = false, updatable = false)
    private Account originAccount;

    @Column(name = "originAccountNumber")
    private Integer originAccountNumber;

    @ManyToOne(targetEntity = Account.class, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "destinationAccountNumber", referencedColumnName = "accountNumber", insertable = false, updatable = false)
    private Account destinationAccount;

    @Column(name = "destinationAccountNumber")
    private Integer destinationAccountNumber;

    @Column(name = "balance")
    private Double balance;

    @Column(name = "dateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;
}
