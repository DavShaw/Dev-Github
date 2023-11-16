package org.davshaw.Model.derivatedentities;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "TeamDebtLog")
public class TeamDebtLog
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne(targetEntity = TeamLog.class, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "logId", referencedColumnName = "id", insertable = false, updatable = false)
    private TeamLog log;

    @Column(name = "logId")
    private int logId;

    @Column(name = "amount")
    private Double amount = 0.0;

    @Column(name = "lastPayment")
    private Date lastPayment;
}
