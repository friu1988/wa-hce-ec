/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capa.negocios;

import com.capa.datos.TUsuario;
import com.capa.datos.VPerfiles;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author FREDDY
 */
@Stateless
public class VPerfilesFacade extends AbstractFacade<VPerfiles> {

    @PersistenceContext(unitName = "wa-hce-v2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VPerfilesFacade() {
        super(VPerfiles.class);
    }

    public List<VPerfiles> accesos(TUsuario rol) {
        Query sql = em.createNamedQuery("VPerfiles.findByTuSerial");
        sql.setParameter("tuSerial", rol.getTuSerial().getTuSerial());
        List<VPerfiles> menus = sql.getResultList();
        return menus;
    }
}
