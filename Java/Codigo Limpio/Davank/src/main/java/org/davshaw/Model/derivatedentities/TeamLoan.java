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

@Setter
@Getter
@NoArgsConstructor
@ToString

@Entity
@Table(name = "TeamLoan")
public class TeamLoan
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(targetEntity = TeamLog.class, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "logId", referencedColumnName = "id", insertable = false, updatable = false)
    private TeamLog log;
    
    @Column(name = "logId")
    private Integer logId;

    @Column(name = "balance")
    private Double balance;

    @Column(name = "dateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;
}
