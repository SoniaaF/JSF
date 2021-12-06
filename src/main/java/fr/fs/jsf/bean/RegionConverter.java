package fr.fs.jsf.bean;


import fr.fs.jsf.metier.Region;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;


/**
 * Created by François on 30/03/2017.
 */
@FacesConverter(value = "regionConverter", managed = true)
public class RegionConverter implements Converter {

    @Inject
    private MyBean myBean;

    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {

        Region region = new Region(value, "");

        return myBean.getRegionList().get(myBean.getRegionList().indexOf(region));
    }

    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
            Region region = (Region) object;
           return region.getCode();
    }
}