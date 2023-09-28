package org.davshaw.model.derivatedentities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
    @Column(name = "grupoId")
    private int grupoId;

    //?Clave foranea (Con usuario)
    @Column(name = "usuarioDni")
    private int usuarioDni;

    @Column(name = "nativo")
    private boolean nativo;

    public RegistroGrupo(int usuarioDni, int grupoId, boolean nativo)
    {
        this.usuarioDni = usuarioDni;
        this.grupoId = grupoId;
        this.nativo = nativo;
        
        /*
        ! Constructor para mapear Código -> Hibernate 
        */
    }

}
