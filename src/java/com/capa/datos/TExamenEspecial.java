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
@Table(name = "t_examen_especial", catalog = "db_hospital_dia_v3", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TExamenEspecial.findAll", query = "SELECT t FROM TExamenEspecial t"),
    @NamedQuery(name = "TExamenEspecial.findByEeSerial", query = "SELECT t FROM TExamenEspecial t WHERE t.eeSerial = :eeSerial"),
    @NamedQuery(name = "TExamenEspecial.findByEeFechaTranscripcion", query = "SELECT t FROM TExamenEspecial t WHERE t.eeFechaTranscripcion = :eeFechaTranscripcion"),
    @NamedQuery(name = "TExamenEspecial.findByEeEstudioSolicitado", query = "SELECT t FROM TExamenEspecial t WHERE t.eeEstudioSolicitado = :eeEstudioSolicitado"),
    @NamedQuery(name = "TExamenEspecial.findByEeResultado", query = "SELECT t FROM TExamenEspecial t WHERE t.eeResultado = :eeResultado"),
    @NamedQuery(name = "TExamenEspecial.findByEeResponsable", query = "SELECT t FROM TExamenEspecial t WHERE t.eeResponsable = :eeResponsable")})
public class TExamenEspecial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ee_serial", nullable = false)
    private Integer eeSerial;
    @Column(name = "ee_fecha_transcripcion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eeFechaTranscripcion;
    @Size(max = 250)
    @Column(name = "ee_estudio_solicitado", length = 250)
    private String eeEstudioSolicitado;
    @Size(max = 250)
    @Column(name = "ee_resultado", length = 250)
    private String eeResultado;
    @Size(max = 250)
    @Column(name = "ee_responsable", length = 250)
    private String eeResponsable;
    @JoinColumn(name = "cex_serial", referencedColumnName = "cex_serial")
    @ManyToOne
    private TConsultaExterna cexSerial;

    public TExamenEspecial() {
    }

    public TExamenEspecial(Integer eeSerial) {
        this.eeSerial = eeSerial;
    }

    public Integer getEeSerial() {
        return eeSerial;
    }

    public void setEeSerial(Integer eeSerial) {
        this.eeSerial = eeSerial;
    }

    public Date getEeFechaTranscripcion() {
        return eeFechaTranscripcion;
    }

    public void setEeFechaTranscripcion(Date eeFechaTranscripcion) {
        this.eeFechaTranscripcion = eeFechaTranscripcion;
    }

    public String getEeEstudioSolicitado() {
        return eeEstudioSolicitado;
    }

    public void setEeEstudioSolicitado(String eeEstudioSolicitado) {
        this.eeEstudioSolicitado = eeEstudioSolicitado;
    }

    public String getEeResultado() {
        return eeResultado;
    }

    public void setEeResultado(String eeResultado) {
        this.eeResultado = eeResultado;
    }

    public String getEeResponsable() {
        return eeResponsable;
    }

    public void setEeResponsable(String eeResponsable) {
        this.eeResponsable = eeResponsable;
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
        hash += (eeSerial != null ? eeSerial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TExamenEspecial)) {
            return false;
        }
        TExamenEspecial other = (TExamenEspecial) object;
        if ((this.eeSerial == null && other.eeSerial != null) || (this.eeSerial != null && !this.eeSerial.equals(other.eeSerial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.capa.datos.TExamenEspecial[ eeSerial=" + eeSerial + " ]";
    }
    
}
