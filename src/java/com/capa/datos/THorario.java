/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capa.datos;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FREDDY
 */
@Entity
@Table(name = "t_horario", catalog = "db_hospital_dia_v3", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "THorario.findAll", query = "SELECT t FROM THorario t"),
    @NamedQuery(name = "THorario.findByPerSerial", query = "SELECT t FROM THorario t WHERE t.tHorarioPK.perSerial = :perSerial"),
    @NamedQuery(name = "THorario.findByDSerial", query = "SELECT t FROM THorario t WHERE t.tHorarioPK.dSerial = :dSerial")})
public class THorario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected THorarioPK tHorarioPK;
    @JoinColumn(name = "d_serial", referencedColumnName = "d_serial", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TDias tDias;
    @JoinColumn(name = "h_serial", referencedColumnName = "h_serial", nullable = false)
    @ManyToOne(optional = false)
    private THoras hSerial;
    @JoinColumn(name = "per_serial", referencedColumnName = "per_serial", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TMedico tMedico;

    public THorario() {
    }

    public THorario(THorarioPK tHorarioPK) {
        this.tHorarioPK = tHorarioPK;
    }

    public THorario(int perSerial, int dSerial) {
        this.tHorarioPK = new THorarioPK(perSerial, dSerial);
    }

    public THorarioPK getTHorarioPK() {
        return tHorarioPK;
    }

    public void setTHorarioPK(THorarioPK tHorarioPK) {
        this.tHorarioPK = tHorarioPK;
    }

    public TDias getTDias() {
        return tDias;
    }

    public void setTDias(TDias tDias) {
        this.tDias = tDias;
    }

    public THoras getHSerial() {
        return hSerial;
    }

    public void setHSerial(THoras hSerial) {
        this.hSerial = hSerial;
    }

    public TMedico getTMedico() {
        return tMedico;
    }

    public void setTMedico(TMedico tMedico) {
        this.tMedico = tMedico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tHorarioPK != null ? tHorarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof THorario)) {
            return false;
        }
        THorario other = (THorario) object;
        if ((this.tHorarioPK == null && other.tHorarioPK != null) || (this.tHorarioPK != null && !this.tHorarioPK.equals(other.tHorarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.capa.datos.THorario[ tHorarioPK=" + tHorarioPK + " ]";
    }
    
}
