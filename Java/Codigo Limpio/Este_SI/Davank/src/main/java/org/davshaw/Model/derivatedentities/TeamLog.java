package org.davshaw.Model.derivatedentities;

import org.davshaw.Model.pureentities.Team;
import org.davshaw.Model.pureentities.User;

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
@Table(name = "teamLog")
public class TeamLog
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    //?Clave foranea (Con grupo)
    @ManyToOne(targetEntity = Team.class)
    @JoinColumn(name = "teamId", referencedColumnName = "id", insertable = false, updatable = false)
    private Team group;

    @Column(name = "teamId")
    private int teamId;

    //?Clave foranea (Con usuario)
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "userDni", referencedColumnName = "dni", insertable = false, updatable = false)
    private User user;

    @Column(name = "userDni")
    private int userDni;

    @Column(name = "nativeFlag")
    private boolean nativeFlag;
}
