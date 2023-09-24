package org.davshaw.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "RegistroGrupos")
public class RegistroGrupos
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "grupoId")
    private int grupoId;

    @Column(name = "usuarioDni")
    private int usuarioDni;

    @Column(name = "nativo")
    private boolean nativo;

    public RegistroGrupos()
    {
    }

    public RegistroGrupos(int usuarioDni, int grupoId, boolean nativo)
    {
        this.usuarioDni = usuarioDni;
        this.grupoId = grupoId;
        this.nativo = nativo;
    }

    public RegistroGrupos(int usuarioDni, int grupoId)
    {
        this.usuarioDni = usuarioDni;
        this.grupoId = grupoId;
        this.nativo = true;
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
