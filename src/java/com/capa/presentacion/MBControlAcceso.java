package com.capa.presentacion;

import com.capa.datos.TMenu;
import com.capa.datos.TUsuario;
import com.capa.datos.VPerfiles;
import com.capa.negocios.VPerfilesFacade;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

@Named(value = "mBControlAcceso")
@SessionScoped
public class MBControlAcceso implements Serializable {

    @EJB
    private VPerfilesFacade servicioPerfiles;

    private TUsuario usuario;
    private TUsuario us;

    private MenuModel menu;

    private List<TMenu> menus;

    public MBControlAcceso() {
    }

    @PostConstruct
    private void init() {

        menu = new DefaultMenuModel();
        accederMenus();
    }

    public void accederMenus() {
        controlarAccesos();

        String url;
        Map<String, DefaultSubMenu> hmMenu = new HashMap<>();

        us = new TUsuario();
        us = (TUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userLogin");
        us.getTuSerial().getTuSerial();

        for (VPerfiles itm : servicioPerfiles.accesos(us)) {
            url = itm.getMenUrl();
            String[] paths = url.split("/");
            String path = "";
            String pathPadre = "";

            for (String label : paths) {
                if (label.length() > 0) {
                    label = label.substring(0, 1).toUpperCase() + label.substring(1);
                    System.out.println("label--->>" + label + "<<<----" + url);
                    path = path + label;

                    if (pathPadre.isEmpty()) {

                        if (!hmMenu.containsKey(path)) {

                            if (path.contains(".xhtml")) {
                                DefaultMenuItem mi = new DefaultMenuItem();
                                mi.setValue(itm.getMenNombre());
                                mi.setUrl(itm.getMenUrl().replace(".xhtml", ".jsf"));
                                mi.setId(path.replace(".xhtml", ""));
                                menu.addElement(mi);
                            } else {
                                DefaultSubMenu submenu = new DefaultSubMenu();
                                submenu.setLabel(label);
                                submenu.setId(path);
                                hmMenu.put(path, submenu);
                                menu.addElement(submenu);
                            }
                        }

                    } else if (hmMenu.containsKey(pathPadre)) {
                        DefaultSubMenu smPadre = hmMenu.get(pathPadre);

                        if (path.contains(".xhtml")) {
                            DefaultMenuItem mi = new DefaultMenuItem();
                            mi.setValue(itm.getMenNombre());
                            mi.setUrl(itm.getMenUrl().replace(".xhtml", ".jsf"));
                            mi.setId(path.replace(".xhtml", ""));
                            smPadre.addElement(mi);

                        } else if (!hmMenu.containsKey(path)) {
                            DefaultSubMenu sm = new DefaultSubMenu();
                            sm.setLabel(label);
                            sm.setId(path);
                            smPadre.addElement(sm);
                            hmMenu.put(path, sm);
                        }
                    }
                    pathPadre = path;
                }
            }
        }
    }

    public void controlarAccesos() {
        try {
            TUsuario userL = (TUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userLogin");
            if (userL == null) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("./login.jsf");
            }
        } catch (Exception e) {
            System.out.println("Error CONTROL DE ACCESO >>>>>>>" + e.getMessage());
        }

    }

    public void cerrarSesion() {
        System.out.println("Cerrar Session");
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
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

    public List<TMenu> getMenus() {
        return menus;
    }

    public void setMenus(List<TMenu> menus) {
        this.menus = menus;
    }

    public MenuModel getMenu() {
        return menu;
    }

    public void setMenu(MenuModel menu) {
        this.menu = menu;
    }

    public TUsuario getUs() {
        return us;
    }

    public void setUs(TUsuario us) {
        this.us = us;
    }

}
