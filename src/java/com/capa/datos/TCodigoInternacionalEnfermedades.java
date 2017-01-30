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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FREDDY
 */
@Entity
@Table(name = "t_codigo_internacional_enfermedades", catalog = "db_hospital_dia_v3", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TCodigoInternacionalEnfermedades.findAll", query = "SELECT t FROM TCodigoInternacionalEnfermedades t"),
    @NamedQuery(name = "TCodigoInternacionalEnfermedades.findByCieSerial", query = "SELECT t FROM TCodigoInternacionalEnfermedades t WHERE t.cieSerial = :cieSerial"),
    @NamedQuery(name = "TCodigoInternacionalEnfermedades.findByCieDescripcion", query = "SELECT t FROM TCodigoInternacionalEnfermedades t WHERE t.cieDescripcion = :cieDescripcion")})
public class TCodigoInternacionalEnfermedades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "cie_serial", nullable = false, length = 8)
    private String cieSerial;
    @Size(max = 250)
    @Column(name = "cie_descripcion", length = 250)
    private String cieDescripcion;
    @OneToMany(mappedBy = "padreCieSerial")
    private List<TCodigoInternacionalEnfermedades> tCodigoInternacionalEnfermedadesList;
    @JoinColumn(name = "padre_cie_serial", referencedColumnName = "cie_serial")
    @ManyToOne
    private TCodigoInternacionalEnfermedades padreCieSerial;
    @OneToMany(mappedBy = "cieSerial")
    private List<TDiagnostico> tDiagnosticoList;

    public TCodigoInternacionalEnfermedades() {
    }

    public TCodigoInternacionalEnfermedades(String cieSerial) {
        this.cieSerial = cieSerial;
    }

    public String getCieSerial() {
        return cieSerial;
    }

    public void setCieSerial(String cieSerial) {
        this.cieSerial = cieSerial;
    }

    public String getCieDescripcion() {
        return cieDescripcion;
    }

    public void setCieDescripcion(String cieDescripcion) {
        this.cieDescripcion = cieDescripcion;
    }

    @XmlTransient
    public List<TCodigoInternacionalEnfermedades> getTCodigoInternacionalEnfermedadesList() {
        return tCodigoInternacionalEnfermedadesList;
    }

    public void setTCodigoInternacionalEnfermedadesList(List<TCodigoInternacionalEnfermedades> tCodigoInternacionalEnfermedadesList) {
        this.tCodigoInternacionalEnfermedadesList = tCodigoInternacionalEnfermedadesList;
    }

    public TCodigoInternacionalEnfermedades getPadreCieSerial() {
        return padreCieSerial;
    }

    public void setPadreCieSerial(TCodigoInternacionalEnfermedades padreCieSerial) {
        this.padreCieSerial = padreCieSerial;
    }

    @XmlTransient
    public List<TDiagnostico> getTDiagnosticoList() {
        return tDiagnosticoList;
    }

    public void setTDiagnosticoList(List<TDiagnostico> tDiagnosticoList) {
        this.tDiagnosticoList = tDiagnosticoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cieSerial != null ? cieSerial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TCodigoInternacionalEnfermedades)) {
            return false;
        }
        TCodigoInternacionalEnfermedades other = (TCodigoInternacionalEnfermedades) object;
        if ((this.cieSerial == null && other.cieSerial != null) || (this.cieSerial != null && !this.cieSerial.equals(other.cieSerial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.capa.datos.TCodigoInternacionalEnfermedades[ cieSerial=" + cieSerial + " ]";
    }
    
}
