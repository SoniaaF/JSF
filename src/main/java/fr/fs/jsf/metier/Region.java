package fr.fs.jsf.metier;

public class Region {
    private String code;
    private String nom;


    public Region() {

    }

    public Region(String code, String nom) {
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
        if (!(object instanceof Region)) return false;
        Region other = (Region) object;
        return this.code.equals(other.code);
    }
}
