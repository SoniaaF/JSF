package fr.fs.jsf.metier;

public class Type {
    private int id;
    private String nom;

    private Type() {

    }

    public Type(Integer id, String libelle) {
        this.id = id;
        this.nom = libelle;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) { this.id = id; }

    public String getNom() { return nom; }

    @Override
    public String toString() { return nom; }
}
