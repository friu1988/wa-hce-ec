/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capa.datos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FREDDY
 */
@Entity
@Table(name = "t_horas", catalog = "db_hospital_dia_v3", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "THoras.findAll", query = "SELECT t FROM THoras t"),
    @NamedQuery(name = "THoras.findByHSerial", query = "SELECT t FROM THoras t WHERE t.hSerial = :hSerial"),
    @NamedQuery(name = "THoras.findByHInico", query = "SELECT t FROM THoras t WHERE t.hInico = :hInico"),
    @NamedQuery(name = "THoras.findByHFin", query = "SELECT t FROM THoras t WHERE t.hFin = :hFin")})
public class THoras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "h_serial", nullable = false)
    private Integer hSerial;
    @Column(name = "h_inico")
    @Temporal(TemporalType.TIME)
    private Date hInico;
    @Column(name = "h_fin")
    @Temporal(TemporalType.TIME)
    private Date hFin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hSerial")
    private List<THorario> tHorarioList;

    public THoras() {
    }

    public THoras(Integer hSerial) {
        this.hSerial = hSerial;
    }

    public Integer getHSerial() {
        return hSerial;
    }

    public void setHSerial(Integer hSerial) {
        this.hSerial = hSerial;
    }

    public Date getHInico() {
        return hInico;
    }

    public void setHInico(Date hInico) {
        this.hInico = hInico;
    }

    public Date getHFin() {
        return hFin;
    }

    public void setHFin(Date hFin) {
        this.hFin = hFin;
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
        hash += (hSerial != null ? hSerial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof THoras)) {
            return false;
        }
        THoras other = (THoras) object;
        if ((this.hSerial == null && other.hSerial != null) || (this.hSerial != null && !this.hSerial.equals(other.hSerial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.capa.datos.THoras[ hSerial=" + hSerial + " ]";
    }
    
}
