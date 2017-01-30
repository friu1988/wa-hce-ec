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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FREDDY
 */
@Entity
@Table(name = "t_antecedentes_familiares", catalog = "db_hospital_dia_v3", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TAntecedentesFamiliares.findAll", query = "SELECT t FROM TAntecedentesFamiliares t"),
    @NamedQuery(name = "TAntecedentesFamiliares.findByAfSerial", query = "SELECT t FROM TAntecedentesFamiliares t WHERE t.afSerial = :afSerial"),
    @NamedQuery(name = "TAntecedentesFamiliares.findByAfCardiopatia", query = "SELECT t FROM TAntecedentesFamiliares t WHERE t.afCardiopatia = :afCardiopatia"),
    @NamedQuery(name = "TAntecedentesFamiliares.findByAfDiabetes", query = "SELECT t FROM TAntecedentesFamiliares t WHERE t.afDiabetes = :afDiabetes"),
    @NamedQuery(name = "TAntecedentesFamiliares.findByAfCardioVascular", query = "SELECT t FROM TAntecedentesFamiliares t WHERE t.afCardioVascular = :afCardioVascular"),
    @NamedQuery(name = "TAntecedentesFamiliares.findByAfHipertension", query = "SELECT t FROM TAntecedentesFamiliares t WHERE t.afHipertension = :afHipertension"),
    @NamedQuery(name = "TAntecedentesFamiliares.findByAfCancer", query = "SELECT t FROM TAntecedentesFamiliares t WHERE t.afCancer = :afCancer"),
    @NamedQuery(name = "TAntecedentesFamiliares.findByAfTuberculosis", query = "SELECT t FROM TAntecedentesFamiliares t WHERE t.afTuberculosis = :afTuberculosis"),
    @NamedQuery(name = "TAntecedentesFamiliares.findByAfMental", query = "SELECT t FROM TAntecedentesFamiliares t WHERE t.afMental = :afMental"),
    @NamedQuery(name = "TAntecedentesFamiliares.findByAfInfecciosa", query = "SELECT t FROM TAntecedentesFamiliares t WHERE t.afInfecciosa = :afInfecciosa"),
    @NamedQuery(name = "TAntecedentesFamiliares.findByAfMalformacion", query = "SELECT t FROM TAntecedentesFamiliares t WHERE t.afMalformacion = :afMalformacion"),
    @NamedQuery(name = "TAntecedentesFamiliares.findByAfOtros", query = "SELECT t FROM TAntecedentesFamiliares t WHERE t.afOtros = :afOtros")})
public class TAntecedentesFamiliares implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "af_serial", nullable = false)
    private Integer afSerial;
    @Column(name = "af_cardiopatia")
    private Boolean afCardiopatia;
    @Column(name = "af_diabetes")
    private Boolean afDiabetes;
    @Column(name = "af_cardio_vascular")
    private Boolean afCardioVascular;
    @Column(name = "af_hipertension")
    private Boolean afHipertension;
    @Column(name = "af_cancer")
    private Boolean afCancer;
    @Column(name = "af_tuberculosis")
    private Boolean afTuberculosis;
    @Column(name = "af_mental")
    private Boolean afMental;
    @Column(name = "af_infecciosa")
    private Boolean afInfecciosa;
    @Column(name = "af_malformacion")
    private Boolean afMalformacion;
    @Column(name = "af_otros")
    private Boolean afOtros;
    @JoinColumn(name = "cex_serial", referencedColumnName = "cex_serial", nullable = false)
    @ManyToOne(optional = false)
    private TConsultaExterna cexSerial;

    public TAntecedentesFamiliares() {
    }

    public TAntecedentesFamiliares(Integer afSerial) {
        this.afSerial = afSerial;
    }

    public Integer getAfSerial() {
        return afSerial;
    }

    public void setAfSerial(Integer afSerial) {
        this.afSerial = afSerial;
    }

    public Boolean getAfCardiopatia() {
        return afCardiopatia;
    }

    public void setAfCardiopatia(Boolean afCardiopatia) {
        this.afCardiopatia = afCardiopatia;
    }

    public Boolean getAfDiabetes() {
        return afDiabetes;
    }

    public void setAfDiabetes(Boolean afDiabetes) {
        this.afDiabetes = afDiabetes;
    }

    public Boolean getAfCardioVascular() {
        return afCardioVascular;
    }

    public void setAfCardioVascular(Boolean afCardioVascular) {
        this.afCardioVascular = afCardioVascular;
    }

    public Boolean getAfHipertension() {
        return afHipertension;
    }

    public void setAfHipertension(Boolean afHipertension) {
        this.afHipertension = afHipertension;
    }

    public Boolean getAfCancer() {
        return afCancer;
    }

    public void setAfCancer(Boolean afCancer) {
        this.afCancer = afCancer;
    }

    public Boolean getAfTuberculosis() {
        return afTuberculosis;
    }

    public void setAfTuberculosis(Boolean afTuberculosis) {
        this.afTuberculosis = afTuberculosis;
    }

    public Boolean getAfMental() {
        return afMental;
    }

    public void setAfMental(Boolean afMental) {
        this.afMental = afMental;
    }

    public Boolean getAfInfecciosa() {
        return afInfecciosa;
    }

    public void setAfInfecciosa(Boolean afInfecciosa) {
        this.afInfecciosa = afInfecciosa;
    }

    public Boolean getAfMalformacion() {
        return afMalformacion;
    }

    public void setAfMalformacion(Boolean afMalformacion) {
        this.afMalformacion = afMalformacion;
    }

    public Boolean getAfOtros() {
        return afOtros;
    }

    public void setAfOtros(Boolean afOtros) {
        this.afOtros = afOtros;
    }

    public TConsultaExterna getCexSerial() {
        return cexSerial;
    }

    public void setCexSerial(TConsultaExterna cexSerial) {
        this.cexSerial = cexSerial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (afSerial != null ? afSerial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TAntecedentesFamiliares)) {
            return false;
        }
        TAntecedentesFamiliares other = (TAntecedentesFamiliares) object;
        if ((this.afSerial == null && other.afSerial != null) || (this.afSerial != null && !this.afSerial.equals(other.afSerial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.capa.datos.TAntecedentesFamiliares[ afSerial=" + afSerial + " ]";
    }
    
}
