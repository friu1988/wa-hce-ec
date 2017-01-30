/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capa.datos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FREDDY
 */
@Entity
@Table(name = "t_especialidad", catalog = "db_hospital_dia_v3", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TEspecialidad.findAll", query = "SELECT t FROM TEspecialidad t"),
    @NamedQuery(name = "TEspecialidad.findByEspSerial", query = "SELECT t FROM TEspecialidad t WHERE t.espSerial = :espSerial"),
    @NamedQuery(name = "TEspecialidad.findByEspNombre", query = "SELECT t FROM TEspecialidad t WHERE t.espNombre = :espNombre")})
public class TEspecialidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "esp_serial", nullable = false)
    private Integer espSerial;
    @Size(max = 100)
    @Column(name = "esp_nombre", length = 100)
    private String espNombre;
    @JoinTable(name = "t_personal_salud", joinColumns = {
        @JoinColumn(name = "esp_serial", referencedColumnName = "esp_serial", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "per_serial", referencedColumnName = "per_serial", nullable = false)})
    @ManyToMany
    private List<TMedico> tMedicoList;

    public TEspecialidad() {
    }

    public TEspecialidad(Integer espSerial) {
        this.espSerial = espSerial;
    }

    public Integer getEspSerial() {
        return espSerial;
    }

    public void setEspSerial(Integer espSerial) {
        this.espSerial = espSerial;
    }

    public String getEspNombre() {
        return espNombre;
    }

    public void setEspNombre(String espNombre) {
        this.espNombre = espNombre;
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
        hash += (espSerial != null ? espSerial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TEspecialidad)) {
            return false;
        }
        TEspecialidad other = (TEspecialidad) object;
        if ((this.espSerial == null && other.espSerial != null) || (this.espSerial != null && !this.espSerial.equals(other.espSerial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.capa.datos.TEspecialidad[ espSerial=" + espSerial + " ]";
    }
    
}
