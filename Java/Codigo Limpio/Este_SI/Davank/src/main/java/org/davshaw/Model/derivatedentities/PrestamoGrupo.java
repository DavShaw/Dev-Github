package org.davshaw.Model.derivatedentities;

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
@Table(name = "PrestamoGrupo")
public class PrestamoGrupo
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    //? Clave foranea (Con RegistroGrupo)
    @ManyToOne(targetEntity = RegistroGrupo.class)
    @JoinColumn(name = "registroId", referencedColumnName = "id", insertable = false, updatable = false)
    private RegistroGrupo registro;
    
    @Column(name = "registroId")
    private int registroId;

    @Column(name = "monto")
    private double monto;

    @Column(name = "fechaHora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;
}
