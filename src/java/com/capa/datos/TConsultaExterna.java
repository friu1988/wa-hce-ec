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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FREDDY
 */
@Entity
@Table(name = "t_consulta_externa", catalog = "db_hospital_dia_v3", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TConsultaExterna.findAll", query = "SELECT t FROM TConsultaExterna t"),
    @NamedQuery(name = "TConsultaExterna.findByCexSerial", query = "SELECT t FROM TConsultaExterna t WHERE t.cexSerial = :cexSerial"),
    @NamedQuery(name = "TConsultaExterna.findByCexFecha", query = "SELECT t FROM TConsultaExterna t WHERE t.cexFecha = :cexFecha"),
    @NamedQuery(name = "TConsultaExterna.findByCexMotivoConsulta", query = "SELECT t FROM TConsultaExterna t WHERE t.cexMotivoConsulta = :cexMotivoConsulta"),
    @NamedQuery(name = "TConsultaExterna.findByCexAntecedentesPersonales", query = "SELECT t FROM TConsultaExterna t WHERE t.cexAntecedentesPersonales = :cexAntecedentesPersonales"),
    @NamedQuery(name = "TConsultaExterna.findByCexEnfermedadActual", query = "SELECT t FROM TConsultaExterna t WHERE t.cexEnfermedadActual = :cexEnfermedadActual")})
public class TConsultaExterna implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cex_serial", nullable = false)
    private Integer cexSerial;
    @Column(name = "cex_fecha")
    @Temporal(TemporalType.DATE)
    private Date cexFecha;
    @Size(max = 200)
    @Column(name = "cex_motivo_consulta", length = 200)
    private String cexMotivoConsulta;
    @Size(max = 200)
    @Column(name = "cex_antecedentes_personales", length = 200)
    private String cexAntecedentesPersonales;
    @Size(max = 200)
    @Column(name = "cex_enfermedad_actual", length = 200)
    private String cexEnfermedadActual;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cexSerial")
    private List<TExamenes> tExamenesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cexSerial")
    private List<TOrganosSistemas> tOrganosSistemasList;
    @OneToMany(mappedBy = "cexSerial")
    private List<TExamenFisicoRegional> tExamenFisicoRegionalList;
    @JoinColumn(name = "tur_serial", referencedColumnName = "tur_serial", nullable = false)
    @ManyToOne(optional = false)
    private TTurno turSerial;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cexSerial")
    private List<TSignosVitales> tSignosVitalesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cexSerial")
    private List<TAntecedentesFamiliares> tAntecedentesFamiliaresList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cexSerial")
    private List<TDiagnostico> tDiagnosticoList;
    @OneToMany(mappedBy = "cexSerial")
    private List<TExamenEspecial> tExamenEspecialList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cexSerial")
    private List<TEvolucionPrescripcion> tEvolucionPrescripcionList;

    public TConsultaExterna() {
    }

    public TConsultaExterna(Integer cexSerial) {
        this.cexSerial = cexSerial;
    }

    public Integer getCexSerial() {
        return cexSerial;
    }

    public void setCexSerial(Integer cexSerial) {
        this.cexSerial = cexSerial;
    }

    public Date getCexFecha() {
        return cexFecha;
    }

    public void setCexFecha(Date cexFecha) {
        this.cexFecha = cexFecha;
    }

    public String getCexMotivoConsulta() {
        return cexMotivoConsulta;
    }

    public void setCexMotivoConsulta(String cexMotivoConsulta) {
        this.cexMotivoConsulta = cexMotivoConsulta;
    }

    public String getCexAntecedentesPersonales() {
        return cexAntecedentesPersonales;
    }

    public void setCexAntecedentesPersonales(String cexAntecedentesPersonales) {
        this.cexAntecedentesPersonales = cexAntecedentesPersonales;
    }

    public String getCexEnfermedadActual() {
        return cexEnfermedadActual;
    }

    public void setCexEnfermedadActual(String cexEnfermedadActual) {
        this.cexEnfermedadActual = cexEnfermedadActual;
    }

    @XmlTransient
    public List<TExamenes> getTExamenesList() {
        return tExamenesList;
    }

    public void setTExamenesList(List<TExamenes> tExamenesList) {
        this.tExamenesList = tExamenesList;
    }

    @XmlTransient
    public List<TOrganosSistemas> getTOrganosSistemasList() {
        return tOrganosSistemasList;
    }

    public void setTOrganosSistemasList(List<TOrganosSistemas> tOrganosSistemasList) {
        this.tOrganosSistemasList = tOrganosSistemasList;
    }

    @XmlTransient
    public List<TExamenFisicoRegional> getTExamenFisicoRegionalList() {
        return tExamenFisicoRegionalList;
    }

    public void setTExamenFisicoRegionalList(List<TExamenFisicoRegional> tExamenFisicoRegionalList) {
        this.tExamenFisicoRegionalList = tExamenFisicoRegionalList;
    }

    public TTurno getTurSerial() {
        return turSerial;
    }

    public void setTurSerial(TTurno turSerial) {
        this.turSerial = turSerial;
    }

    @XmlTransient
    public List<TSignosVitales> getTSignosVitalesList() {
        return tSignosVitalesList;
    }

    public void setTSignosVitalesList(List<TSignosVitales> tSignosVitalesList) {
        this.tSignosVitalesList = tSignosVitalesList;
    }

    @XmlTransient
    public List<TAntecedentesFamiliares> getTAntecedentesFamiliaresList() {
        return tAntecedentesFamiliaresList;
    }

    public void setTAntecedentesFamiliaresList(List<TAntecedentesFamiliares> tAntecedentesFamiliaresList) {
        this.tAntecedentesFamiliaresList = tAntecedentesFamiliaresList;
    }

    @XmlTransient
    public List<TDiagnostico> getTDiagnosticoList() {
        return tDiagnosticoList;
    }

    public void setTDiagnosticoList(List<TDiagnostico> tDiagnosticoList) {
        this.tDiagnosticoList = tDiagnosticoList;
    }

    @XmlTransient
    public List<TExamenEspecial> getTExamenEspecialList() {
        return tExamenEspecialList;
    }

    public void setTExamenEspecialList(List<TExamenEspecial> tExamenEspecialList) {
        this.tExamenEspecialList = tExamenEspecialList;
    }

    @XmlTransient
    public List<TEvolucionPrescripcion> getTEvolucionPrescripcionList() {
        return tEvolucionPrescripcionList;
    }

    public void setTEvolucionPrescripcionList(List<TEvolucionPrescripcion> tEvolucionPrescripcionList) {
        this.tEvolucionPrescripcionList = tEvolucionPrescripcionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cexSerial != null ? cexSerial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TConsultaExterna)) {
            return false;
        }
        TConsultaExterna other = (TConsultaExterna) object;
        if ((this.cexSerial == null && other.cexSerial != null) || (this.cexSerial != null && !this.cexSerial.equals(other.cexSerial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.capa.datos.TConsultaExterna[ cexSerial=" + cexSerial + " ]";
    }
    
}
