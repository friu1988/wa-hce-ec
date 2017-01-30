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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "t_diagnostico", catalog = "db_hospital_dia_v3", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TDiagnostico.findAll", query = "SELECT t FROM TDiagnostico t"),
    @NamedQuery(name = "TDiagnostico.findByDiagSerial", query = "SELECT t FROM TDiagnostico t WHERE t.diagSerial = :diagSerial"),
    @NamedQuery(name = "TDiagnostico.findByDiagDescripcion", query = "SELECT t FROM TDiagnostico t WHERE t.diagDescripcion = :diagDescripcion"),
    @NamedQuery(name = "TDiagnostico.findByDiagTipo", query = "SELECT t FROM TDiagnostico t WHERE t.diagTipo = :diagTipo")})
public class TDiagnostico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "diag_serial", nullable = false)
    private Integer diagSerial;
    @Size(max = 100)
    @Column(name = "diag_descripcion", length = 100)
    private String diagDescripcion;
    @Size(max = 100)
    @Column(name = "diag_tipo", length = 100)
    private String diagTipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "diagSerial")
    private List<TTratamiento> tTratamientoList;
    @JoinColumn(name = "cex_serial", referencedColumnName = "cex_serial", nullable = false)
    @ManyToOne(optional = false)
    private TConsultaExterna cexSerial;
    @JoinColumn(name = "cie_serial", referencedColumnName = "cie_serial")
    @ManyToOne
    private TCodigoInternacionalEnfermedades cieSerial;

    public TDiagnostico() {
    }

    public TDiagnostico(Integer diagSerial) {
        this.diagSerial = diagSerial;
    }

    public Integer getDiagSerial() {
        return diagSerial;
    }

    public void setDiagSerial(Integer diagSerial) {
        this.diagSerial = diagSerial;
    }

    public String getDiagDescripcion() {
        return diagDescripcion;
    }

    public void setDiagDescripcion(String diagDescripcion) {
        this.diagDescripcion = diagDescripcion;
    }

    public String getDiagTipo() {
        return diagTipo;
    }

    public void setDiagTipo(String diagTipo) {
        this.diagTipo = diagTipo;
    }

    @XmlTransient
    public List<TTratamiento> getTTratamientoList() {
        return tTratamientoList;
    }

    public void setTTratamientoList(List<TTratamiento> tTratamientoList) {
        this.tTratamientoList = tTratamientoList;
    }

    public TConsultaExterna getCexSerial() {
        return cexSerial;
    }

    public void setCexSerial(TConsultaExterna cexSerial) {
        this.cexSerial = cexSerial;
    }

    public TCodigoInternacionalEnfermedades getCieSerial() {
        return cieSerial;
    }

    public void setCieSerial(TCodigoInternacionalEnfermedades cieSerial) {
        this.cieSerial = cieSerial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (diagSerial != null ? diagSerial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TDiagnostico)) {
            return false;
        }
        TDiagnostico other = (TDiagnostico) object;
        if ((this.diagSerial == null && other.diagSerial != null) || (this.diagSerial != null && !this.diagSerial.equals(other.diagSerial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.capa.datos.TDiagnostico[ diagSerial=" + diagSerial + " ]";
    }
    
}
