package org.davshaw.model.derivatedentities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "RegistroGrupo")
public class RegistroGrupo
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    //!Clave foranea (Conexión con grupo)
    @Column(name = "grupoId")
    private int grupoId;
    //!Clave foranea (Conexión con usuario)
    @Column(name = "usuarioDni")
    private int usuarioDni;

    @Column(name = "nativo")
    private boolean nativo;

    public RegistroGrupo()
    {
        /*
        ! Constructor para mapear Hibernate -> Código 
        */
    }

    public RegistroGrupo(int usuarioDni, int grupoId, boolean nativo)
    {
        this.usuarioDni = usuarioDni;
        this.grupoId = grupoId;
        this.nativo = nativo;
        
        /*
        ! Constructor para mapear Código -> Hibernate 
        */
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGrupoId() {
        return this.grupoId;
    }

    public void setGrupoId(int grupoId) {
        this.grupoId = grupoId;
    }

    public int getUsuarioDni() {
        return this.usuarioDni;
    }

    public void setUsuarioDni(int usuarioDni) {
        this.usuarioDni = usuarioDni;
    }

    public boolean isNativo() {
        return this.nativo;
    }

    public boolean getNativo() {
        return this.nativo;
    }

    public void setNativo(boolean nativo) {
        this.nativo = nativo;
    }

}
