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
@Table(name = "t_otros", catalog = "db_hospital_dia_v3", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TOtros.findAll", query = "SELECT t FROM TOtros t"),
    @NamedQuery(name = "TOtros.findByOtSerial", query = "SELECT t FROM TOtros t WHERE t.otSerial = :otSerial"),
    @NamedQuery(name = "TOtros.findByOtDetalle", query = "SELECT t FROM TOtros t WHERE t.otDetalle = :otDetalle")})
public class TOtros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ot_serial", nullable = false)
    private Integer otSerial;
    @Size(max = 150)
    @Column(name = "ot_detalle", length = 150)
    private String otDetalle;
    @OneToMany(mappedBy = "otSerial")
    private List<TExamenes> tExamenesList;

    public TOtros() {
    }

    public TOtros(Integer otSerial) {
        this.otSerial = otSerial;
    }

    public Integer getOtSerial() {
        return otSerial;
    }

    public void setOtSerial(Integer otSerial) {
        this.otSerial = otSerial;
    }

    public String getOtDetalle() {
        return otDetalle;
    }

    public void setOtDetalle(String otDetalle) {
        this.otDetalle = otDetalle;
    }

    @XmlTransient
    public List<TExamenes> getTExamenesList() {
        return tExamenesList;
    }

    public void setTExamenesList(List<TExamenes> tExamenesList) {
        this.tExamenesList = tExamenesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (otSerial != null ? otSerial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TOtros)) {
            return false;
        }
        TOtros other = (TOtros) object;
        if ((this.otSerial == null && other.otSerial != null) || (this.otSerial != null && !this.otSerial.equals(other.otSerial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.capa.datos.TOtros[ otSerial=" + otSerial + " ]";
    }
    
}
