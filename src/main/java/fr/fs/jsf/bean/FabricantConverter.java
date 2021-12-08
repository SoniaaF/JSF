package fr.fs.jsf.bean;

import fr.fs.jsf.metier.Fabricant;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

@FacesConverter(value = "fabricantConverter", managed = true)
public class FabricantConverter implements Converter {

    @Inject
    private MyBean myBean;

    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {

        if (value != null && value.trim().length() > 0) {
            for (Fabricant fabricant : myBean.getFabricantList()) {
                if (fabricant.getId() == Integer.parseInt(value)) {
                    return fabricant;
                }
            }
        }
        return null;
    }

    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        Fabricant fabricant = (Fabricant) object;
        return String.valueOf(fabricant.getId());
    }

}
