package org.davshaw.Model.pureentities;

import jakarta.persistence.CascadeType;
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
    private Integer accountNumber;

    @OneToOne(targetEntity = User.class, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "ownerDni", referencedColumnName = "dni", insertable = false, updatable = false)
    private User owner;

    @Column(name = "ownerDni")
    private Integer ownerDni;

    @Column(name = "balance")
    private Double balance = 0.0;
}
