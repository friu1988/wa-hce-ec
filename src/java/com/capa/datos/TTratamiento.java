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
@Table(name = "t_tratamiento", catalog = "db_hospital_dia_v3", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TTratamiento.findAll", query = "SELECT t FROM TTratamiento t"),
    @NamedQuery(name = "TTratamiento.findByTratSerial", query = "SELECT t FROM TTratamiento t WHERE t.tratSerial = :tratSerial"),
    @NamedQuery(name = "TTratamiento.findByTratDetalle", query = "SELECT t FROM TTratamiento t WHERE t.tratDetalle = :tratDetalle"),
    @NamedQuery(name = "TTratamiento.findByTratReferencia", query = "SELECT t FROM TTratamiento t WHERE t.tratReferencia = :tratReferencia"),
    @NamedQuery(name = "TTratamiento.findByTratInterconsulta", query = "SELECT t FROM TTratamiento t WHERE t.tratInterconsulta = :tratInterconsulta")})
public class TTratamiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "trat_serial", nullable = false)
    private Integer tratSerial;
    @Size(max = 250)
    @Column(name = "trat_detalle", length = 250)
    private String tratDetalle;
    @Column(name = "trat_referencia")
    private Boolean tratReferencia;
    @Column(name = "trat_interconsulta")
    private Boolean tratInterconsulta;
    @JoinColumn(name = "diag_serial", referencedColumnName = "diag_serial", nullable = false)
    @ManyToOne(optional = false)
    private TDiagnostico diagSerial;

    public TTratamiento() {
    }

    public TTratamiento(Integer tratSerial) {
        this.tratSerial = tratSerial;
    }

    public Integer getTratSerial() {
        return tratSerial;
    }

    public void setTratSerial(Integer tratSerial) {
        this.tratSerial = tratSerial;
    }

    public String getTratDetalle() {
        return tratDetalle;
    }

    public void setTratDetalle(String tratDetalle) {
        this.tratDetalle = tratDetalle;
    }

    public Boolean getTratReferencia() {
        return tratReferencia;
    }

    public void setTratReferencia(Boolean tratReferencia) {
        this.tratReferencia = tratReferencia;
    }

    public Boolean getTratInterconsulta() {
        return tratInterconsulta;
    }

    public void setTratInterconsulta(Boolean tratInterconsulta) {
        this.tratInterconsulta = tratInterconsulta;
    }

    public TDiagnostico getDiagSerial() {
        return diagSerial;
    }

    public void setDiagSerial(TDiagnostico diagSerial) {
        this.diagSerial = diagSerial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tratSerial != null ? tratSerial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TTratamiento)) {
            return false;
        }
        TTratamiento other = (TTratamiento) object;
        if ((this.tratSerial == null && other.tratSerial != null) || (this.tratSerial != null && !this.tratSerial.equals(other.tratSerial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.capa.datos.TTratamiento[ tratSerial=" + tratSerial + " ]";
    }
    
}
