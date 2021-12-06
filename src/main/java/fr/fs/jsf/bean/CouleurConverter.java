package fr.fs.jsf.bean;


import fr.fs.jsf.metier.Couleur;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

@FacesConverter(value = "couleurConverter", managed = true)
public class CouleurConverter implements Converter {

    @Inject
    private MyBean myBean;

    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {

        if (value != null && value.trim().length() > 0) {
            for (Couleur couleur : myBean.getCouleursList()) {
                if (couleur.getId() == Integer.parseInt(value))
                {
                    return couleur;
                }
            }
        }
        return null;
    }

    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        Couleur couleur = (Couleur) object;
        return String.valueOf(couleur.getId());
    }
}