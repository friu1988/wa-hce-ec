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

/**
 *
 * @author FREDDY
 */
@Embeddable
public class THorarioPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "per_serial", nullable = false)
    private int perSerial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "d_serial", nullable = false)
    private int dSerial;

    public THorarioPK() {
    }

    public THorarioPK(int perSerial, int dSerial) {
        this.perSerial = perSerial;
        this.dSerial = dSerial;
    }

    public int getPerSerial() {
        return perSerial;
    }

    public void setPerSerial(int perSerial) {
        this.perSerial = perSerial;
    }

    public int getDSerial() {
        return dSerial;
    }

    public void setDSerial(int dSerial) {
        this.dSerial = dSerial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) perSerial;
        hash += (int) dSerial;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof THorarioPK)) {
            return false;
        }
        THorarioPK other = (THorarioPK) object;
        if (this.perSerial != other.perSerial) {
            return false;
        }
        if (this.dSerial != other.dSerial) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.capa.datos.THorarioPK[ perSerial=" + perSerial + ", dSerial=" + dSerial + " ]";
    }
    
}
