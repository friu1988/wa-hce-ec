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
@Table(name = "t_evolucion_prescripcion", catalog = "db_hospital_dia_v3", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TEvolucionPrescripcion.findAll", query = "SELECT t FROM TEvolucionPrescripcion t"),
    @NamedQuery(name = "TEvolucionPrescripcion.findByTepSerial", query = "SELECT t FROM TEvolucionPrescripcion t WHERE t.tepSerial = :tepSerial"),
    @NamedQuery(name = "TEvolucionPrescripcion.findByTepFecha", query = "SELECT t FROM TEvolucionPrescripcion t WHERE t.tepFecha = :tepFecha"),
    @NamedQuery(name = "TEvolucionPrescripcion.findByTepNotaEvolucion", query = "SELECT t FROM TEvolucionPrescripcion t WHERE t.tepNotaEvolucion = :tepNotaEvolucion"),
    @NamedQuery(name = "TEvolucionPrescripcion.findByTepFarmacoterapia", query = "SELECT t FROM TEvolucionPrescripcion t WHERE t.tepFarmacoterapia = :tepFarmacoterapia"),
    @NamedQuery(name = "TEvolucionPrescripcion.findByTepIndicaciones", query = "SELECT t FROM TEvolucionPrescripcion t WHERE t.tepIndicaciones = :tepIndicaciones")})
public class TEvolucionPrescripcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tep_serial", nullable = false)
    private Integer tepSerial;
    @Column(name = "tep_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tepFecha;
    @Size(max = 200)
    @Column(name = "tep_nota_evolucion", length = 200)
    private String tepNotaEvolucion;
    @Size(max = 200)
    @Column(name = "tep_farmacoterapia", length = 200)
    private String tepFarmacoterapia;
    @Size(max = 200)
    @Column(name = "tep_indicaciones", length = 200)
    private String tepIndicaciones;
    @JoinColumn(name = "cex_serial", referencedColumnName = "cex_serial", nullable = false)
    @ManyToOne(optional = false)
    private TConsultaExterna cexSerial;

    public TEvolucionPrescripcion() {
    }

    public TEvolucionPrescripcion(Integer tepSerial) {
        this.tepSerial = tepSerial;
    }

    public Integer getTepSerial() {
        return tepSerial;
    }

    public void setTepSerial(Integer tepSerial) {
        this.tepSerial = tepSerial;
    }

    public Date getTepFecha() {
        return tepFecha;
    }

    public void setTepFecha(Date tepFecha) {
        this.tepFecha = tepFecha;
    }

    public String getTepNotaEvolucion() {
        return tepNotaEvolucion;
    }

    public void setTepNotaEvolucion(String tepNotaEvolucion) {
        this.tepNotaEvolucion = tepNotaEvolucion;
    }

    public String getTepFarmacoterapia() {
        return tepFarmacoterapia;
    }

    public void setTepFarmacoterapia(String tepFarmacoterapia) {
        this.tepFarmacoterapia = tepFarmacoterapia;
    }

    public String getTepIndicaciones() {
        return tepIndicaciones;
    }

    public void setTepIndicaciones(String tepIndicaciones) {
        this.tepIndicaciones = tepIndicaciones;
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
        hash += (tepSerial != null ? tepSerial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TEvolucionPrescripcion)) {
            return false;
        }
        TEvolucionPrescripcion other = (TEvolucionPrescripcion) object;
        if ((this.tepSerial == null && other.tepSerial != null) || (this.tepSerial != null && !this.tepSerial.equals(other.tepSerial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.capa.datos.TEvolucionPrescripcion[ tepSerial=" + tepSerial + " ]";
    }
    
}
