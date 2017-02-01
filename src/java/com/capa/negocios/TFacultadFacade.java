/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capa.negocios;

import com.capa.datos.TFacultad;
import com.capa.datos.TUsuario;
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
public class TFacultadFacade extends AbstractFacade<TFacultad> {

    @PersistenceContext(unitName = "wa-hce-v2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TFacultadFacade() {
        super(TFacultad.class);
    }

    public List<TFacultad> buscarCarreras(TFacultad facultad) {
        Query sql = em.createNamedQuery("TFacultad.findByPadreFacSerial");
        sql.setParameter("padreFacSerial", facultad);
        List<TFacultad> carreras = sql.getResultList();
        System.out.println(carreras.size());
        return carreras;
    }

}
