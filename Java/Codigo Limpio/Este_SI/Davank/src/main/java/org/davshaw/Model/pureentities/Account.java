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
@Table(name = "Account")
public class Account
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "accountNumber")
    private int accountNumber;

    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "ownerDni", referencedColumnName = "dni", insertable = false, updatable = false)
    private User owner;

    @Column(name = "ownerDni")
    private int ownerDni;

    @Column(name = "balance")
    private double balance;
}
