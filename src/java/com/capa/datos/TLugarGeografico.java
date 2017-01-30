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
@Table(name = "t_lugar_geografico", catalog = "db_hospital_dia_v3", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TLugarGeografico.findAll", query = "SELECT t FROM TLugarGeografico t"),
    @NamedQuery(name = "TLugarGeografico.findByLgCodigo", query = "SELECT t FROM TLugarGeografico t WHERE t.lgCodigo = :lgCodigo"),
    @NamedQuery(name = "TLugarGeografico.findByLgNombre", query = "SELECT t FROM TLugarGeografico t WHERE t.lgNombre = :lgNombre")})
public class TLugarGeografico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "lg_codigo", nullable = false, length = 10)
    private String lgCodigo;
    @Size(max = 250)
    @Column(name = "lg_nombre", length = 250)
    private String lgNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lgCodigo")
    private List<TPaciente> tPacienteList;
    @OneToMany(mappedBy = "padreLgCodigo")
    private List<TLugarGeografico> tLugarGeograficoList;
    @JoinColumn(name = "padre_lg_codigo", referencedColumnName = "lg_codigo")
    @ManyToOne
    private TLugarGeografico padreLgCodigo;

    public TLugarGeografico() {
    }

    public TLugarGeografico(String lgCodigo) {
        this.lgCodigo = lgCodigo;
    }

    public String getLgCodigo() {
        return lgCodigo;
    }

    public void setLgCodigo(String lgCodigo) {
        this.lgCodigo = lgCodigo;
    }

    public String getLgNombre() {
        return lgNombre;
    }

    public void setLgNombre(String lgNombre) {
        this.lgNombre = lgNombre;
    }

    @XmlTransient
    public List<TPaciente> getTPacienteList() {
        return tPacienteList;
    }

    public void setTPacienteList(List<TPaciente> tPacienteList) {
        this.tPacienteList = tPacienteList;
    }

    @XmlTransient
    public List<TLugarGeografico> getTLugarGeograficoList() {
        return tLugarGeograficoList;
    }

    public void setTLugarGeograficoList(List<TLugarGeografico> tLugarGeograficoList) {
        this.tLugarGeograficoList = tLugarGeograficoList;
    }

    public TLugarGeografico getPadreLgCodigo() {
        return padreLgCodigo;
    }

    public void setPadreLgCodigo(TLugarGeografico padreLgCodigo) {
        this.padreLgCodigo = padreLgCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lgCodigo != null ? lgCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TLugarGeografico)) {
            return false;
        }
        TLugarGeografico other = (TLugarGeografico) object;
        if ((this.lgCodigo == null && other.lgCodigo != null) || (this.lgCodigo != null && !this.lgCodigo.equals(other.lgCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.capa.datos.TLugarGeografico[ lgCodigo=" + lgCodigo + " ]";
    }
    
}
