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
@Table(name = "t_uroanalisis", catalog = "db_hospital_dia_v3", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TUroanalisis.findAll", query = "SELECT t FROM TUroanalisis t"),
    @NamedQuery(name = "TUroanalisis.findByUroSerial", query = "SELECT t FROM TUroanalisis t WHERE t.uroSerial = :uroSerial"),
    @NamedQuery(name = "TUroanalisis.findByUroDensidad", query = "SELECT t FROM TUroanalisis t WHERE t.uroDensidad = :uroDensidad"),
    @NamedQuery(name = "TUroanalisis.findByUroPh", query = "SELECT t FROM TUroanalisis t WHERE t.uroPh = :uroPh"),
    @NamedQuery(name = "TUroanalisis.findByUroProteina", query = "SELECT t FROM TUroanalisis t WHERE t.uroProteina = :uroProteina"),
    @NamedQuery(name = "TUroanalisis.findByUroGlucosa", query = "SELECT t FROM TUroanalisis t WHERE t.uroGlucosa = :uroGlucosa"),
    @NamedQuery(name = "TUroanalisis.findByUroCetona", query = "SELECT t FROM TUroanalisis t WHERE t.uroCetona = :uroCetona"),
    @NamedQuery(name = "TUroanalisis.findByUroHemoglobina", query = "SELECT t FROM TUroanalisis t WHERE t.uroHemoglobina = :uroHemoglobina"),
    @NamedQuery(name = "TUroanalisis.findByUroBilirrubina", query = "SELECT t FROM TUroanalisis t WHERE t.uroBilirrubina = :uroBilirrubina"),
    @NamedQuery(name = "TUroanalisis.findByUroUrobilinogeno", query = "SELECT t FROM TUroanalisis t WHERE t.uroUrobilinogeno = :uroUrobilinogeno"),
    @NamedQuery(name = "TUroanalisis.findByUroNitrito", query = "SELECT t FROM TUroanalisis t WHERE t.uroNitrito = :uroNitrito"),
    @NamedQuery(name = "TUroanalisis.findByUroLeucocitos", query = "SELECT t FROM TUroanalisis t WHERE t.uroLeucocitos = :uroLeucocitos"),
    @NamedQuery(name = "TUroanalisis.findByUroPiocitos", query = "SELECT t FROM TUroanalisis t WHERE t.uroPiocitos = :uroPiocitos"),
    @NamedQuery(name = "TUroanalisis.findByUroEritrocitos", query = "SELECT t FROM TUroanalisis t WHERE t.uroEritrocitos = :uroEritrocitos"),
    @NamedQuery(name = "TUroanalisis.findByUroBacterias", query = "SELECT t FROM TUroanalisis t WHERE t.uroBacterias = :uroBacterias")})
public class TUroanalisis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "uro_serial", nullable = false)
    private Integer uroSerial;
    @Size(max = 50)
    @Column(name = "uro_densidad", length = 50)
    private String uroDensidad;
    @Size(max = 50)
    @Column(name = "uro_ph", length = 50)
    private String uroPh;
    @Size(max = 50)
    @Column(name = "uro_proteina", length = 50)
    private String uroProteina;
    @Size(max = 50)
    @Column(name = "uro_glucosa", length = 50)
    private String uroGlucosa;
    @Size(max = 50)
    @Column(name = "uro_cetona", length = 50)
    private String uroCetona;
    @Size(max = 50)
    @Column(name = "uro_hemoglobina", length = 50)
    private String uroHemoglobina;
    @Size(max = 50)
    @Column(name = "uro_bilirrubina", length = 50)
    private String uroBilirrubina;
    @Size(max = 50)
    @Column(name = "uro_urobilinogeno", length = 50)
    private String uroUrobilinogeno;
    @Size(max = 50)
    @Column(name = "uro_nitrito", length = 50)
    private String uroNitrito;
    @Size(max = 50)
    @Column(name = "uro_leucocitos", length = 50)
    private String uroLeucocitos;
    @Size(max = 50)
    @Column(name = "uro_piocitos", length = 50)
    private String uroPiocitos;
    @Size(max = 50)
    @Column(name = "uro_eritrocitos", length = 50)
    private String uroEritrocitos;
    @Size(max = 50)
    @Column(name = "uro_bacterias", length = 50)
    private String uroBacterias;
    @OneToMany(mappedBy = "uroSerial")
    private List<TExamenes> tExamenesList;

    public TUroanalisis() {
    }

    public TUroanalisis(Integer uroSerial) {
        this.uroSerial = uroSerial;
    }

    public Integer getUroSerial() {
        return uroSerial;
    }

    public void setUroSerial(Integer uroSerial) {
        this.uroSerial = uroSerial;
    }

    public String getUroDensidad() {
        return uroDensidad;
    }

    public void setUroDensidad(String uroDensidad) {
        this.uroDensidad = uroDensidad;
    }

    public String getUroPh() {
        return uroPh;
    }

    public void setUroPh(String uroPh) {
        this.uroPh = uroPh;
    }

    public String getUroProteina() {
        return uroProteina;
    }

    public void setUroProteina(String uroProteina) {
        this.uroProteina = uroProteina;
    }

    public String getUroGlucosa() {
        return uroGlucosa;
    }

    public void setUroGlucosa(String uroGlucosa) {
        this.uroGlucosa = uroGlucosa;
    }

    public String getUroCetona() {
        return uroCetona;
    }

    public void setUroCetona(String uroCetona) {
        this.uroCetona = uroCetona;
    }

    public String getUroHemoglobina() {
        return uroHemoglobina;
    }

    public void setUroHemoglobina(String uroHemoglobina) {
        this.uroHemoglobina = uroHemoglobina;
    }

    public String getUroBilirrubina() {
        return uroBilirrubina;
    }

    public void setUroBilirrubina(String uroBilirrubina) {
        this.uroBilirrubina = uroBilirrubina;
    }

    public String getUroUrobilinogeno() {
        return uroUrobilinogeno;
    }

    public void setUroUrobilinogeno(String uroUrobilinogeno) {
        this.uroUrobilinogeno = uroUrobilinogeno;
    }

    public String getUroNitrito() {
        return uroNitrito;
    }

    public void setUroNitrito(String uroNitrito) {
        this.uroNitrito = uroNitrito;
    }

    public String getUroLeucocitos() {
        return uroLeucocitos;
    }

    public void setUroLeucocitos(String uroLeucocitos) {
        this.uroLeucocitos = uroLeucocitos;
    }

    public String getUroPiocitos() {
        return uroPiocitos;
    }

    public void setUroPiocitos(String uroPiocitos) {
        this.uroPiocitos = uroPiocitos;
    }

    public String getUroEritrocitos() {
        return uroEritrocitos;
    }

    public void setUroEritrocitos(String uroEritrocitos) {
        this.uroEritrocitos = uroEritrocitos;
    }

    public String getUroBacterias() {
        return uroBacterias;
    }

    public void setUroBacterias(String uroBacterias) {
        this.uroBacterias = uroBacterias;
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
        hash += (uroSerial != null ? uroSerial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TUroanalisis)) {
            return false;
        }
        TUroanalisis other = (TUroanalisis) object;
        if ((this.uroSerial == null && other.uroSerial != null) || (this.uroSerial != null && !this.uroSerial.equals(other.uroSerial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.capa.datos.TUroanalisis[ uroSerial=" + uroSerial + " ]";
    }
    
}
