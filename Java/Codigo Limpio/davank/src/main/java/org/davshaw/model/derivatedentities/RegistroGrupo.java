package org.davshaw.Model.derivatedentities;

import org.davshaw.Model.pureentities.Grupo;
import org.davshaw.Model.pureentities.Usuario;

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
@Table(name = "RegistroGrupo")
public class RegistroGrupo
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    //?Clave foranea (Con grupo)
    @ManyToOne(targetEntity = Grupo.class)
    @JoinColumn(name = "grupoId", referencedColumnName = "id", insertable = false, updatable = false)
    private Grupo grupo;

    @Column(name = "grupoId")
    private int grupoId;

    //?Clave foranea (Con usuario)
    @ManyToOne(targetEntity = Usuario.class)
    @JoinColumn(name = "usuarioDni", referencedColumnName = "dni", insertable = false, updatable = false)
    private Usuario usuario;

    @Column(name = "usuarioDni")
    private int usuarioDni;

    @Column(name = "nativo")
    private boolean nativo;
}
