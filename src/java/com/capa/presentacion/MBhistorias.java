package com.capa.presentacion;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author FREDDY
 */
@Named(value = "mBhistorias")
@SessionScoped
public class MBhistorias implements Serializable {

    public MBhistorias() {
    }

    public String crearHistoria() {
        System.out.println("Crear>>>>>>>>>>>>>");
        return "historia_crear.xhtml";
    }

    public String verHistoria() {
        System.out.println("Ver>>>>>>>>>>>>>");
        return "historia_ver.xhtml";
    }

    public String editarHistoria() {
        System.out.println("Editar>>>>>>>>>>>>>");
        return "historia_editar.xhtml";
    }

}
