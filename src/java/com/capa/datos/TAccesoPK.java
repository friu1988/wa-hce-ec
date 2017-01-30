/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capa.datos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author FREDDY
 */
@Embeddable
public class TAccesoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "men_serial", nullable = false)
    private int menSerial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "tu_serial", nullable = false, length = 2)
    private String tuSerial;

    public TAccesoPK() {
    }

    public TAccesoPK(int menSerial, String tuSerial) {
        this.menSerial = menSerial;
        this.tuSerial = tuSerial;
    }

    public int getMenSerial() {
        return menSerial;
    }

    public void setMenSerial(int menSerial) {
        this.menSerial = menSerial;
    }

    public String getTuSerial() {
        return tuSerial;
    }

    public void setTuSerial(String tuSerial) {
        this.tuSerial = tuSerial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) menSerial;
        hash += (tuSerial != null ? tuSerial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TAccesoPK)) {
            return false;
        }
        TAccesoPK other = (TAccesoPK) object;
        if (this.menSerial != other.menSerial) {
            return false;
        }
        if ((this.tuSerial == null && other.tuSerial != null) || (this.tuSerial != null && !this.tuSerial.equals(other.tuSerial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.capa.datos.TAccesoPK[ menSerial=" + menSerial + ", tuSerial=" + tuSerial + " ]";
    }
    
}
