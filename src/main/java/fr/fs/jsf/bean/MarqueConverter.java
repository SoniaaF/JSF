package fr.fs.jsf.bean;

import fr.fs.jsf.metier.Marque;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

@FacesConverter(value = "marqueConverter", managed = true)
public class MarqueConverter implements Converter {

    @Inject
    private MyBean myBean;

    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {

        if (value != null && value.trim().length() > 0) {
            for (Marque marque : myBean.getMarqueList()) {
                if (marque.getId() == Integer.parseInt(value)) {
                    return marque;
                }
            }
        }
        return null;
    }

    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        Marque marque = (Marque) object;
        return String.valueOf(marque.getId());
    }

}
