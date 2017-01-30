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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FREDDY
 */
@Entity
@Table(name = "t_personal", catalog = "db_hospital_dia_v3", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TPersonal.findAll", query = "SELECT t FROM TPersonal t"),
    @NamedQuery(name = "TPersonal.findByPerSerial", query = "SELECT t FROM TPersonal t WHERE t.perSerial = :perSerial"),
    @NamedQuery(name = "TPersonal.findByPerNombres", query = "SELECT t FROM TPersonal t WHERE t.perNombres = :perNombres"),
    @NamedQuery(name = "TPersonal.findByPerApellidos", query = "SELECT t FROM TPersonal t WHERE t.perApellidos = :perApellidos"),
    @NamedQuery(name = "TPersonal.findByPerFechaNacimiento", query = "SELECT t FROM TPersonal t WHERE t.perFechaNacimiento = :perFechaNacimiento"),
    @NamedQuery(name = "TPersonal.findByPerCedula", query = "SELECT t FROM TPersonal t WHERE t.perCedula = :perCedula"),
    @NamedQuery(name = "TPersonal.findByPerDireccion", query = "SELECT t FROM TPersonal t WHERE t.perDireccion = :perDireccion"),
    @NamedQuery(name = "TPersonal.findByPerTelefono", query = "SELECT t FROM TPersonal t WHERE t.perTelefono = :perTelefono"),
    @NamedQuery(name = "TPersonal.findByPerEmail", query = "SELECT t FROM TPersonal t WHERE t.perEmail = :perEmail")})
public class TPersonal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "per_serial", nullable = false)
    private Integer perSerial;
    @Size(max = 150)
    @Column(name = "per_nombres", length = 150)
    private String perNombres;
    @Size(max = 150)
    @Column(name = "per_apellidos", length = 150)
    private String perApellidos;
    @Column(name = "per_fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date perFechaNacimiento;
    @Size(max = 150)
    @Column(name = "per_cedula", length = 150)
    private String perCedula;
    @Size(max = 150)
    @Column(name = "per_direccion", length = 150)
    private String perDireccion;
    @Size(max = 150)
    @Column(name = "per_telefono", length = 150)
    private String perTelefono;
    @Size(max = 150)
    @Column(name = "per_email", length = 150)
    private String perEmail;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tPersonal")
    private TMedico tMedico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perSerial")
    private List<TUsuario> tUsuarioList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tPersonal")
    private TAdmisionista tAdmisionista;

    public TPersonal() {
    }

    public TPersonal(Integer perSerial) {
        this.perSerial = perSerial;
    }

    public Integer getPerSerial() {
        return perSerial;
    }

    public void setPerSerial(Integer perSerial) {
        this.perSerial = perSerial;
    }

    public String getPerNombres() {
        return perNombres;
    }

    public void setPerNombres(String perNombres) {
        this.perNombres = perNombres;
    }

    public String getPerApellidos() {
        return perApellidos;
    }

    public void setPerApellidos(String perApellidos) {
        this.perApellidos = perApellidos;
    }

    public Date getPerFechaNacimiento() {
        return perFechaNacimiento;
    }

    public void setPerFechaNacimiento(Date perFechaNacimiento) {
        this.perFechaNacimiento = perFechaNacimiento;
    }

    public String getPerCedula() {
        return perCedula;
    }

    public void setPerCedula(String perCedula) {
        this.perCedula = perCedula;
    }

    public String getPerDireccion() {
        return perDireccion;
    }

    public void setPerDireccion(String perDireccion) {
        this.perDireccion = perDireccion;
    }

    public String getPerTelefono() {
        return perTelefono;
    }

    public void setPerTelefono(String perTelefono) {
        this.perTelefono = perTelefono;
    }

    public String getPerEmail() {
        return perEmail;
    }

    public void setPerEmail(String perEmail) {
        this.perEmail = perEmail;
    }

    public TMedico getTMedico() {
        return tMedico;
    }

    public void setTMedico(TMedico tMedico) {
        this.tMedico = tMedico;
    }

    @XmlTransient
    public List<TUsuario> getTUsuarioList() {
        return tUsuarioList;
    }

    public void setTUsuarioList(List<TUsuario> tUsuarioList) {
        this.tUsuarioList = tUsuarioList;
    }

    public TAdmisionista getTAdmisionista() {
        return tAdmisionista;
    }

    public void setTAdmisionista(TAdmisionista tAdmisionista) {
        this.tAdmisionista = tAdmisionista;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perSerial != null ? perSerial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TPersonal)) {
            return false;
        }
        TPersonal other = (TPersonal) object;
        if ((this.perSerial == null && other.perSerial != null) || (this.perSerial != null && !this.perSerial.equals(other.perSerial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.capa.datos.TPersonal[ perSerial=" + perSerial + " ]";
    }
    
}
