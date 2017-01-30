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
@Table(name = "t_consultorio", catalog = "db_hospital_dia_v3", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TConsultorio.findAll", query = "SELECT t FROM TConsultorio t"),
    @NamedQuery(name = "TConsultorio.findByCoSerial", query = "SELECT t FROM TConsultorio t WHERE t.coSerial = :coSerial"),
    @NamedQuery(name = "TConsultorio.findByCoUbicacion", query = "SELECT t FROM TConsultorio t WHERE t.coUbicacion = :coUbicacion"),
    @NamedQuery(name = "TConsultorio.findByCoNumero", query = "SELECT t FROM TConsultorio t WHERE t.coNumero = :coNumero")})
public class TConsultorio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "co_serial", nullable = false)
    private Integer coSerial;
    @Size(max = 100)
    @Column(name = "co_ubicacion", length = 100)
    private String coUbicacion;
    @Column(name = "co_numero")
    private Integer coNumero;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coSerial")
    private List<TMedico> tMedicoList;

    public TConsultorio() {
    }

    public TConsultorio(Integer coSerial) {
        this.coSerial = coSerial;
    }

    public Integer getCoSerial() {
        return coSerial;
    }

    public void setCoSerial(Integer coSerial) {
        this.coSerial = coSerial;
    }

    public String getCoUbicacion() {
        return coUbicacion;
    }

    public void setCoUbicacion(String coUbicacion) {
        this.coUbicacion = coUbicacion;
    }

    public Integer getCoNumero() {
        return coNumero;
    }

    public void setCoNumero(Integer coNumero) {
        this.coNumero = coNumero;
    }

    @XmlTransient
    public List<TMedico> getTMedicoList() {
        return tMedicoList;
    }

    public void setTMedicoList(List<TMedico> tMedicoList) {
        this.tMedicoList = tMedicoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coSerial != null ? coSerial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TConsultorio)) {
            return false;
        }
        TConsultorio other = (TConsultorio) object;
        if ((this.coSerial == null && other.coSerial != null) || (this.coSerial != null && !this.coSerial.equals(other.coSerial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.capa.datos.TConsultorio[ coSerial=" + coSerial + " ]";
    }
    
}
