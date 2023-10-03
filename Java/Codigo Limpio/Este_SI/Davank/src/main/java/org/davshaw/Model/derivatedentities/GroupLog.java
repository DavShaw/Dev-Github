package org.davshaw.Model.derivatedentities;

import org.davshaw.Model.pureentities.Group;
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
@Table(name = "GroupLog")
public class GroupLog
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    //?Clave foranea (Con grupo)
    @ManyToOne(targetEntity = Group.class)
    @JoinColumn(name = "groupId", referencedColumnName = "id", insertable = false, updatable = false)
    private Group group;

    @Column(name = "groupId")
    private int groupId;

    //?Clave foranea (Con usuario)
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "ownerDni", referencedColumnName = "dni", insertable = false, updatable = false)
    private User owner;

    @Column(name = "ownerDni")
    private int ownerDni;

    @Column(name = "nativeFlag")
    private boolean nativeFlag;
}
