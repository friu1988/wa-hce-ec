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
@Table(name = "t_serologia", catalog = "db_hospital_dia_v3", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TSerologia.findAll", query = "SELECT t FROM TSerologia t"),
    @NamedQuery(name = "TSerologia.findBySerSerial", query = "SELECT t FROM TSerologia t WHERE t.serSerial = :serSerial"),
    @NamedQuery(name = "TSerologia.findBySerLatex", query = "SELECT t FROM TSerologia t WHERE t.serLatex = :serLatex"),
    @NamedQuery(name = "TSerologia.findBySerA5to", query = "SELECT t FROM TSerologia t WHERE t.serA5to = :serA5to"),
    @NamedQuery(name = "TSerologia.findBySerVdrl", query = "SELECT t FROM TSerologia t WHERE t.serVdrl = :serVdrl"),
    @NamedQuery(name = "TSerologia.findBySerAglutinacionesFebriles", query = "SELECT t FROM TSerologia t WHERE t.serAglutinacionesFebriles = :serAglutinacionesFebriles")})
public class TSerologia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ser_serial", nullable = false)
    private Integer serSerial;
    @Size(max = 100)
    @Column(name = "ser_latex", length = 100)
    private String serLatex;
    @Size(max = 100)
    @Column(name = "ser_a5to", length = 100)
    private String serA5to;
    @Size(max = 100)
    @Column(name = "ser_vdrl", length = 100)
    private String serVdrl;
    @Size(max = 100)
    @Column(name = "ser_aglutinaciones_febriles", length = 100)
    private String serAglutinacionesFebriles;
    @OneToMany(mappedBy = "serSerial")
    private List<TExamenes> tExamenesList;

    public TSerologia() {
    }

    public TSerologia(Integer serSerial) {
        this.serSerial = serSerial;
    }

    public Integer getSerSerial() {
        return serSerial;
    }

    public void setSerSerial(Integer serSerial) {
        this.serSerial = serSerial;
    }

    public String getSerLatex() {
        return serLatex;
    }

    public void setSerLatex(String serLatex) {
        this.serLatex = serLatex;
    }

    public String getSerA5to() {
        return serA5to;
    }

    public void setSerA5to(String serA5to) {
        this.serA5to = serA5to;
    }

    public String getSerVdrl() {
        return serVdrl;
    }

    public void setSerVdrl(String serVdrl) {
        this.serVdrl = serVdrl;
    }

    public String getSerAglutinacionesFebriles() {
        return serAglutinacionesFebriles;
    }

    public void setSerAglutinacionesFebriles(String serAglutinacionesFebriles) {
        this.serAglutinacionesFebriles = serAglutinacionesFebriles;
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
        hash += (serSerial != null ? serSerial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TSerologia)) {
            return false;
        }
        TSerologia other = (TSerologia) object;
        if ((this.serSerial == null && other.serSerial != null) || (this.serSerial != null && !this.serSerial.equals(other.serSerial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.capa.datos.TSerologia[ serSerial=" + serSerial + " ]";
    }
    
}
