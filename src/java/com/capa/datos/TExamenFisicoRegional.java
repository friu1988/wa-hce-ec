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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FREDDY
 */
@Entity
@Table(name = "t_examen_fisico_regional", catalog = "db_hospital_dia_v3", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TExamenFisicoRegional.findAll", query = "SELECT t FROM TExamenFisicoRegional t"),
    @NamedQuery(name = "TExamenFisicoRegional.findByExaSerial", query = "SELECT t FROM TExamenFisicoRegional t WHERE t.exaSerial = :exaSerial"),
    @NamedQuery(name = "TExamenFisicoRegional.findByExaCabeza", query = "SELECT t FROM TExamenFisicoRegional t WHERE t.exaCabeza = :exaCabeza"),
    @NamedQuery(name = "TExamenFisicoRegional.findByExaCuello", query = "SELECT t FROM TExamenFisicoRegional t WHERE t.exaCuello = :exaCuello"),
    @NamedQuery(name = "TExamenFisicoRegional.findByExaTorax", query = "SELECT t FROM TExamenFisicoRegional t WHERE t.exaTorax = :exaTorax"),
    @NamedQuery(name = "TExamenFisicoRegional.findByExaAbdomen", query = "SELECT t FROM TExamenFisicoRegional t WHERE t.exaAbdomen = :exaAbdomen"),
    @NamedQuery(name = "TExamenFisicoRegional.findByExaPelvis", query = "SELECT t FROM TExamenFisicoRegional t WHERE t.exaPelvis = :exaPelvis"),
    @NamedQuery(name = "TExamenFisicoRegional.findByExaExtremidades", query = "SELECT t FROM TExamenFisicoRegional t WHERE t.exaExtremidades = :exaExtremidades"),
    @NamedQuery(name = "TExamenFisicoRegional.findByExaDescripcion", query = "SELECT t FROM TExamenFisicoRegional t WHERE t.exaDescripcion = :exaDescripcion")})
public class TExamenFisicoRegional implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "exa_serial", nullable = false)
    private Integer exaSerial;
    @Column(name = "exa_cabeza")
    private Boolean exaCabeza;
    @Column(name = "exa_cuello")
    private Boolean exaCuello;
    @Column(name = "exa_torax")
    private Boolean exaTorax;
    @Column(name = "exa_abdomen")
    private Boolean exaAbdomen;
    @Column(name = "exa_pelvis")
    private Boolean exaPelvis;
    @Column(name = "exa_extremidades")
    private Boolean exaExtremidades;
    @Size(max = 250)
    @Column(name = "exa_descripcion", length = 250)
    private String exaDescripcion;
    @JoinColumn(name = "cex_serial", referencedColumnName = "cex_serial")
    @ManyToOne
    private TConsultaExterna cexSerial;

    public TExamenFisicoRegional() {
    }

    public TExamenFisicoRegional(Integer exaSerial) {
        this.exaSerial = exaSerial;
    }

    public Integer getExaSerial() {
        return exaSerial;
    }

    public void setExaSerial(Integer exaSerial) {
        this.exaSerial = exaSerial;
    }

    public Boolean getExaCabeza() {
        return exaCabeza;
    }

    public void setExaCabeza(Boolean exaCabeza) {
        this.exaCabeza = exaCabeza;
    }

    public Boolean getExaCuello() {
        return exaCuello;
    }

    public void setExaCuello(Boolean exaCuello) {
        this.exaCuello = exaCuello;
    }

    public Boolean getExaTorax() {
        return exaTorax;
    }

    public void setExaTorax(Boolean exaTorax) {
        this.exaTorax = exaTorax;
    }

    public Boolean getExaAbdomen() {
        return exaAbdomen;
    }

    public void setExaAbdomen(Boolean exaAbdomen) {
        this.exaAbdomen = exaAbdomen;
    }

    public Boolean getExaPelvis() {
        return exaPelvis;
    }

    public void setExaPelvis(Boolean exaPelvis) {
        this.exaPelvis = exaPelvis;
    }

    public Boolean getExaExtremidades() {
        return exaExtremidades;
    }

    public void setExaExtremidades(Boolean exaExtremidades) {
        this.exaExtremidades = exaExtremidades;
    }

    public String getExaDescripcion() {
        return exaDescripcion;
    }

    public void setExaDescripcion(String exaDescripcion) {
        this.exaDescripcion = exaDescripcion;
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
        hash += (exaSerial != null ? exaSerial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TExamenFisicoRegional)) {
            return false;
        }
        TExamenFisicoRegional other = (TExamenFisicoRegional) object;
        if ((this.exaSerial == null && other.exaSerial != null) || (this.exaSerial != null && !this.exaSerial.equals(other.exaSerial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.capa.datos.TExamenFisicoRegional[ exaSerial=" + exaSerial + " ]";
    }
    
}
