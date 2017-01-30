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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FREDDY
 */
@Entity
@Table(name = "v_perfiles", catalog = "db_hospital_dia_v3", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VPerfiles.findAll", query = "SELECT v FROM VPerfiles v"),
    @NamedQuery(name = "VPerfiles.findByMenSerial", query = "SELECT v FROM VPerfiles v WHERE v.menSerial = :menSerial"),
    @NamedQuery(name = "VPerfiles.findByMenNombre", query = "SELECT v FROM VPerfiles v WHERE v.menNombre = :menNombre"),
    @NamedQuery(name = "VPerfiles.findByMenUrl", query = "SELECT v FROM VPerfiles v WHERE v.menUrl = :menUrl"),
    @NamedQuery(name = "VPerfiles.findByMenNivel", query = "SELECT v FROM VPerfiles v WHERE v.menNivel = :menNivel"),
    @NamedQuery(name = "VPerfiles.findByMenOrden", query = "SELECT v FROM VPerfiles v WHERE v.menOrden = :menOrden"),
    @NamedQuery(name = "VPerfiles.findByPadreMenSerial", query = "SELECT v FROM VPerfiles v WHERE v.padreMenSerial = :padreMenSerial"),
    @NamedQuery(name = "VPerfiles.findByTuSerial", query = "SELECT v FROM VPerfiles v WHERE v.tuSerial = :tuSerial"),
    @NamedQuery(name = "VPerfiles.findByAcCreate", query = "SELECT v FROM VPerfiles v WHERE v.acCreate = :acCreate"),
    @NamedQuery(name = "VPerfiles.findByAcRead", query = "SELECT v FROM VPerfiles v WHERE v.acRead = :acRead"),
    @NamedQuery(name = "VPerfiles.findByAcUpdate", query = "SELECT v FROM VPerfiles v WHERE v.acUpdate = :acUpdate"),
    @NamedQuery(name = "VPerfiles.findByAcDelete", query = "SELECT v FROM VPerfiles v WHERE v.acDelete = :acDelete")})
public class VPerfiles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "men_serial", nullable = false)
    @Id
    private int menSerial;
    @Size(max = 100)
    @Column(name = "men_nombre", length = 100)
    private String menNombre;
    @Size(max = 100)
    @Column(name = "men_url", length = 100)
    private String menUrl;
    @Column(name = "men_nivel")
    private Integer menNivel;
    @Column(name = "men_orden")
    private Integer menOrden;
    @Column(name = "padre_men_serial")
    private Integer padreMenSerial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "tu_serial", nullable = false, length = 2)
    private String tuSerial;
    @Column(name = "ac_create")
    private Boolean acCreate;
    @Column(name = "ac_read")
    private Boolean acRead;
    @Column(name = "ac_update")
    private Boolean acUpdate;
    @Column(name = "ac_delete")
    private Boolean acDelete;

    public VPerfiles() {
    }

    public int getMenSerial() {
        return menSerial;
    }

    public void setMenSerial(int menSerial) {
        this.menSerial = menSerial;
    }

    public String getMenNombre() {
        return menNombre;
    }

    public void setMenNombre(String menNombre) {
        this.menNombre = menNombre;
    }

    public String getMenUrl() {
        return menUrl;
    }

    public void setMenUrl(String menUrl) {
        this.menUrl = menUrl;
    }

    public Integer getMenNivel() {
        return menNivel;
    }

    public void setMenNivel(Integer menNivel) {
        this.menNivel = menNivel;
    }

    public Integer getMenOrden() {
        return menOrden;
    }

    public void setMenOrden(Integer menOrden) {
        this.menOrden = menOrden;
    }

    public Integer getPadreMenSerial() {
        return padreMenSerial;
    }

    public void setPadreMenSerial(Integer padreMenSerial) {
        this.padreMenSerial = padreMenSerial;
    }

    public String getTuSerial() {
        return tuSerial;
    }

    public void setTuSerial(String tuSerial) {
        this.tuSerial = tuSerial;
    }

    public Boolean getAcCreate() {
        return acCreate;
    }

    public void setAcCreate(Boolean acCreate) {
        this.acCreate = acCreate;
    }

    public Boolean getAcRead() {
        return acRead;
    }

    public void setAcRead(Boolean acRead) {
        this.acRead = acRead;
    }

    public Boolean getAcUpdate() {
        return acUpdate;
    }

    public void setAcUpdate(Boolean acUpdate) {
        this.acUpdate = acUpdate;
    }

    public Boolean getAcDelete() {
        return acDelete;
    }

    public void setAcDelete(Boolean acDelete) {
        this.acDelete = acDelete;
    }
    
}
