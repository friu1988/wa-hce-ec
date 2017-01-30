/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capa.datos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FREDDY
 */
@Entity
@Table(name = "t_medico", catalog = "db_hospital_dia_v3", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TMedico.findAll", query = "SELECT t FROM TMedico t"),
    @NamedQuery(name = "TMedico.findByPerSerial", query = "SELECT t FROM TMedico t WHERE t.perSerial = :perSerial")})
public class TMedico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "per_serial", nullable = false)
    private Integer perSerial;
    @ManyToMany(mappedBy = "tMedicoList")
    private List<TEspecialidad> tEspecialidadList;
    @JoinColumn(name = "per_serial", referencedColumnName = "per_serial", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private TPersonal tPersonal;
    @JoinColumn(name = "co_serial", referencedColumnName = "co_serial", nullable = false)
    @ManyToOne(optional = false)
    private TConsultorio coSerial;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tMPerSerial")
    private List<TTurno> tTurnoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tMedico")
    private List<THorario> tHorarioList;

    public TMedico() {
    }

    public TMedico(Integer perSerial) {
        this.perSerial = perSerial;
    }

    public Integer getPerSerial() {
        return perSerial;
    }

    public void setPerSerial(Integer perSerial) {
        this.perSerial = perSerial;
    }

    @XmlTransient
    public List<TEspecialidad> getTEspecialidadList() {
        return tEspecialidadList;
    }

    public void setTEspecialidadList(List<TEspecialidad> tEspecialidadList) {
        this.tEspecialidadList = tEspecialidadList;
    }

    public TPersonal getTPersonal() {
        return tPersonal;
    }

    public void setTPersonal(TPersonal tPersonal) {
        this.tPersonal = tPersonal;
    }

    public TConsultorio getCoSerial() {
        return coSerial;
    }

    public void setCoSerial(TConsultorio coSerial) {
        this.coSerial = coSerial;
    }

    @XmlTransient
    public List<TTurno> getTTurnoList() {
        return tTurnoList;
    }

    public void setTTurnoList(List<TTurno> tTurnoList) {
        this.tTurnoList = tTurnoList;
    }

    @XmlTransient
    public List<THorario> getTHorarioList() {
        return tHorarioList;
    }

    public void setTHorarioList(List<THorario> tHorarioList) {
        this.tHorarioList = tHorarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perSerial != null ? perSerial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TMedico)) {
            return false;
        }
        TMedico other = (TMedico) object;
        if ((this.perSerial == null && other.perSerial != null) || (this.perSerial != null && !this.perSerial.equals(other.perSerial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.capa.datos.TMedico[ perSerial=" + perSerial + " ]";
    }
    
}
