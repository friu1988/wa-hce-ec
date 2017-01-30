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
@Table(name = "t_bacteriologia", catalog = "db_hospital_dia_v3", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TBacteriologia.findAll", query = "SELECT t FROM TBacteriologia t"),
    @NamedQuery(name = "TBacteriologia.findByBacSerial", query = "SELECT t FROM TBacteriologia t WHERE t.bacSerial = :bacSerial"),
    @NamedQuery(name = "TBacteriologia.findByBacDescripcion", query = "SELECT t FROM TBacteriologia t WHERE t.bacDescripcion = :bacDescripcion")})
public class TBacteriologia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bac_serial", nullable = false)
    private Integer bacSerial;
    @Size(max = 250)
    @Column(name = "bac_descripcion", length = 250)
    private String bacDescripcion;
    @OneToMany(mappedBy = "bacSerial")
    private List<TExamenes> tExamenesList;

    public TBacteriologia() {
    }

    public TBacteriologia(Integer bacSerial) {
        this.bacSerial = bacSerial;
    }

    public Integer getBacSerial() {
        return bacSerial;
    }

    public void setBacSerial(Integer bacSerial) {
        this.bacSerial = bacSerial;
    }

    public String getBacDescripcion() {
        return bacDescripcion;
    }

    public void setBacDescripcion(String bacDescripcion) {
        this.bacDescripcion = bacDescripcion;
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
        hash += (bacSerial != null ? bacSerial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TBacteriologia)) {
            return false;
        }
        TBacteriologia other = (TBacteriologia) object;
        if ((this.bacSerial == null && other.bacSerial != null) || (this.bacSerial != null && !this.bacSerial.equals(other.bacSerial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.capa.datos.TBacteriologia[ bacSerial=" + bacSerial + " ]";
    }
    
}
