/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capa.datos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FREDDY
 */
@Entity
@Table(name = "t_tipo_usuario", catalog = "db_hospital_dia_v3", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TTipoUsuario.findAll", query = "SELECT t FROM TTipoUsuario t"),
    @NamedQuery(name = "TTipoUsuario.findByTuSerial", query = "SELECT t FROM TTipoUsuario t WHERE t.tuSerial = :tuSerial"),
    @NamedQuery(name = "TTipoUsuario.findByTuDescripcion", query = "SELECT t FROM TTipoUsuario t WHERE t.tuDescripcion = :tuDescripcion")})
public class TTipoUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "tu_serial", nullable = false, length = 2)
    private String tuSerial;
    @Size(max = 20)
    @Column(name = "tu_descripcion", length = 20)
    private String tuDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tuSerial")
    private List<TUsuario> tUsuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tTipoUsuario")
    private List<TAcceso> tAccesoList;

    public TTipoUsuario() {
    }

    public TTipoUsuario(String tuSerial) {
        this.tuSerial = tuSerial;
    }

    public String getTuSerial() {
        return tuSerial;
    }

    public void setTuSerial(String tuSerial) {
        this.tuSerial = tuSerial;
    }

    public String getTuDescripcion() {
        return tuDescripcion;
    }

    public void setTuDescripcion(String tuDescripcion) {
        this.tuDescripcion = tuDescripcion;
    }

    @XmlTransient
    public List<TUsuario> getTUsuarioList() {
        return tUsuarioList;
    }

    public void setTUsuarioList(List<TUsuario> tUsuarioList) {
        this.tUsuarioList = tUsuarioList;
    }

    @XmlTransient
    public List<TAcceso> getTAccesoList() {
        return tAccesoList;
    }

    public void setTAccesoList(List<TAcceso> tAccesoList) {
        this.tAccesoList = tAccesoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tuSerial != null ? tuSerial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TTipoUsuario)) {
            return false;
        }
        TTipoUsuario other = (TTipoUsuario) object;
        if ((this.tuSerial == null && other.tuSerial != null) || (this.tuSerial != null && !this.tuSerial.equals(other.tuSerial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.capa.datos.TTipoUsuario[ tuSerial=" + tuSerial + " ]";
    }
    
}
