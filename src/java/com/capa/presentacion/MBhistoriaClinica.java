package com.capa.presentacion;

import com.capa.datos.TAdmisionista;
import com.capa.datos.TFacultad;
import com.capa.datos.THistoriaClinicaUnica;
import com.capa.datos.TKardex;
import com.capa.datos.TLugarGeografico;
import com.capa.datos.TPaciente;
import com.capa.datos.TUsuario;
import com.capa.negocios.TFacultadFacade;
import com.capa.negocios.THistoriaClinicaUnicaFacade;
import com.capa.negocios.TPacienteFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 *
 * @author FREDDY
 */
@Named(value = "mBhistoriaClinica")
@SessionScoped
public class MBhistoriaClinica implements Serializable {

    private TLugarGeografico lugarGeografico;
    private TPaciente paciente;
    private THistoriaClinicaUnica historiaClinica;
    private TAdmisionista admisionista;
    private TKardex kardex;

    private List<TFacultad> facultades;

    private String numeroHCU;
    @EJB
    private THistoriaClinicaUnicaFacade servicioHCU;
    @EJB
    private TPacienteFacade servicioPaciente;
    @EJB
    private TFacultadFacade servicioFacultad;

    public MBhistoriaClinica() {

    }

    @PostConstruct
    public void init() {
        numeroHCU = servicioHCU.buscarMaxHCU();
    }

    public void crearHCU() {
        //Personal Admision
        TUsuario user = (TUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userLogin");
        admisionista.setPerSerial(user.getPerSerial().getPerSerial());

        //Paciente 
        paciente.setPacCedula(crearPaciente());

        //HCU
        historiaClinica.setPerSerial(admisionista);

//        historiaClinica.setHclNumeroHistoria(servicioHCU.buscarMaxHCU());
        historiaClinica.setHclInstitucion("UCE");
        historiaClinica.setHclUnidadOperativa("Archivo");
        historiaClinica.setHclCodigoOu("OU");
//        historiaClinica.setHclTipoPaciente(historiaClinica.getHclTipoPaciente());

//historiaClinica.setHclInstitucion(hclInstitucion.);
    }

    public String crearPaciente() {
        servicioPaciente.create(paciente);
        TPaciente pac = servicioPaciente.find(this);
        String cedula = pac.getPacCedula();
        return cedula;
    }

//    public String asignarNumeroHCU() {
//        servicioHCU.buscarMaxHCU();
//
//        String numeroHCU = "";// = servicioHCU;
//        return numeroHCU;
//    }
    public TLugarGeografico getLugarGeografico() {
        if (lugarGeografico == null) {
            lugarGeografico = new TLugarGeografico();
        }
        return lugarGeografico;
    }

    public void setLugarGeografico(TLugarGeografico lugarGeografico) {
        this.lugarGeografico = lugarGeografico;
    }

    public TPaciente getPaciente() {
        if (paciente == null) {
            paciente = new TPaciente();
        }
        return paciente;
    }

    public void setPaciente(TPaciente paciente) {
        this.paciente = paciente;
    }

    public THistoriaClinicaUnica getHistoriaClinica() {
        if (historiaClinica == null) {
            historiaClinica = new THistoriaClinicaUnica();
        }
        return historiaClinica;
    }

    public void setHistoriaClinica(THistoriaClinicaUnica historiaClinica) {
        this.historiaClinica = historiaClinica;
    }

    public TAdmisionista getAdmisionista() {
        if (admisionista == null) {
            admisionista = new TAdmisionista();
        }
        return admisionista;
    }

    public void setAdmisionista(TAdmisionista admisionista) {
        this.admisionista = admisionista;
    }

    public TKardex getKardex() {
        if (kardex == null) {
            kardex = new TKardex();
        }
        return kardex;
    }

    public void setKardex(TKardex kardex) {
        this.kardex = kardex;
    }

    public String getNumeroHCU() {
        return numeroHCU;
    }

    public void setNumeroHCU(String numeroHCU) {
        this.numeroHCU = numeroHCU;
    }

    public List<TFacultad> getFacultades() {
        if (facultades == null) {
            facultades = servicioFacultad.findAll();
        }
        return facultades;
    }

    public void setFacultades(List<TFacultad> facultades) {
        this.facultades = facultades;
    }

}
