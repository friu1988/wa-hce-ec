/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capa.datos;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FREDDY
 */
@Entity
@Table(name = "t_examenes", catalog = "db_hospital_dia_v3", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TExamenes.findAll", query = "SELECT t FROM TExamenes t"),
    @NamedQuery(name = "TExamenes.findByExmSerial", query = "SELECT t FROM TExamenes t WHERE t.exmSerial = :exmSerial"),
    @NamedQuery(name = "TExamenes.findByExmComponente", query = "SELECT t FROM TExamenes t WHERE t.exmComponente = :exmComponente"),
    @NamedQuery(name = "TExamenes.findByExmFechaTranscripcion", query = "SELECT t FROM TExamenes t WHERE t.exmFechaTranscripcion = :exmFechaTranscripcion"),
    @NamedQuery(name = "TExamenes.findByExmResponsable", query = "SELECT t FROM TExamenes t WHERE t.exmResponsable = :exmResponsable"),
    @NamedQuery(name = "TExamenes.findByExmFechaReporte", query = "SELECT t FROM TExamenes t WHERE t.exmFechaReporte = :exmFechaReporte")})
public class TExamenes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "exm_serial", nullable = false)
    private Integer exmSerial;
    @Size(max = 200)
    @Column(name = "exm_componente", length = 200)
    private String exmComponente;
    @Column(name = "exm_fecha_transcripcion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date exmFechaTranscripcion;
    @Size(max = 200)
    @Column(name = "exm_responsable", length = 200)
    private String exmResponsable;
    @Column(name = "exm_fecha_reporte")
    @Temporal(TemporalType.TIMESTAMP)
    private Date exmFechaReporte;
    @JoinColumn(name = "ot_serial", referencedColumnName = "ot_serial")
    @ManyToOne
    private TOtros otSerial;
    @JoinColumn(name = "ser_serial", referencedColumnName = "ser_serial")
    @ManyToOne
    private TSerologia serSerial;
    @JoinColumn(name = "cex_serial", referencedColumnName = "cex_serial", nullable = false)
    @ManyToOne(optional = false)
    private TConsultaExterna cexSerial;
    @JoinColumn(name = "he_serial", referencedColumnName = "he_serial")
    @ManyToOne
    private THematologico heSerial;
    @JoinColumn(name = "uro_serial", referencedColumnName = "uro_serial")
    @ManyToOne
    private TUroanalisis uroSerial;
    @JoinColumn(name = "cop_serial", referencedColumnName = "cop_serial")
    @ManyToOne
    private TCoprologico copSerial;
    @JoinColumn(name = "bac_serial", referencedColumnName = "bac_serial")
    @ManyToOne
    private TBacteriologia bacSerial;

    public TExamenes() {
    }

    public TExamenes(Integer exmSerial) {
        this.exmSerial = exmSerial;
    }

    public Integer getExmSerial() {
        return exmSerial;
    }

    public void setExmSerial(Integer exmSerial) {
        this.exmSerial = exmSerial;
    }

    public String getExmComponente() {
        return exmComponente;
    }

    public void setExmComponente(String exmComponente) {
        this.exmComponente = exmComponente;
    }

    public Date getExmFechaTranscripcion() {
        return exmFechaTranscripcion;
    }

    public void setExmFechaTranscripcion(Date exmFechaTranscripcion) {
        this.exmFechaTranscripcion = exmFechaTranscripcion;
    }

    public String getExmResponsable() {
        return exmResponsable;
    }

    public void setExmResponsable(String exmResponsable) {
        this.exmResponsable = exmResponsable;
    }

    public Date getExmFechaReporte() {
        return exmFechaReporte;
    }

    public void setExmFechaReporte(Date exmFechaReporte) {
        this.exmFechaReporte = exmFechaReporte;
    }

    public TOtros getOtSerial() {
        return otSerial;
    }

    public void setOtSerial(TOtros otSerial) {
        this.otSerial = otSerial;
    }

    public TSerologia getSerSerial() {
        return serSerial;
    }

    public void setSerSerial(TSerologia serSerial) {
        this.serSerial = serSerial;
    }

    public TConsultaExterna getCexSerial() {
        return cexSerial;
    }

    public void setCexSerial(TConsultaExterna cexSerial) {
        this.cexSerial = cexSerial;
    }

    public THematologico getHeSerial() {
        return heSerial;
    }

    public void setHeSerial(THematologico heSerial) {
        this.heSerial = heSerial;
    }

    public TUroanalisis getUroSerial() {
        return uroSerial;
    }

    public void setUroSerial(TUroanalisis uroSerial) {
        this.uroSerial = uroSerial;
    }

    public TCoprologico getCopSerial() {
        return copSerial;
    }

    public void setCopSerial(TCoprologico copSerial) {
        this.copSerial = copSerial;
    }

    public TBacteriologia getBacSerial() {
        return bacSerial;
    }

    public void setBacSerial(TBacteriologia bacSerial) {
        this.bacSerial = bacSerial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (exmSerial != null ? exmSerial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TExamenes)) {
            return false;
        }
        TExamenes other = (TExamenes) object;
        if ((this.exmSerial == null && other.exmSerial != null) || (this.exmSerial != null && !this.exmSerial.equals(other.exmSerial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.capa.datos.TExamenes[ exmSerial=" + exmSerial + " ]";
    }
    
}
