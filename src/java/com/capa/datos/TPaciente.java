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
@Table(name = "t_paciente", catalog = "db_hospital_dia_v3", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TPaciente.findAll", query = "SELECT t FROM TPaciente t"),
    @NamedQuery(name = "TPaciente.findByPacCedula", query = "SELECT t FROM TPaciente t WHERE t.pacCedula = :pacCedula"),
    @NamedQuery(name = "TPaciente.findByPacApellidoPaterno", query = "SELECT t FROM TPaciente t WHERE t.pacApellidoPaterno = :pacApellidoPaterno"),
    @NamedQuery(name = "TPaciente.findByPacApellidoMaterno", query = "SELECT t FROM TPaciente t WHERE t.pacApellidoMaterno = :pacApellidoMaterno"),
    @NamedQuery(name = "TPaciente.findByPacPrimerNombre", query = "SELECT t FROM TPaciente t WHERE t.pacPrimerNombre = :pacPrimerNombre"),
    @NamedQuery(name = "TPaciente.findByPacSegundoNombre", query = "SELECT t FROM TPaciente t WHERE t.pacSegundoNombre = :pacSegundoNombre"),
    @NamedQuery(name = "TPaciente.findByPacDireccionResidencial", query = "SELECT t FROM TPaciente t WHERE t.pacDireccionResidencial = :pacDireccionResidencial"),
    @NamedQuery(name = "TPaciente.findByPacTelefono", query = "SELECT t FROM TPaciente t WHERE t.pacTelefono = :pacTelefono"),
    @NamedQuery(name = "TPaciente.findByPacFechaNacimiento", query = "SELECT t FROM TPaciente t WHERE t.pacFechaNacimiento = :pacFechaNacimiento"),
    @NamedQuery(name = "TPaciente.findByPacLugarNacimiento", query = "SELECT t FROM TPaciente t WHERE t.pacLugarNacimiento = :pacLugarNacimiento"),
    @NamedQuery(name = "TPaciente.findByPacNacionalidad", query = "SELECT t FROM TPaciente t WHERE t.pacNacionalidad = :pacNacionalidad"),
    @NamedQuery(name = "TPaciente.findByPacGrupoCultural", query = "SELECT t FROM TPaciente t WHERE t.pacGrupoCultural = :pacGrupoCultural"),
    @NamedQuery(name = "TPaciente.findByPacSexo", query = "SELECT t FROM TPaciente t WHERE t.pacSexo = :pacSexo"),
    @NamedQuery(name = "TPaciente.findByPacEstadoCivil", query = "SELECT t FROM TPaciente t WHERE t.pacEstadoCivil = :pacEstadoCivil"),
    @NamedQuery(name = "TPaciente.findByPacInstruccion", query = "SELECT t FROM TPaciente t WHERE t.pacInstruccion = :pacInstruccion"),
    @NamedQuery(name = "TPaciente.findByPacOcupacion", query = "SELECT t FROM TPaciente t WHERE t.pacOcupacion = :pacOcupacion"),
    @NamedQuery(name = "TPaciente.findByPacEmpresaLabora", query = "SELECT t FROM TPaciente t WHERE t.pacEmpresaLabora = :pacEmpresaLabora"),
    @NamedQuery(name = "TPaciente.findByPacSeguroSalud", query = "SELECT t FROM TPaciente t WHERE t.pacSeguroSalud = :pacSeguroSalud"),
    @NamedQuery(name = "TPaciente.findByPacReferidoDe", query = "SELECT t FROM TPaciente t WHERE t.pacReferidoDe = :pacReferidoDe"),
    @NamedQuery(name = "TPaciente.findByPacFamiliar", query = "SELECT t FROM TPaciente t WHERE t.pacFamiliar = :pacFamiliar"),
    @NamedQuery(name = "TPaciente.findByPacParentesco", query = "SELECT t FROM TPaciente t WHERE t.pacParentesco = :pacParentesco"),
    @NamedQuery(name = "TPaciente.findByPacDireccion", query = "SELECT t FROM TPaciente t WHERE t.pacDireccion = :pacDireccion"),
    @NamedQuery(name = "TPaciente.findByPacTelefonoFamiliar", query = "SELECT t FROM TPaciente t WHERE t.pacTelefonoFamiliar = :pacTelefonoFamiliar")})
public class TPaciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "pac_cedula", nullable = false, length = 10)
    private String pacCedula;
    @Size(max = 100)
    @Column(name = "pac_apellido_paterno", length = 100)
    private String pacApellidoPaterno;
    @Size(max = 100)
    @Column(name = "pac_apellido_materno", length = 100)
    private String pacApellidoMaterno;
    @Size(max = 100)
    @Column(name = "pac_primer_nombre", length = 100)
    private String pacPrimerNombre;
    @Size(max = 100)
    @Column(name = "pac_segundo_nombre", length = 100)
    private String pacSegundoNombre;
    @Size(max = 300)
    @Column(name = "pac_direccion_residencial", length = 300)
    private String pacDireccionResidencial;
    @Size(max = 300)
    @Column(name = "pac_telefono", length = 300)
    private String pacTelefono;
    @Column(name = "pac_fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date pacFechaNacimiento;
    @Size(max = 300)
    @Column(name = "pac_lugar_nacimiento", length = 300)
    private String pacLugarNacimiento;
    @Size(max = 300)
    @Column(name = "pac_nacionalidad", length = 300)
    private String pacNacionalidad;
    @Size(max = 300)
    @Column(name = "pac_grupo_cultural", length = 300)
    private String pacGrupoCultural;
    @Size(max = 2)
    @Column(name = "pac_sexo", length = 2)
    private String pacSexo;
    @Size(max = 300)
    @Column(name = "pac_estado_civil", length = 300)
    private String pacEstadoCivil;
    @Size(max = 300)
    @Column(name = "pac_instruccion", length = 300)
    private String pacInstruccion;
    @Size(max = 300)
    @Column(name = "pac_ocupacion", length = 300)
    private String pacOcupacion;
    @Size(max = 300)
    @Column(name = "pac_empresa_labora", length = 300)
    private String pacEmpresaLabora;
    @Size(max = 300)
    @Column(name = "pac_seguro_salud", length = 300)
    private String pacSeguroSalud;
    @Size(max = 300)
    @Column(name = "pac_referido_de", length = 300)
    private String pacReferidoDe;
    @Size(max = 300)
    @Column(name = "pac_familiar", length = 300)
    private String pacFamiliar;
    @Size(max = 300)
    @Column(name = "pac_parentesco", length = 300)
    private String pacParentesco;
    @Size(max = 300)
    @Column(name = "pac_direccion", length = 300)
    private String pacDireccion;
    @Size(max = 10)
    @Column(name = "pac_telefono_familiar", length = 10)
    private String pacTelefonoFamiliar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacCedula")
    private List<THistoriaClinicaUnica> tHistoriaClinicaUnicaList;
    @JoinColumn(name = "lg_codigo", referencedColumnName = "lg_codigo", nullable = false)
    @ManyToOne(optional = false)
    private TLugarGeografico lgCodigo;

    public TPaciente() {
    }

    public TPaciente(String pacCedula) {
        this.pacCedula = pacCedula;
    }

    public String getPacCedula() {
        return pacCedula;
    }

    public void setPacCedula(String pacCedula) {
        this.pacCedula = pacCedula;
    }

    public String getPacApellidoPaterno() {
        return pacApellidoPaterno;
    }

    public void setPacApellidoPaterno(String pacApellidoPaterno) {
        this.pacApellidoPaterno = pacApellidoPaterno;
    }

    public String getPacApellidoMaterno() {
        return pacApellidoMaterno;
    }

    public void setPacApellidoMaterno(String pacApellidoMaterno) {
        this.pacApellidoMaterno = pacApellidoMaterno;
    }

    public String getPacPrimerNombre() {
        return pacPrimerNombre;
    }

    public void setPacPrimerNombre(String pacPrimerNombre) {
        this.pacPrimerNombre = pacPrimerNombre;
    }

    public String getPacSegundoNombre() {
        return pacSegundoNombre;
    }

    public void setPacSegundoNombre(String pacSegundoNombre) {
        this.pacSegundoNombre = pacSegundoNombre;
    }

    public String getPacDireccionResidencial() {
        return pacDireccionResidencial;
    }

    public void setPacDireccionResidencial(String pacDireccionResidencial) {
        this.pacDireccionResidencial = pacDireccionResidencial;
    }

    public String getPacTelefono() {
        return pacTelefono;
    }

    public void setPacTelefono(String pacTelefono) {
        this.pacTelefono = pacTelefono;
    }

    public Date getPacFechaNacimiento() {
        return pacFechaNacimiento;
    }

    public void setPacFechaNacimiento(Date pacFechaNacimiento) {
        this.pacFechaNacimiento = pacFechaNacimiento;
    }

    public String getPacLugarNacimiento() {
        return pacLugarNacimiento;
    }

    public void setPacLugarNacimiento(String pacLugarNacimiento) {
        this.pacLugarNacimiento = pacLugarNacimiento;
    }

    public String getPacNacionalidad() {
        return pacNacionalidad;
    }

    public void setPacNacionalidad(String pacNacionalidad) {
        this.pacNacionalidad = pacNacionalidad;
    }

    public String getPacGrupoCultural() {
        return pacGrupoCultural;
    }

    public void setPacGrupoCultural(String pacGrupoCultural) {
        this.pacGrupoCultural = pacGrupoCultural;
    }

    public String getPacSexo() {
        return pacSexo;
    }

    public void setPacSexo(String pacSexo) {
        this.pacSexo = pacSexo;
    }

    public String getPacEstadoCivil() {
        return pacEstadoCivil;
    }

    public void setPacEstadoCivil(String pacEstadoCivil) {
        this.pacEstadoCivil = pacEstadoCivil;
    }

    public String getPacInstruccion() {
        return pacInstruccion;
    }

    public void setPacInstruccion(String pacInstruccion) {
        this.pacInstruccion = pacInstruccion;
    }

    public String getPacOcupacion() {
        return pacOcupacion;
    }

    public void setPacOcupacion(String pacOcupacion) {
        this.pacOcupacion = pacOcupacion;
    }

    public String getPacEmpresaLabora() {
        return pacEmpresaLabora;
    }

    public void setPacEmpresaLabora(String pacEmpresaLabora) {
        this.pacEmpresaLabora = pacEmpresaLabora;
    }

    public String getPacSeguroSalud() {
        return pacSeguroSalud;
    }

    public void setPacSeguroSalud(String pacSeguroSalud) {
        this.pacSeguroSalud = pacSeguroSalud;
    }

    public String getPacReferidoDe() {
        return pacReferidoDe;
    }

    public void setPacReferidoDe(String pacReferidoDe) {
        this.pacReferidoDe = pacReferidoDe;
    }

    public String getPacFamiliar() {
        return pacFamiliar;
    }

    public void setPacFamiliar(String pacFamiliar) {
        this.pacFamiliar = pacFamiliar;
    }

    public String getPacParentesco() {
        return pacParentesco;
    }

    public void setPacParentesco(String pacParentesco) {
        this.pacParentesco = pacParentesco;
    }

    public String getPacDireccion() {
        return pacDireccion;
    }

    public void setPacDireccion(String pacDireccion) {
        this.pacDireccion = pacDireccion;
    }

    public String getPacTelefonoFamiliar() {
        return pacTelefonoFamiliar;
    }

    public void setPacTelefonoFamiliar(String pacTelefonoFamiliar) {
        this.pacTelefonoFamiliar = pacTelefonoFamiliar;
    }

    @XmlTransient
    public List<THistoriaClinicaUnica> getTHistoriaClinicaUnicaList() {
        return tHistoriaClinicaUnicaList;
    }

    public void setTHistoriaClinicaUnicaList(List<THistoriaClinicaUnica> tHistoriaClinicaUnicaList) {
        this.tHistoriaClinicaUnicaList = tHistoriaClinicaUnicaList;
    }

    public TLugarGeografico getLgCodigo() {
        return lgCodigo;
    }

    public void setLgCodigo(TLugarGeografico lgCodigo) {
        this.lgCodigo = lgCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pacCedula != null ? pacCedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TPaciente)) {
            return false;
        }
        TPaciente other = (TPaciente) object;
        if ((this.pacCedula == null && other.pacCedula != null) || (this.pacCedula != null && !this.pacCedula.equals(other.pacCedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.capa.datos.TPaciente[ pacCedula=" + pacCedula + " ]";
    }
    
}
