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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FREDDY
 */
@Entity
@Table(name = "t_turno", catalog = "db_hospital_dia_v3", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TTurno.findAll", query = "SELECT t FROM TTurno t"),
    @NamedQuery(name = "TTurno.findByTurSerial", query = "SELECT t FROM TTurno t WHERE t.turSerial = :turSerial"),
    @NamedQuery(name = "TTurno.findByTurFecha", query = "SELECT t FROM TTurno t WHERE t.turFecha = :turFecha"),
    @NamedQuery(name = "TTurno.findByTurHora", query = "SELECT t FROM TTurno t WHERE t.turHora = :turHora"),
    @NamedQuery(name = "TTurno.findByTurEstado", query = "SELECT t FROM TTurno t WHERE t.turEstado = :turEstado")})
public class TTurno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tur_serial", nullable = false)
    private Integer turSerial;
    @Column(name = "tur_fecha")
    @Temporal(TemporalType.DATE)
    private Date turFecha;
    @Column(name = "tur_hora")
    @Temporal(TemporalType.TIME)
    private Date turHora;
    @Column(name = "tur_estado")
    private Boolean turEstado;
    @JoinColumn(name = "hcl_serial", referencedColumnName = "hcl_serial", nullable = false)
    @ManyToOne(optional = false)
    private THistoriaClinicaUnica hclSerial;
    @JoinColumn(name = "t_m_per_serial", referencedColumnName = "per_serial", nullable = false)
    @ManyToOne(optional = false)
    private TMedico tMPerSerial;
    @JoinColumn(name = "per_serial", referencedColumnName = "per_serial", nullable = false)
    @ManyToOne(optional = false)
    private TAdmisionista perSerial;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "turSerial")
    private List<TConsultaExterna> tConsultaExternaList;

    public TTurno() {
    }

    public TTurno(Integer turSerial) {
        this.turSerial = turSerial;
    }

    public Integer getTurSerial() {
        return turSerial;
    }

    public void setTurSerial(Integer turSerial) {
        this.turSerial = turSerial;
    }

    public Date getTurFecha() {
        return turFecha;
    }

    public void setTurFecha(Date turFecha) {
        this.turFecha = turFecha;
    }

    public Date getTurHora() {
        return turHora;
    }

    public void setTurHora(Date turHora) {
        this.turHora = turHora;
    }

    public Boolean getTurEstado() {
        return turEstado;
    }

    public void setTurEstado(Boolean turEstado) {
        this.turEstado = turEstado;
    }

    public THistoriaClinicaUnica getHclSerial() {
        return hclSerial;
    }

    public void setHclSerial(THistoriaClinicaUnica hclSerial) {
        this.hclSerial = hclSerial;
    }

    public TMedico getTMPerSerial() {
        return tMPerSerial;
    }

    public void setTMPerSerial(TMedico tMPerSerial) {
        this.tMPerSerial = tMPerSerial;
    }

    public TAdmisionista getPerSerial() {
        return perSerial;
    }

    public void setPerSerial(TAdmisionista perSerial) {
        this.perSerial = perSerial;
    }

    @XmlTransient
    public List<TConsultaExterna> getTConsultaExternaList() {
        return tConsultaExternaList;
    }

    public void setTConsultaExternaList(List<TConsultaExterna> tConsultaExternaList) {
        this.tConsultaExternaList = tConsultaExternaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (turSerial != null ? turSerial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TTurno)) {
            return false;
        }
        TTurno other = (TTurno) object;
        if ((this.turSerial == null && other.turSerial != null) || (this.turSerial != null && !this.turSerial.equals(other.turSerial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.capa.datos.TTurno[ turSerial=" + turSerial + " ]";
    }
    
}
