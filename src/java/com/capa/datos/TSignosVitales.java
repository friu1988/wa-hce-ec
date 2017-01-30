/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capa.datos;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "t_signos_vitales", catalog = "db_hospital_dia_v3", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TSignosVitales.findAll", query = "SELECT t FROM TSignosVitales t"),
    @NamedQuery(name = "TSignosVitales.findBySvSerial", query = "SELECT t FROM TSignosVitales t WHERE t.svSerial = :svSerial"),
    @NamedQuery(name = "TSignosVitales.findBySvFechaMedicion", query = "SELECT t FROM TSignosVitales t WHERE t.svFechaMedicion = :svFechaMedicion"),
    @NamedQuery(name = "TSignosVitales.findBySvTemperatura", query = "SELECT t FROM TSignosVitales t WHERE t.svTemperatura = :svTemperatura"),
    @NamedQuery(name = "TSignosVitales.findBySvPresionArterial", query = "SELECT t FROM TSignosVitales t WHERE t.svPresionArterial = :svPresionArterial"),
    @NamedQuery(name = "TSignosVitales.findBySvPulsoFrecuenciaRespiratoria", query = "SELECT t FROM TSignosVitales t WHERE t.svPulsoFrecuenciaRespiratoria = :svPulsoFrecuenciaRespiratoria"),
    @NamedQuery(name = "TSignosVitales.findBySvPesoKg", query = "SELECT t FROM TSignosVitales t WHERE t.svPesoKg = :svPesoKg"),
    @NamedQuery(name = "TSignosVitales.findBySvTallaCm", query = "SELECT t FROM TSignosVitales t WHERE t.svTallaCm = :svTallaCm"),
    @NamedQuery(name = "TSignosVitales.findBySvIndiceMasaCorporal", query = "SELECT t FROM TSignosVitales t WHERE t.svIndiceMasaCorporal = :svIndiceMasaCorporal")})
public class TSignosVitales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sv_serial", nullable = false)
    private Integer svSerial;
    @Column(name = "sv_fecha_medicion")
    @Temporal(TemporalType.DATE)
    private Date svFechaMedicion;
    @Size(max = 10)
    @Column(name = "sv_temperatura", length = 10)
    private String svTemperatura;
    @Size(max = 10)
    @Column(name = "sv_presion_arterial", length = 10)
    private String svPresionArterial;
    @Size(max = 10)
    @Column(name = "sv_pulso_frecuencia_respiratoria", length = 10)
    private String svPulsoFrecuenciaRespiratoria;
    @Size(max = 10)
    @Column(name = "sv_peso_kg", length = 10)
    private String svPesoKg;
    @Size(max = 10)
    @Column(name = "sv_talla_cm", length = 10)
    private String svTallaCm;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "sv_indice_masa_corporal", precision = 4, scale = 2)
    private BigDecimal svIndiceMasaCorporal;
    @JoinColumn(name = "cex_serial", referencedColumnName = "cex_serial", nullable = false)
    @ManyToOne(optional = false)
    private TConsultaExterna cexSerial;

    public TSignosVitales() {
    }

    public TSignosVitales(Integer svSerial) {
        this.svSerial = svSerial;
    }

    public Integer getSvSerial() {
        return svSerial;
    }

    public void setSvSerial(Integer svSerial) {
        this.svSerial = svSerial;
    }

    public Date getSvFechaMedicion() {
        return svFechaMedicion;
    }

    public void setSvFechaMedicion(Date svFechaMedicion) {
        this.svFechaMedicion = svFechaMedicion;
    }

    public String getSvTemperatura() {
        return svTemperatura;
    }

    public void setSvTemperatura(String svTemperatura) {
        this.svTemperatura = svTemperatura;
    }

    public String getSvPresionArterial() {
        return svPresionArterial;
    }

    public void setSvPresionArterial(String svPresionArterial) {
        this.svPresionArterial = svPresionArterial;
    }

    public String getSvPulsoFrecuenciaRespiratoria() {
        return svPulsoFrecuenciaRespiratoria;
    }

    public void setSvPulsoFrecuenciaRespiratoria(String svPulsoFrecuenciaRespiratoria) {
        this.svPulsoFrecuenciaRespiratoria = svPulsoFrecuenciaRespiratoria;
    }

    public String getSvPesoKg() {
        return svPesoKg;
    }

    public void setSvPesoKg(String svPesoKg) {
        this.svPesoKg = svPesoKg;
    }

    public String getSvTallaCm() {
        return svTallaCm;
    }

    public void setSvTallaCm(String svTallaCm) {
        this.svTallaCm = svTallaCm;
    }

    public BigDecimal getSvIndiceMasaCorporal() {
        return svIndiceMasaCorporal;
    }

    public void setSvIndiceMasaCorporal(BigDecimal svIndiceMasaCorporal) {
        this.svIndiceMasaCorporal = svIndiceMasaCorporal;
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
        hash += (svSerial != null ? svSerial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TSignosVitales)) {
            return false;
        }
        TSignosVitales other = (TSignosVitales) object;
        if ((this.svSerial == null && other.svSerial != null) || (this.svSerial != null && !this.svSerial.equals(other.svSerial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.capa.datos.TSignosVitales[ svSerial=" + svSerial + " ]";
    }
    
}
