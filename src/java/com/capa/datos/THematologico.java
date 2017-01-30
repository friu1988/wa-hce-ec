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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FREDDY
 */
@Entity
@Table(name = "t_hematologico", catalog = "db_hospital_dia_v3", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "THematologico.findAll", query = "SELECT t FROM THematologico t"),
    @NamedQuery(name = "THematologico.findByHeSerial", query = "SELECT t FROM THematologico t WHERE t.heSerial = :heSerial"),
    @NamedQuery(name = "THematologico.findByHeHematocrito", query = "SELECT t FROM THematologico t WHERE t.heHematocrito = :heHematocrito"),
    @NamedQuery(name = "THematologico.findByHeHemoglobina", query = "SELECT t FROM THematologico t WHERE t.heHemoglobina = :heHemoglobina"),
    @NamedQuery(name = "THematologico.findByHeSedimentacion", query = "SELECT t FROM THematologico t WHERE t.heSedimentacion = :heSedimentacion"),
    @NamedQuery(name = "THematologico.findByHePlaquetas", query = "SELECT t FROM THematologico t WHERE t.hePlaquetas = :hePlaquetas"),
    @NamedQuery(name = "THematologico.findByHeLeucitos", query = "SELECT t FROM THematologico t WHERE t.heLeucitos = :heLeucitos"),
    @NamedQuery(name = "THematologico.findByHeFormulaLeucocitariaLin", query = "SELECT t FROM THematologico t WHERE t.heFormulaLeucocitariaLin = :heFormulaLeucocitariaLin"),
    @NamedQuery(name = "THematologico.findByHeFormulaLeucocitariaMon", query = "SELECT t FROM THematologico t WHERE t.heFormulaLeucocitariaMon = :heFormulaLeucocitariaMon"),
    @NamedQuery(name = "THematologico.findByHeFormulaLeucocitariaBas", query = "SELECT t FROM THematologico t WHERE t.heFormulaLeucocitariaBas = :heFormulaLeucocitariaBas"),
    @NamedQuery(name = "THematologico.findByHeFormulaLeucocitariaEos", query = "SELECT t FROM THematologico t WHERE t.heFormulaLeucocitariaEos = :heFormulaLeucocitariaEos"),
    @NamedQuery(name = "THematologico.findByHeFormulaLeucocitariaSeg", query = "SELECT t FROM THematologico t WHERE t.heFormulaLeucocitariaSeg = :heFormulaLeucocitariaSeg"),
    @NamedQuery(name = "THematologico.findByHeFormulaLeucocitariaCay", query = "SELECT t FROM THematologico t WHERE t.heFormulaLeucocitariaCay = :heFormulaLeucocitariaCay"),
    @NamedQuery(name = "THematologico.findByHeHcm", query = "SELECT t FROM THematologico t WHERE t.heHcm = :heHcm"),
    @NamedQuery(name = "THematologico.findByHeCmhc", query = "SELECT t FROM THematologico t WHERE t.heCmhc = :heCmhc"),
    @NamedQuery(name = "THematologico.findByHeGrupoSanguineo", query = "SELECT t FROM THematologico t WHERE t.heGrupoSanguineo = :heGrupoSanguineo"),
    @NamedQuery(name = "THematologico.findByHeFactorRh", query = "SELECT t FROM THematologico t WHERE t.heFactorRh = :heFactorRh"),
    @NamedQuery(name = "THematologico.findByHeTtp", query = "SELECT t FROM THematologico t WHERE t.heTtp = :heTtp"),
    @NamedQuery(name = "THematologico.findByHeProtrombina", query = "SELECT t FROM THematologico t WHERE t.heProtrombina = :heProtrombina"),
    @NamedQuery(name = "THematologico.findByHeCoagulacion", query = "SELECT t FROM THematologico t WHERE t.heCoagulacion = :heCoagulacion"),
    @NamedQuery(name = "THematologico.findByHeSangria", query = "SELECT t FROM THematologico t WHERE t.heSangria = :heSangria")})
public class THematologico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "he_serial", nullable = false)
    private Integer heSerial;
    @Size(max = 200)
    @Column(name = "he_hematocrito", length = 200)
    private String heHematocrito;
    @Size(max = 200)
    @Column(name = "he_hemoglobina", length = 200)
    private String heHemoglobina;
    @Size(max = 200)
    @Column(name = "he_sedimentacion", length = 200)
    private String heSedimentacion;
    @Size(max = 200)
    @Column(name = "he_plaquetas", length = 200)
    private String hePlaquetas;
    @Size(max = 200)
    @Column(name = "he_leucitos", length = 200)
    private String heLeucitos;
    @Size(max = 200)
    @Column(name = "he_formula_leucocitaria_lin", length = 200)
    private String heFormulaLeucocitariaLin;
    @Size(max = 200)
    @Column(name = "he_formula_leucocitaria_mon", length = 200)
    private String heFormulaLeucocitariaMon;
    @Size(max = 200)
    @Column(name = "he_formula_leucocitaria_bas", length = 200)
    private String heFormulaLeucocitariaBas;
    @Size(max = 200)
    @Column(name = "he_formula_leucocitaria_eos", length = 200)
    private String heFormulaLeucocitariaEos;
    @Size(max = 200)
    @Column(name = "he_formula_leucocitaria_seg", length = 200)
    private String heFormulaLeucocitariaSeg;
    @Size(max = 200)
    @Column(name = "he_formula_leucocitaria_cay", length = 200)
    private String heFormulaLeucocitariaCay;
    @Size(max = 200)
    @Column(name = "he_hcm", length = 200)
    private String heHcm;
    @Size(max = 200)
    @Column(name = "he_cmhc", length = 200)
    private String heCmhc;
    @Size(max = 200)
    @Column(name = "he_grupo_sanguineo", length = 200)
    private String heGrupoSanguineo;
    @Size(max = 200)
    @Column(name = "he_factor_rh", length = 200)
    private String heFactorRh;
    @Size(max = 200)
    @Column(name = "he_ttp", length = 200)
    private String heTtp;
    @Size(max = 200)
    @Column(name = "he_protrombina", length = 200)
    private String heProtrombina;
    @Size(max = 200)
    @Column(name = "he_coagulacion", length = 200)
    private String heCoagulacion;
    @Size(max = 200)
    @Column(name = "he_sangria", length = 200)
    private String heSangria;
    @OneToMany(mappedBy = "heSerial")
    private List<TExamenes> tExamenesList;

    public THematologico() {
    }

    public THematologico(Integer heSerial) {
        this.heSerial = heSerial;
    }

    public Integer getHeSerial() {
        return heSerial;
    }

    public void setHeSerial(Integer heSerial) {
        this.heSerial = heSerial;
    }

    public String getHeHematocrito() {
        return heHematocrito;
    }

    public void setHeHematocrito(String heHematocrito) {
        this.heHematocrito = heHematocrito;
    }

    public String getHeHemoglobina() {
        return heHemoglobina;
    }

    public void setHeHemoglobina(String heHemoglobina) {
        this.heHemoglobina = heHemoglobina;
    }

    public String getHeSedimentacion() {
        return heSedimentacion;
    }

    public void setHeSedimentacion(String heSedimentacion) {
        this.heSedimentacion = heSedimentacion;
    }

    public String getHePlaquetas() {
        return hePlaquetas;
    }

    public void setHePlaquetas(String hePlaquetas) {
        this.hePlaquetas = hePlaquetas;
    }

    public String getHeLeucitos() {
        return heLeucitos;
    }

    public void setHeLeucitos(String heLeucitos) {
        this.heLeucitos = heLeucitos;
    }

    public String getHeFormulaLeucocitariaLin() {
        return heFormulaLeucocitariaLin;
    }

    public void setHeFormulaLeucocitariaLin(String heFormulaLeucocitariaLin) {
        this.heFormulaLeucocitariaLin = heFormulaLeucocitariaLin;
    }

    public String getHeFormulaLeucocitariaMon() {
        return heFormulaLeucocitariaMon;
    }

    public void setHeFormulaLeucocitariaMon(String heFormulaLeucocitariaMon) {
        this.heFormulaLeucocitariaMon = heFormulaLeucocitariaMon;
    }

    public String getHeFormulaLeucocitariaBas() {
        return heFormulaLeucocitariaBas;
    }

    public void setHeFormulaLeucocitariaBas(String heFormulaLeucocitariaBas) {
        this.heFormulaLeucocitariaBas = heFormulaLeucocitariaBas;
    }

    public String getHeFormulaLeucocitariaEos() {
        return heFormulaLeucocitariaEos;
    }

    public void setHeFormulaLeucocitariaEos(String heFormulaLeucocitariaEos) {
        this.heFormulaLeucocitariaEos = heFormulaLeucocitariaEos;
    }

    public String getHeFormulaLeucocitariaSeg() {
        return heFormulaLeucocitariaSeg;
    }

    public void setHeFormulaLeucocitariaSeg(String heFormulaLeucocitariaSeg) {
        this.heFormulaLeucocitariaSeg = heFormulaLeucocitariaSeg;
    }

    public String getHeFormulaLeucocitariaCay() {
        return heFormulaLeucocitariaCay;
    }

    public void setHeFormulaLeucocitariaCay(String heFormulaLeucocitariaCay) {
        this.heFormulaLeucocitariaCay = heFormulaLeucocitariaCay;
    }

    public String getHeHcm() {
        return heHcm;
    }

    public void setHeHcm(String heHcm) {
        this.heHcm = heHcm;
    }

    public String getHeCmhc() {
        return heCmhc;
    }

    public void setHeCmhc(String heCmhc) {
        this.heCmhc = heCmhc;
    }

    public String getHeGrupoSanguineo() {
        return heGrupoSanguineo;
    }

    public void setHeGrupoSanguineo(String heGrupoSanguineo) {
        this.heGrupoSanguineo = heGrupoSanguineo;
    }

    public String getHeFactorRh() {
        return heFactorRh;
    }

    public void setHeFactorRh(String heFactorRh) {
        this.heFactorRh = heFactorRh;
    }

    public String getHeTtp() {
        return heTtp;
    }

    public void setHeTtp(String heTtp) {
        this.heTtp = heTtp;
    }

    public String getHeProtrombina() {
        return heProtrombina;
    }

    public void setHeProtrombina(String heProtrombina) {
        this.heProtrombina = heProtrombina;
    }

    public String getHeCoagulacion() {
        return heCoagulacion;
    }

    public void setHeCoagulacion(String heCoagulacion) {
        this.heCoagulacion = heCoagulacion;
    }

    public String getHeSangria() {
        return heSangria;
    }

    public void setHeSangria(String heSangria) {
        this.heSangria = heSangria;
    }

    @XmlTransient
    public List<TExamenes> getTExamenesList() {
        return tExamenesList;
    }

    public void setTExamenesList(List<TExamenes> tExamenesList) {
        this.tExamenesList = tExamenesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (heSerial != null ? heSerial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof THematologico)) {
            return false;
        }
        THematologico other = (THematologico) object;
        if ((this.heSerial == null && other.heSerial != null) || (this.heSerial != null && !this.heSerial.equals(other.heSerial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.capa.datos.THematologico[ heSerial=" + heSerial + " ]";
    }
    
}
