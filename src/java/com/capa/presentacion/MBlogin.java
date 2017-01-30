package com.capa.presentacion;

import com.capa.datos.TUsuario;
import com.capa.negocios.TUsuarioFacade;
import java.io.IOException;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "mBlogin")
@SessionScoped
public class MBlogin implements Serializable {

    private TUsuario usuario;
    @EJB
    private TUsuarioFacade servicio;

    public MBlogin() {
    }

    public void login() throws IOException {

        TUsuario usDB = servicio.buscar(usuario);
        if (usDB.equals(usuario)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Existe este User: " + usuario.getUNick(), null));
            if (usDB.getUEstado()) {
                String op = usDB.getTuSerial().getTuSerial();
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userLogin", usDB);
                switch (op) {
                    case "A":
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cuenta Administrador", null));
                        FacesContext.getCurrentInstance().getExternalContext().redirect("./bienvenida.jsf");
                        break;
                    case "D":
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cuenta Admisionista", null));
                        FacesContext.getCurrentInstance().getExternalContext().redirect("./bienvenida.jsf");
                        break;
                    case "M":
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cuenta Médicos!", null));
                        FacesContext.getCurrentInstance().getExternalContext().redirect("./bienvenida.jsf");
                        break;
                    default:
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en el APP", null));
                        break;
                }
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cuenta Desactivada!", null));
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario o Clave INCORRECTA", null));
        }

    }

    public TUsuario getUsuario() {
        if (usuario == null) {
            usuario = new TUsuario();
        }
        return usuario;
    }

    public void setUsuario(TUsuario usuario) {

        this.usuario = usuario;
    }

}
