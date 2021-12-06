package fr.fs.jsf.dao;


import fr.fs.jsf.metier.Couleur;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class CouleurDAO extends DAO<Couleur> {


    public CouleurDAO(WebTarget webTarget) {
        super(webTarget);
    }

    @Override
    public void getByID(Couleur object) {

    }

    public ArrayList<Couleur> getAll() {
        ArrayList<Couleur> liste = new ArrayList<>();
        String json = webTarget.path("couleurs").request(MediaType.APPLICATION_JSON).get().readEntity(String.class);
        try {
            liste.addAll(Arrays.asList(objectMapper.readValue(json, Couleur[].class)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return liste;
    }




}