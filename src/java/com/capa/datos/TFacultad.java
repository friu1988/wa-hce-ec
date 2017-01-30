/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capa.datos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "t_facultad", catalog = "db_hospital_dia_v3", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TFacultad.findAll", query = "SELECT t FROM TFacultad t"),
    @NamedQuery(name = "TFacultad.findByFacSerial", query = "SELECT t FROM TFacultad t WHERE t.facSerial = :facSerial"),
    @NamedQuery(name = "TFacultad.findByFacNombre", query = "SELECT t FROM TFacultad t WHERE t.facNombre = :facNombre"),
    @NamedQuery(name = "TFacultad.findByFacUbicacion", query = "SELECT t FROM TFacultad t WHERE t.facUbicacion = :facUbicacion")})
public class TFacultad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "fac_serial", nullable = false, length = 10)
    private String facSerial;
    @Size(max = 100)
    @Column(name = "fac_nombre", length = 100)
    private String facNombre;
    @Size(max = 100)
    @Column(name = "fac_ubicacion", length = 100)
    private String facUbicacion;
    @OneToMany(mappedBy = "facSerial")
    private List<TEstudiante> tEstudianteList;
    @OneToMany(mappedBy = "tFFacSerial")
    private List<TFacultad> tFacultadList;
    @JoinColumn(name = "t_f_fac_serial", referencedColumnName = "fac_serial")
    @ManyToOne
    private TFacultad tFFacSerial;

    public TFacultad() {
    }

    public TFacultad(String facSerial) {
        this.facSerial = facSerial;
    }

    public String getFacSerial() {
        return facSerial;
    }

    public void setFacSerial(String facSerial) {
        this.facSerial = facSerial;
    }

    public String getFacNombre() {
        return facNombre;
    }

    public void setFacNombre(String facNombre) {
        this.facNombre = facNombre;
    }

    public String getFacUbicacion() {
        return facUbicacion;
    }

    public void setFacUbicacion(String facUbicacion) {
        this.facUbicacion = facUbicacion;
    }

    @XmlTransient
    public List<TEstudiante> getTEstudianteList() {
        return tEstudianteList;
    }

    public void setTEstudianteList(List<TEstudiante> tEstudianteList) {
        this.tEstudianteList = tEstudianteList;
    }

    @XmlTransient
    public List<TFacultad> getTFacultadList() {
        return tFacultadList;
    }

    public void setTFacultadList(List<TFacultad> tFacultadList) {
        this.tFacultadList = tFacultadList;
    }

    public TFacultad getTFFacSerial() {
        return tFFacSerial;
    }

    public void setTFFacSerial(TFacultad tFFacSerial) {
        this.tFFacSerial = tFFacSerial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facSerial != null ? facSerial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TFacultad)) {
            return false;
        }
        TFacultad other = (TFacultad) object;
        if ((this.facSerial == null && other.facSerial != null) || (this.facSerial != null && !this.facSerial.equals(other.facSerial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.capa.datos.TFacultad[ facSerial=" + facSerial + " ]";
    }
    
}
