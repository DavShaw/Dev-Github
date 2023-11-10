package org.davshaw.Model.derivatedentities;

import org.davshaw.Model.pureentities.Team;
import org.davshaw.Model.pureentities.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "TeamLog")
public class TeamLog
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(targetEntity = Team.class, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "teamId", referencedColumnName = "id", insertable = false, updatable = false)
    private Team team;

    @Column(name = "teamId")
    private Integer teamId;

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "userDni", referencedColumnName = "dni", insertable = false, updatable = false)
    private User user;

    @Column(name = "userDni")
    private Integer userDni;

    @Column(name = "nativeFlag")
    private Boolean nativeFlag;
}
