package fr.fs.jsf.bean;

import fr.fs.jsf.metier.Type;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

@FacesConverter(value = "typeConverter", managed = true)
public class TypeConverter implements Converter {

    @Inject
    private MyBean myBean;

    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {

        if (value != null && value.trim().length() > 0) {
            for (Type type : myBean.getTypeList()) {
                if (type.getId() == Integer.parseInt(value)) {
                    return type;
                }
            }
        }
        return null;
    }

    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        Type type = (Type) object;
        return String.valueOf(type.getId());
    }

}
