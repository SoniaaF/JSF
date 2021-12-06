package fr.fs.jsf.bean;


import fr.fs.jsf.metier.Departement;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

@FacesConverter(value = "departementConverter", managed = true)
public class DepartementConverter implements Converter {

    @Inject
    private MyBean myBean;

    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {

        Departement departement = new Departement(value, "");

        return myBean.getAllDepartements().get(myBean.getAllDepartements().indexOf(departement));
    }

    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        Departement departement = (Departement) object;
        return departement.getCode();
    }
}