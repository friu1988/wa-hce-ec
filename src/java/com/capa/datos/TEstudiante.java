/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capa.datos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FREDDY
 */
@Entity
@Table(name = "t_estudiante", catalog = "db_hospital_dia_v3", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TEstudiante.findAll", query = "SELECT t FROM TEstudiante t"),
    @NamedQuery(name = "TEstudiante.findByEstSerial", query = "SELECT t FROM TEstudiante t WHERE t.estSerial = :estSerial"),
    @NamedQuery(name = "TEstudiante.findByEstPeriodo", query = "SELECT t FROM TEstudiante t WHERE t.estPeriodo = :estPeriodo")})
public class TEstudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "est_serial", nullable = false)
    private Integer estSerial;
    @Size(max = 9)
    @Column(name = "est_periodo", length = 9)
    private String estPeriodo;
    @JoinColumn(name = "fac_serial", referencedColumnName = "fac_serial")
    @ManyToOne
    private TFacultad facSerial;

    public TEstudiante() {
    }

    public TEstudiante(Integer estSerial) {
        this.estSerial = estSerial;
    }

    public Integer getEstSerial() {
        return estSerial;
    }

    public void setEstSerial(Integer estSerial) {
        this.estSerial = estSerial;
    }

    public String getEstPeriodo() {
        return estPeriodo;
    }

    public void setEstPeriodo(String estPeriodo) {
        this.estPeriodo = estPeriodo;
    }

    public TFacultad getFacSerial() {
        return facSerial;
    }

    public void setFacSerial(TFacultad facSerial) {
        this.facSerial = facSerial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estSerial != null ? estSerial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TEstudiante)) {
            return false;
        }
        TEstudiante other = (TEstudiante) object;
        if ((this.estSerial == null && other.estSerial != null) || (this.estSerial != null && !this.estSerial.equals(other.estSerial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.capa.datos.TEstudiante[ estSerial=" + estSerial + " ]";
    }
    
}
