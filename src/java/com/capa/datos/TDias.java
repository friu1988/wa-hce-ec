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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FREDDY
 */
@Entity
@Table(name = "t_dias", catalog = "db_hospital_dia_v3", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TDias.findAll", query = "SELECT t FROM TDias t"),
    @NamedQuery(name = "TDias.findByDSerial", query = "SELECT t FROM TDias t WHERE t.dSerial = :dSerial"),
    @NamedQuery(name = "TDias.findByDDescripcion", query = "SELECT t FROM TDias t WHERE t.dDescripcion = :dDescripcion")})
public class TDias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "d_serial", nullable = false)
    private Integer dSerial;
    @Size(max = 150)
    @Column(name = "d_descripcion", length = 150)
    private String dDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tDias")
    private List<THorario> tHorarioList;

    public TDias() {
    }

    public TDias(Integer dSerial) {
        this.dSerial = dSerial;
    }

    public Integer getDSerial() {
        return dSerial;
    }

    public void setDSerial(Integer dSerial) {
        this.dSerial = dSerial;
    }

    public String getDDescripcion() {
        return dDescripcion;
    }

    public void setDDescripcion(String dDescripcion) {
        this.dDescripcion = dDescripcion;
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
        hash += (dSerial != null ? dSerial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TDias)) {
            return false;
        }
        TDias other = (TDias) object;
        if ((this.dSerial == null && other.dSerial != null) || (this.dSerial != null && !this.dSerial.equals(other.dSerial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.capa.datos.TDias[ dSerial=" + dSerial + " ]";
    }
    
}
