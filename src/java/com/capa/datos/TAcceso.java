/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capa.datos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FREDDY
 */
@Entity
@Table(name = "t_acceso", catalog = "db_hospital_dia_v3", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TAcceso.findAll", query = "SELECT t FROM TAcceso t"),
    @NamedQuery(name = "TAcceso.findByMenSerial", query = "SELECT t FROM TAcceso t WHERE t.tAccesoPK.menSerial = :menSerial"),
    @NamedQuery(name = "TAcceso.findByTuSerial", query = "SELECT t FROM TAcceso t WHERE t.tAccesoPK.tuSerial = :tuSerial"),
    @NamedQuery(name = "TAcceso.findByAcCreate", query = "SELECT t FROM TAcceso t WHERE t.acCreate = :acCreate"),
    @NamedQuery(name = "TAcceso.findByAcRead", query = "SELECT t FROM TAcceso t WHERE t.acRead = :acRead"),
    @NamedQuery(name = "TAcceso.findByAcUpdate", query = "SELECT t FROM TAcceso t WHERE t.acUpdate = :acUpdate"),
    @NamedQuery(name = "TAcceso.findByAcDelete", query = "SELECT t FROM TAcceso t WHERE t.acDelete = :acDelete")})
public class TAcceso implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TAccesoPK tAccesoPK;
    @Column(name = "ac_create")
    private Boolean acCreate;
    @Column(name = "ac_read")
    private Boolean acRead;
    @Column(name = "ac_update")
    private Boolean acUpdate;
    @Column(name = "ac_delete")
    private Boolean acDelete;
    @JoinColumn(name = "tu_serial", referencedColumnName = "tu_serial", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TTipoUsuario tTipoUsuario;
    @JoinColumn(name = "men_serial", referencedColumnName = "men_serial", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TMenu tMenu;

    public TAcceso() {
    }

    public TAcceso(TAccesoPK tAccesoPK) {
        this.tAccesoPK = tAccesoPK;
    }

    public TAcceso(int menSerial, String tuSerial) {
        this.tAccesoPK = new TAccesoPK(menSerial, tuSerial);
    }

    public TAccesoPK getTAccesoPK() {
        return tAccesoPK;
    }

    public void setTAccesoPK(TAccesoPK tAccesoPK) {
        this.tAccesoPK = tAccesoPK;
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

    public TTipoUsuario getTTipoUsuario() {
        return tTipoUsuario;
    }

    public void setTTipoUsuario(TTipoUsuario tTipoUsuario) {
        this.tTipoUsuario = tTipoUsuario;
    }

    public TMenu getTMenu() {
        return tMenu;
    }

    public void setTMenu(TMenu tMenu) {
        this.tMenu = tMenu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tAccesoPK != null ? tAccesoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TAcceso)) {
            return false;
        }
        TAcceso other = (TAcceso) object;
        if ((this.tAccesoPK == null && other.tAccesoPK != null) || (this.tAccesoPK != null && !this.tAccesoPK.equals(other.tAccesoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.capa.datos.TAcceso[ tAccesoPK=" + tAccesoPK + " ]";
    }
    
}
