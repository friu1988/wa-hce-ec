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
@Table(name = "t_coprologico", catalog = "db_hospital_dia_v3", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TCoprologico.findAll", query = "SELECT t FROM TCoprologico t"),
    @NamedQuery(name = "TCoprologico.findByCopSerial", query = "SELECT t FROM TCoprologico t WHERE t.copSerial = :copSerial"),
    @NamedQuery(name = "TCoprologico.findByCopPolimorfos", query = "SELECT t FROM TCoprologico t WHERE t.copPolimorfos = :copPolimorfos"),
    @NamedQuery(name = "TCoprologico.findByCopCristales", query = "SELECT t FROM TCoprologico t WHERE t.copCristales = :copCristales"),
    @NamedQuery(name = "TCoprologico.findByCopMoco", query = "SELECT t FROM TCoprologico t WHERE t.copMoco = :copMoco"),
    @NamedQuery(name = "TCoprologico.findByCopGrasa", query = "SELECT t FROM TCoprologico t WHERE t.copGrasa = :copGrasa"),
    @NamedQuery(name = "TCoprologico.findByCopParasitos", query = "SELECT t FROM TCoprologico t WHERE t.copParasitos = :copParasitos"),
    @NamedQuery(name = "TCoprologico.findByCopSangreOculta", query = "SELECT t FROM TCoprologico t WHERE t.copSangreOculta = :copSangreOculta"),
    @NamedQuery(name = "TCoprologico.findByCopGlucosaAyunas", query = "SELECT t FROM TCoprologico t WHERE t.copGlucosaAyunas = :copGlucosaAyunas"),
    @NamedQuery(name = "TCoprologico.findByCopGlucosaDosHoras", query = "SELECT t FROM TCoprologico t WHERE t.copGlucosaDosHoras = :copGlucosaDosHoras"),
    @NamedQuery(name = "TCoprologico.findByCopUrea", query = "SELECT t FROM TCoprologico t WHERE t.copUrea = :copUrea"),
    @NamedQuery(name = "TCoprologico.findByCopCreatinina", query = "SELECT t FROM TCoprologico t WHERE t.copCreatinina = :copCreatinina"),
    @NamedQuery(name = "TCoprologico.findByCopBilirrubinaTotal", query = "SELECT t FROM TCoprologico t WHERE t.copBilirrubinaTotal = :copBilirrubinaTotal"),
    @NamedQuery(name = "TCoprologico.findByCopDirecta", query = "SELECT t FROM TCoprologico t WHERE t.copDirecta = :copDirecta"),
    @NamedQuery(name = "TCoprologico.findByCopAcidoUrico", query = "SELECT t FROM TCoprologico t WHERE t.copAcidoUrico = :copAcidoUrico"),
    @NamedQuery(name = "TCoprologico.findByCopProteinaTotal", query = "SELECT t FROM TCoprologico t WHERE t.copProteinaTotal = :copProteinaTotal"),
    @NamedQuery(name = "TCoprologico.findByCopAlbumina", query = "SELECT t FROM TCoprologico t WHERE t.copAlbumina = :copAlbumina"),
    @NamedQuery(name = "TCoprologico.findByCopGlobulina", query = "SELECT t FROM TCoprologico t WHERE t.copGlobulina = :copGlobulina"),
    @NamedQuery(name = "TCoprologico.findByCopAltTgp", query = "SELECT t FROM TCoprologico t WHERE t.copAltTgp = :copAltTgp"),
    @NamedQuery(name = "TCoprologico.findByCopAstTgo", query = "SELECT t FROM TCoprologico t WHERE t.copAstTgo = :copAstTgo"),
    @NamedQuery(name = "TCoprologico.findByCopFosfataAlc", query = "SELECT t FROM TCoprologico t WHERE t.copFosfataAlc = :copFosfataAlc"),
    @NamedQuery(name = "TCoprologico.findByCopFosfataAcida", query = "SELECT t FROM TCoprologico t WHERE t.copFosfataAcida = :copFosfataAcida"),
    @NamedQuery(name = "TCoprologico.findByCopColesterolLdl", query = "SELECT t FROM TCoprologico t WHERE t.copColesterolLdl = :copColesterolLdl"),
    @NamedQuery(name = "TCoprologico.findByCopTrigliceridos", query = "SELECT t FROM TCoprologico t WHERE t.copTrigliceridos = :copTrigliceridos"),
    @NamedQuery(name = "TCoprologico.findByCopHierroSerico", query = "SELECT t FROM TCoprologico t WHERE t.copHierroSerico = :copHierroSerico"),
    @NamedQuery(name = "TCoprologico.findByCopAmilasa", query = "SELECT t FROM TCoprologico t WHERE t.copAmilasa = :copAmilasa")})
public class TCoprologico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cop_serial", nullable = false)
    private Integer copSerial;
    @Size(max = 100)
    @Column(name = "cop_polimorfos", length = 100)
    private String copPolimorfos;
    @Size(max = 100)
    @Column(name = "cop_cristales", length = 100)
    private String copCristales;
    @Size(max = 100)
    @Column(name = "cop_moco", length = 100)
    private String copMoco;
    @Size(max = 100)
    @Column(name = "cop_grasa", length = 100)
    private String copGrasa;
    @Size(max = 100)
    @Column(name = "cop_parasitos", length = 100)
    private String copParasitos;
    @Size(max = 100)
    @Column(name = "cop_sangre_oculta", length = 100)
    private String copSangreOculta;
    @Size(max = 100)
    @Column(name = "cop_glucosa_ayunas", length = 100)
    private String copGlucosaAyunas;
    @Size(max = 100)
    @Column(name = "cop_glucosa_dos_horas", length = 100)
    private String copGlucosaDosHoras;
    @Size(max = 100)
    @Column(name = "cop_urea", length = 100)
    private String copUrea;
    @Size(max = 100)
    @Column(name = "cop_creatinina", length = 100)
    private String copCreatinina;
    @Size(max = 100)
    @Column(name = "cop_bilirrubina_total", length = 100)
    private String copBilirrubinaTotal;
    @Size(max = 100)
    @Column(name = "cop_directa", length = 100)
    private String copDirecta;
    @Size(max = 100)
    @Column(name = "cop_acido_urico", length = 100)
    private String copAcidoUrico;
    @Size(max = 100)
    @Column(name = "cop_proteina_total", length = 100)
    private String copProteinaTotal;
    @Size(max = 100)
    @Column(name = "cop_albumina", length = 100)
    private String copAlbumina;
    @Size(max = 100)
    @Column(name = "cop_globulina", length = 100)
    private String copGlobulina;
    @Size(max = 100)
    @Column(name = "cop_alt_tgp", length = 100)
    private String copAltTgp;
    @Size(max = 100)
    @Column(name = "cop_ast_tgo", length = 100)
    private String copAstTgo;
    @Size(max = 100)
    @Column(name = "cop_fosfata_alc", length = 100)
    private String copFosfataAlc;
    @Size(max = 100)
    @Column(name = "cop_fosfata_acida", length = 100)
    private String copFosfataAcida;
    @Size(max = 100)
    @Column(name = "cop_colesterol_ldl", length = 100)
    private String copColesterolLdl;
    @Size(max = 100)
    @Column(name = "cop_trigliceridos", length = 100)
    private String copTrigliceridos;
    @Size(max = 100)
    @Column(name = "cop_hierro_serico", length = 100)
    private String copHierroSerico;
    @Size(max = 100)
    @Column(name = "cop_amilasa", length = 100)
    private String copAmilasa;
    @OneToMany(mappedBy = "copSerial")
    private List<TExamenes> tExamenesList;

    public TCoprologico() {
    }

    public TCoprologico(Integer copSerial) {
        this.copSerial = copSerial;
    }

    public Integer getCopSerial() {
        return copSerial;
    }

    public void setCopSerial(Integer copSerial) {
        this.copSerial = copSerial;
    }

    public String getCopPolimorfos() {
        return copPolimorfos;
    }

    public void setCopPolimorfos(String copPolimorfos) {
        this.copPolimorfos = copPolimorfos;
    }

    public String getCopCristales() {
        return copCristales;
    }

    public void setCopCristales(String copCristales) {
        this.copCristales = copCristales;
    }

    public String getCopMoco() {
        return copMoco;
    }

    public void setCopMoco(String copMoco) {
        this.copMoco = copMoco;
    }

    public String getCopGrasa() {
        return copGrasa;
    }

    public void setCopGrasa(String copGrasa) {
        this.copGrasa = copGrasa;
    }

    public String getCopParasitos() {
        return copParasitos;
    }

    public void setCopParasitos(String copParasitos) {
        this.copParasitos = copParasitos;
    }

    public String getCopSangreOculta() {
        return copSangreOculta;
    }

    public void setCopSangreOculta(String copSangreOculta) {
        this.copSangreOculta = copSangreOculta;
    }

    public String getCopGlucosaAyunas() {
        return copGlucosaAyunas;
    }

    public void setCopGlucosaAyunas(String copGlucosaAyunas) {
        this.copGlucosaAyunas = copGlucosaAyunas;
    }

    public String getCopGlucosaDosHoras() {
        return copGlucosaDosHoras;
    }

    public void setCopGlucosaDosHoras(String copGlucosaDosHoras) {
        this.copGlucosaDosHoras = copGlucosaDosHoras;
    }

    public String getCopUrea() {
        return copUrea;
    }

    public void setCopUrea(String copUrea) {
        this.copUrea = copUrea;
    }

    public String getCopCreatinina() {
        return copCreatinina;
    }

    public void setCopCreatinina(String copCreatinina) {
        this.copCreatinina = copCreatinina;
    }

    public String getCopBilirrubinaTotal() {
        return copBilirrubinaTotal;
    }

    public void setCopBilirrubinaTotal(String copBilirrubinaTotal) {
        this.copBilirrubinaTotal = copBilirrubinaTotal;
    }

    public String getCopDirecta() {
        return copDirecta;
    }

    public void setCopDirecta(String copDirecta) {
        this.copDirecta = copDirecta;
    }

    public String getCopAcidoUrico() {
        return copAcidoUrico;
    }

    public void setCopAcidoUrico(String copAcidoUrico) {
        this.copAcidoUrico = copAcidoUrico;
    }

    public String getCopProteinaTotal() {
        return copProteinaTotal;
    }

    public void setCopProteinaTotal(String copProteinaTotal) {
        this.copProteinaTotal = copProteinaTotal;
    }

    public String getCopAlbumina() {
        return copAlbumina;
    }

    public void setCopAlbumina(String copAlbumina) {
        this.copAlbumina = copAlbumina;
    }

    public String getCopGlobulina() {
        return copGlobulina;
    }

    public void setCopGlobulina(String copGlobulina) {
        this.copGlobulina = copGlobulina;
    }

    public String getCopAltTgp() {
        return copAltTgp;
    }

    public void setCopAltTgp(String copAltTgp) {
        this.copAltTgp = copAltTgp;
    }

    public String getCopAstTgo() {
        return copAstTgo;
    }

    public void setCopAstTgo(String copAstTgo) {
        this.copAstTgo = copAstTgo;
    }

    public String getCopFosfataAlc() {
        return copFosfataAlc;
    }

    public void setCopFosfataAlc(String copFosfataAlc) {
        this.copFosfataAlc = copFosfataAlc;
    }

    public String getCopFosfataAcida() {
        return copFosfataAcida;
    }

    public void setCopFosfataAcida(String copFosfataAcida) {
        this.copFosfataAcida = copFosfataAcida;
    }

    public String getCopColesterolLdl() {
        return copColesterolLdl;
    }

    public void setCopColesterolLdl(String copColesterolLdl) {
        this.copColesterolLdl = copColesterolLdl;
    }

    public String getCopTrigliceridos() {
        return copTrigliceridos;
    }

    public void setCopTrigliceridos(String copTrigliceridos) {
        this.copTrigliceridos = copTrigliceridos;
    }

    public String getCopHierroSerico() {
        return copHierroSerico;
    }

    public void setCopHierroSerico(String copHierroSerico) {
        this.copHierroSerico = copHierroSerico;
    }

    public String getCopAmilasa() {
        return copAmilasa;
    }

    public void setCopAmilasa(String copAmilasa) {
        this.copAmilasa = copAmilasa;
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
        hash += (copSerial != null ? copSerial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TCoprologico)) {
            return false;
        }
        TCoprologico other = (TCoprologico) object;
        if ((this.copSerial == null && other.copSerial != null) || (this.copSerial != null && !this.copSerial.equals(other.copSerial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.capa.datos.TCoprologico[ copSerial=" + copSerial + " ]";
    }
    
}
