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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FREDDY
 */
@Entity
@Table(name = "t_kardex", catalog = "db_hospital_dia_v3", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TKardex.findAll", query = "SELECT t FROM TKardex t"),
    @NamedQuery(name = "TKardex.findByKarSerial", query = "SELECT t FROM TKardex t WHERE t.karSerial = :karSerial"),
    @NamedQuery(name = "TKardex.findByKarFecha", query = "SELECT t FROM TKardex t WHERE t.karFecha = :karFecha")})
public class TKardex implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "kar_serial", nullable = false)
    private Integer karSerial;
    @Column(name = "kar_fecha")
    @Temporal(TemporalType.DATE)
    private Date karFecha;
    @JoinColumn(name = "hcl_serial", referencedColumnName = "hcl_serial", nullable = false)
    @ManyToOne(optional = false)
    private THistoriaClinicaUnica hclSerial;

    public TKardex() {
    }

    public TKardex(Integer karSerial) {
        this.karSerial = karSerial;
    }

    public Integer getKarSerial() {
        return karSerial;
    }

    public void setKarSerial(Integer karSerial) {
        this.karSerial = karSerial;
    }

    public Date getKarFecha() {
        return karFecha;
    }

    public void setKarFecha(Date karFecha) {
        this.karFecha = karFecha;
    }

    public THistoriaClinicaUnica getHclSerial() {
        return hclSerial;
    }

    public void setHclSerial(THistoriaClinicaUnica hclSerial) {
        this.hclSerial = hclSerial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (karSerial != null ? karSerial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TKardex)) {
            return false;
        }
        TKardex other = (TKardex) object;
        if ((this.karSerial == null && other.karSerial != null) || (this.karSerial != null && !this.karSerial.equals(other.karSerial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.capa.datos.TKardex[ karSerial=" + karSerial + " ]";
    }
    
}
