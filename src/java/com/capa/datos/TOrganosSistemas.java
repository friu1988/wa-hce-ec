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
@Table(name = "t_organos_sistemas", catalog = "db_hospital_dia_v3", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TOrganosSistemas.findAll", query = "SELECT t FROM TOrganosSistemas t"),
    @NamedQuery(name = "TOrganosSistemas.findByOsSerial", query = "SELECT t FROM TOrganosSistemas t WHERE t.osSerial = :osSerial"),
    @NamedQuery(name = "TOrganosSistemas.findByOsSentidos", query = "SELECT t FROM TOrganosSistemas t WHERE t.osSentidos = :osSentidos"),
    @NamedQuery(name = "TOrganosSistemas.findByOsRespiratorio", query = "SELECT t FROM TOrganosSistemas t WHERE t.osRespiratorio = :osRespiratorio"),
    @NamedQuery(name = "TOrganosSistemas.findByOsCardioVascular", query = "SELECT t FROM TOrganosSistemas t WHERE t.osCardioVascular = :osCardioVascular"),
    @NamedQuery(name = "TOrganosSistemas.findByOsDigestivo", query = "SELECT t FROM TOrganosSistemas t WHERE t.osDigestivo = :osDigestivo"),
    @NamedQuery(name = "TOrganosSistemas.findByOsGenital", query = "SELECT t FROM TOrganosSistemas t WHERE t.osGenital = :osGenital"),
    @NamedQuery(name = "TOrganosSistemas.findByOsUrinario", query = "SELECT t FROM TOrganosSistemas t WHERE t.osUrinario = :osUrinario"),
    @NamedQuery(name = "TOrganosSistemas.findByOsMusculoEsqueletico", query = "SELECT t FROM TOrganosSistemas t WHERE t.osMusculoEsqueletico = :osMusculoEsqueletico"),
    @NamedQuery(name = "TOrganosSistemas.findByOsEndocrino", query = "SELECT t FROM TOrganosSistemas t WHERE t.osEndocrino = :osEndocrino"),
    @NamedQuery(name = "TOrganosSistemas.findByOsHemoLinfatico", query = "SELECT t FROM TOrganosSistemas t WHERE t.osHemoLinfatico = :osHemoLinfatico"),
    @NamedQuery(name = "TOrganosSistemas.findByOsNervioso", query = "SELECT t FROM TOrganosSistemas t WHERE t.osNervioso = :osNervioso"),
    @NamedQuery(name = "TOrganosSistemas.findByOsDescripcion", query = "SELECT t FROM TOrganosSistemas t WHERE t.osDescripcion = :osDescripcion")})
public class TOrganosSistemas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "os_serial", nullable = false)
    private Integer osSerial;
    @Column(name = "os_sentidos")
    private Boolean osSentidos;
    @Column(name = "os_respiratorio")
    private Boolean osRespiratorio;
    @Column(name = "os_cardio_vascular")
    private Boolean osCardioVascular;
    @Column(name = "os_digestivo")
    private Boolean osDigestivo;
    @Column(name = "os_genital")
    private Boolean osGenital;
    @Column(name = "os_urinario")
    private Boolean osUrinario;
    @Column(name = "os_musculo_esqueletico")
    private Boolean osMusculoEsqueletico;
    @Column(name = "os_endocrino")
    private Boolean osEndocrino;
    @Column(name = "os_hemo_linfatico")
    private Boolean osHemoLinfatico;
    @Column(name = "os_nervioso")
    private Boolean osNervioso;
    @Size(max = 250)
    @Column(name = "os_descripcion", length = 250)
    private String osDescripcion;
    @JoinColumn(name = "cex_serial", referencedColumnName = "cex_serial", nullable = false)
    @ManyToOne(optional = false)
    private TConsultaExterna cexSerial;

    public TOrganosSistemas() {
    }

    public TOrganosSistemas(Integer osSerial) {
        this.osSerial = osSerial;
    }

    public Integer getOsSerial() {
        return osSerial;
    }

    public void setOsSerial(Integer osSerial) {
        this.osSerial = osSerial;
    }

    public Boolean getOsSentidos() {
        return osSentidos;
    }

    public void setOsSentidos(Boolean osSentidos) {
        this.osSentidos = osSentidos;
    }

    public Boolean getOsRespiratorio() {
        return osRespiratorio;
    }

    public void setOsRespiratorio(Boolean osRespiratorio) {
        this.osRespiratorio = osRespiratorio;
    }

    public Boolean getOsCardioVascular() {
        return osCardioVascular;
    }

    public void setOsCardioVascular(Boolean osCardioVascular) {
        this.osCardioVascular = osCardioVascular;
    }

    public Boolean getOsDigestivo() {
        return osDigestivo;
    }

    public void setOsDigestivo(Boolean osDigestivo) {
        this.osDigestivo = osDigestivo;
    }

    public Boolean getOsGenital() {
        return osGenital;
    }

    public void setOsGenital(Boolean osGenital) {
        this.osGenital = osGenital;
    }

    public Boolean getOsUrinario() {
        return osUrinario;
    }

    public void setOsUrinario(Boolean osUrinario) {
        this.osUrinario = osUrinario;
    }

    public Boolean getOsMusculoEsqueletico() {
        return osMusculoEsqueletico;
    }

    public void setOsMusculoEsqueletico(Boolean osMusculoEsqueletico) {
        this.osMusculoEsqueletico = osMusculoEsqueletico;
    }

    public Boolean getOsEndocrino() {
        return osEndocrino;
    }

    public void setOsEndocrino(Boolean osEndocrino) {
        this.osEndocrino = osEndocrino;
    }

    public Boolean getOsHemoLinfatico() {
        return osHemoLinfatico;
    }

    public void setOsHemoLinfatico(Boolean osHemoLinfatico) {
        this.osHemoLinfatico = osHemoLinfatico;
    }

    public Boolean getOsNervioso() {
        return osNervioso;
    }

    public void setOsNervioso(Boolean osNervioso) {
        this.osNervioso = osNervioso;
    }

    public String getOsDescripcion() {
        return osDescripcion;
    }

    public void setOsDescripcion(String osDescripcion) {
        this.osDescripcion = osDescripcion;
    }

    public TConsultaExterna getCexSerial() {
        return cexSerial;
    }

    public void setCexSerial(TConsultaExterna cexSerial) {
        this.cexSerial = cexSerial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (osSerial != null ? osSerial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TOrganosSistemas)) {
            return false;
        }
        TOrganosSistemas other = (TOrganosSistemas) object;
        if ((this.osSerial == null && other.osSerial != null) || (this.osSerial != null && !this.osSerial.equals(other.osSerial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.capa.datos.TOrganosSistemas[ osSerial=" + osSerial + " ]";
    }
    
}
