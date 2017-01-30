/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capa.negocios;

import com.capa.datos.THistoriaClinicaUnica;
import com.capa.datos.VPerfiles;
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
public class THistoriaClinicaUnicaFacade extends AbstractFacade<THistoriaClinicaUnica> {

    @PersistenceContext(unitName = "wa-hce-v2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public THistoriaClinicaUnicaFacade() {
        super(THistoriaClinicaUnica.class);
    }

    public String buscarMaxHCU() {
        Query sql = em.createNativeQuery("SELECT  MAX(hcl_serial) FROM t_historia_clinica_unica;");
        String numero = (String) sql.getSingleResult();
        return numero;
    }

}
