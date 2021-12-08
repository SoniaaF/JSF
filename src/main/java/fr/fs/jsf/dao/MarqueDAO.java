package fr.fs.jsf.dao;

import fr.fs.jsf.metier.Marque;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class MarqueDAO extends DAO<Marque> {

    public MarqueDAO(WebTarget webTarget) { super((webTarget)); }

    @Override
    public void getByID(Marque object) {

    }

    public ArrayList<Marque> getAll() {
        ArrayList<Marque> liste = new ArrayList<>();
        String json = webTarget.path("marques").request(MediaType.APPLICATION_JSON).get().readEntity(String.class);
        try {
            liste.addAll(Arrays.asList(objectMapper.readValue(json, Marque[].class)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return liste;
    }

}
