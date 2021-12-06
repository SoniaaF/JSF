package fr.fs.jsf.metier;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Departement {
    private String code;
    private String nom;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public Departement() {

    }

    public Departement(String code, String nom) {
        this.code = code;
        this.nom = nom;

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    @Override
    public String toString() {
        return nom;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Departement)) return false;
        Departement other = (Departement) object;
        return this.code.equals(other.code);
    }
}
