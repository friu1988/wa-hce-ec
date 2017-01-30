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
@Table(name = "t_usuario", catalog = "db_hospital_dia_v3", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TUsuario.findAll", query = "SELECT t FROM TUsuario t"),
    @NamedQuery(name = "TUsuario.findByUSerial", query = "SELECT t FROM TUsuario t WHERE t.uSerial = :uSerial"),
    @NamedQuery(name = "TUsuario.findByUNick", query = "SELECT t FROM TUsuario t WHERE t.uNick = :uNick"),
    @NamedQuery(name = "TUsuario.findByUClave", query = "SELECT t FROM TUsuario t WHERE t.uClave = :uClave"),
    @NamedQuery(name = "TUsuario.findByUEstado", query = "SELECT t FROM TUsuario t WHERE t.uEstado = :uEstado")})
public class TUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "u_serial", nullable = false)
    private Integer uSerial;
    @Size(max = 15)
    @Column(name = "u_nick", length = 15)
    private String uNick;
    @Size(max = 32)
    @Column(name = "u_clave", length = 32)
    private String uClave;
    @Column(name = "u_estado")
    private Boolean uEstado;
    @JoinColumn(name = "tu_serial", referencedColumnName = "tu_serial", nullable = false)
    @ManyToOne(optional = false)
    private TTipoUsuario tuSerial;
    @JoinColumn(name = "per_serial", referencedColumnName = "per_serial", nullable = false)
    @ManyToOne(optional = false)
    private TPersonal perSerial;

    public TUsuario() {
    }

    public TUsuario(Integer uSerial) {
        this.uSerial = uSerial;
    }

    public Integer getUSerial() {
        return uSerial;
    }

    public void setUSerial(Integer uSerial) {
        this.uSerial = uSerial;
    }

    public String getUNick() {
        return uNick;
    }

    public void setUNick(String uNick) {
        this.uNick = uNick;
    }

    public String getUClave() {
        return uClave;
    }

    public void setUClave(String uClave) {
        this.uClave = uClave;
    }

    public Boolean getUEstado() {
        return uEstado;
    }

    public void setUEstado(Boolean uEstado) {
        this.uEstado = uEstado;
    }

    public TTipoUsuario getTuSerial() {
        return tuSerial;
    }

    public void setTuSerial(TTipoUsuario tuSerial) {
        this.tuSerial = tuSerial;
    }

    public TPersonal getPerSerial() {
        return perSerial;
    }

    public void setPerSerial(TPersonal perSerial) {
        this.perSerial = perSerial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uSerial != null ? uSerial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TUsuario) {
            TUsuario usuario = (TUsuario) obj;
            if (usuario.getUClave().equals(this.uClave)) {
                return true;
            }
        } else {
            return false;
        }
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "TUsuario{" + "uSerial=" + uSerial + ", uNick=" + uNick + ", uClave=" + uClave + ", uEstado=" + uEstado + ", tuSerial=" + tuSerial + ", perSerial=" + perSerial + '}';
    }

}
