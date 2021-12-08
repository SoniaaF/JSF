package fr.fs.jsf.bean;

import fr.fs.jsf.dao.DaoFactory;
import fr.fs.jsf.metier.*;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("myBean")
@SessionScoped
public class MyBean implements Serializable {

    private List<Couleur> couleurList;
    private Couleur couleurSelected;
    private List<Type> typeList;
    private Type typeSelected;
    private List<Marque> marqueList;
    private Marque marqueSelected;
    private List<Fabricant> fabricantList;
    private Fabricant fabricantSelected;
    private List<Region> regionList;
    private Region regionSelected;
    private List<Departement> allDepartements;
    private Departement departementSelected;
    private List<Departement> departementList;

    @PostConstruct
    private void init() {
        couleurList = new ArrayList<>(DaoFactory.getCouleurDAO().getAll());
        typeList = new ArrayList<>(DaoFactory.getTypeDAO().getAll());
        marqueList = new ArrayList<>(DaoFactory.getMarqueDAO().getAll());
        fabricantList = new ArrayList<>(DaoFactory.getFabricantDAO().getAll());
        regionList = new ArrayList<>(DaoFactory.getRegionDAO().getAll());
        regionList.add(0, new Region("X", "Choisir une Région"));
        allDepartements = new ArrayList<>(DaoFactory.getDepartementDao().getAll());
        allDepartements.add(0, new Departement("X", "Choisir un Département"));
        departementList = new ArrayList<>(allDepartements);
    }

    public List<Couleur> getCouleursList() {
        return couleurList;
    }

    public Couleur getCouleurSelected() {
        return couleurSelected;
    }

    public void setCouleurSelected(Couleur couleurSelected) {
        this.couleurSelected = couleurSelected;
    }

    public List<Type> getTypeList() { return typeList; }

    public Type getTypeSelected() { return typeSelected; }

    public void setTypeSelected(Type typeSelected) { this.typeSelected = typeSelected; }

    public List<Marque> getMarqueList() { return marqueList; }

    public Marque getMarqueSelected() { return marqueSelected; }

    public void setMarqueSelected(Marque marqueSelected) { this.marqueSelected = marqueSelected; }

    public List<Fabricant> getFabricantList() { return fabricantList; }

    public Fabricant getFabricantSelected() { return fabricantSelected; }

    public void setFabricantSelected(Fabricant fabricantSelected) { this.fabricantSelected = fabricantSelected; }

    public List<Region> getRegionList() {
        return regionList;
    }

    public Region getRegionSelected() {
        return regionSelected;
    }

    public void setRegionSelected(Region regionSelected) {
        this.regionSelected = regionSelected;
    }

    public List<Departement> getAllDepartements() {
        return allDepartements;
    }

    public Departement getDepartementSelected() {
        return departementSelected;
    }

    public void setDepartementSelected(Departement departementSelected) {
        this.departementSelected = departementSelected;
    }

    public List<Departement> getDepartementList() {
        return departementList;
    }

    public void onRegionChange() {
        if (regionSelected.getCode().equals("X")) {
            departementList = new ArrayList<>(allDepartements);
        } else {
            departementList = new ArrayList<>(DaoFactory.getDepartementDao().getByRegion(regionSelected));
            departementList.add(0, new Departement("X", "Choisir un Département"));
        }
    }

    public String valider() {
        if (!departementSelected.getCode().equals("X"))
            return "suite";
        else
            return "";
    }
}
