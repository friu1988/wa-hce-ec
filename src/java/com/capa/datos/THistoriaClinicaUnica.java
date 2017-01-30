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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FREDDY
 */
@Entity
@Table(name = "t_historia_clinica_unica", catalog = "db_hospital_dia_v3", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "THistoriaClinicaUnica.findAll", query = "SELECT t FROM THistoriaClinicaUnica t"),
    @NamedQuery(name = "THistoriaClinicaUnica.findByHclSerial", query = "SELECT t FROM THistoriaClinicaUnica t WHERE t.hclSerial = :hclSerial"),
    @NamedQuery(name = "THistoriaClinicaUnica.findByHclInstitucion", query = "SELECT t FROM THistoriaClinicaUnica t WHERE t.hclInstitucion = :hclInstitucion"),
    @NamedQuery(name = "THistoriaClinicaUnica.findByHclUnidadOperativa", query = "SELECT t FROM THistoriaClinicaUnica t WHERE t.hclUnidadOperativa = :hclUnidadOperativa"),
    @NamedQuery(name = "THistoriaClinicaUnica.findByHclCodigoOu", query = "SELECT t FROM THistoriaClinicaUnica t WHERE t.hclCodigoOu = :hclCodigoOu"),
    @NamedQuery(name = "THistoriaClinicaUnica.findByHclTipoPaciente", query = "SELECT t FROM THistoriaClinicaUnica t WHERE t.hclTipoPaciente = :hclTipoPaciente"),
    @NamedQuery(name = "THistoriaClinicaUnica.findByHclNumeroHistoria", query = "SELECT t FROM THistoriaClinicaUnica t WHERE t.hclNumeroHistoria = :hclNumeroHistoria"),
    @NamedQuery(name = "THistoriaClinicaUnica.findByHclFechaAdmision", query = "SELECT t FROM THistoriaClinicaUnica t WHERE t.hclFechaAdmision = :hclFechaAdmision"),
    @NamedQuery(name = "THistoriaClinicaUnica.findByHclEstado", query = "SELECT t FROM THistoriaClinicaUnica t WHERE t.hclEstado = :hclEstado")})
public class THistoriaClinicaUnica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "hcl_serial", nullable = false, length = 10)
    private String hclSerial;
    @Size(max = 10)
    @Column(name = "hcl_institucion", length = 10)
    private String hclInstitucion;
    @Size(max = 10)
    @Column(name = "hcl_unidad_operativa", length = 10)
    private String hclUnidadOperativa;
    @Size(max = 10)
    @Column(name = "hcl_codigo_ou", length = 10)
    private String hclCodigoOu;
    @Size(max = 2)
    @Column(name = "hcl_tipo_paciente", length = 2)
    private String hclTipoPaciente;
    @Size(max = 10)
    @Column(name = "hcl_numero_historia", length = 10)
    private String hclNumeroHistoria;
    @Column(name = "hcl_fecha_admision")
    @Temporal(TemporalType.DATE)
    private Date hclFechaAdmision;
    @Column(name = "hcl_estado")
    private Integer hclEstado;
    @JoinColumn(name = "pac_cedula", referencedColumnName = "pac_cedula", nullable = false)
    @ManyToOne(optional = false)
    private TPaciente pacCedula;
    @JoinColumn(name = "per_serial", referencedColumnName = "per_serial", nullable = false)
    @ManyToOne(optional = false)
    private TAdmisionista perSerial;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hclSerial")
    private List<TTurno> tTurnoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hclSerial")
    private List<TKardex> tKardexList;

    public THistoriaClinicaUnica() {
    }

    public THistoriaClinicaUnica(String hclSerial) {
        this.hclSerial = hclSerial;
    }

    public String getHclSerial() {
        return hclSerial;
    }

    public void setHclSerial(String hclSerial) {
        this.hclSerial = hclSerial;
    }

    public String getHclInstitucion() {
        return hclInstitucion;
    }

    public void setHclInstitucion(String hclInstitucion) {
        this.hclInstitucion = hclInstitucion;
    }

    public String getHclUnidadOperativa() {
        return hclUnidadOperativa;
    }

    public void setHclUnidadOperativa(String hclUnidadOperativa) {
        this.hclUnidadOperativa = hclUnidadOperativa;
    }

    public String getHclCodigoOu() {
        return hclCodigoOu;
    }

    public void setHclCodigoOu(String hclCodigoOu) {
        this.hclCodigoOu = hclCodigoOu;
    }

    public String getHclTipoPaciente() {
        return hclTipoPaciente;
    }

    public void setHclTipoPaciente(String hclTipoPaciente) {
        this.hclTipoPaciente = hclTipoPaciente;
    }

    public String getHclNumeroHistoria() {
        return hclNumeroHistoria;
    }

    public void setHclNumeroHistoria(String hclNumeroHistoria) {
        this.hclNumeroHistoria = hclNumeroHistoria;
    }

    public Date getHclFechaAdmision() {
        return hclFechaAdmision;
    }

    public void setHclFechaAdmision(Date hclFechaAdmision) {
        this.hclFechaAdmision = hclFechaAdmision;
    }

    public Integer getHclEstado() {
        return hclEstado;
    }

    public void setHclEstado(Integer hclEstado) {
        this.hclEstado = hclEstado;
    }

    public TPaciente getPacCedula() {
        return pacCedula;
    }

    public void setPacCedula(TPaciente pacCedula) {
        this.pacCedula = pacCedula;
    }

    public TAdmisionista getPerSerial() {
        return perSerial;
    }

    public void setPerSerial(TAdmisionista perSerial) {
        this.perSerial = perSerial;
    }

    @XmlTransient
    public List<TTurno> getTTurnoList() {
        return tTurnoList;
    }

    public void setTTurnoList(List<TTurno> tTurnoList) {
        this.tTurnoList = tTurnoList;
    }

    @XmlTransient
    public List<TKardex> getTKardexList() {
        return tKardexList;
    }

    public void setTKardexList(List<TKardex> tKardexList) {
        this.tKardexList = tKardexList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hclSerial != null ? hclSerial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof THistoriaClinicaUnica)) {
            return false;
        }
        THistoriaClinicaUnica other = (THistoriaClinicaUnica) object;
        if ((this.hclSerial == null && other.hclSerial != null) || (this.hclSerial != null && !this.hclSerial.equals(other.hclSerial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.capa.datos.THistoriaClinicaUnica[ hclSerial=" + hclSerial + " ]";
    }
    
}
