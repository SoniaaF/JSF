package fr.fs.jsf.dao;

import fr.fs.jsf.metier.Fabricant;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FabricantDAO extends DAO<Fabricant> {

    public FabricantDAO(WebTarget webTarget) { super(webTarget); }

    @Override
    public void getByID(Fabricant object) {

    }

    public ArrayList<Fabricant> getAll() {
        ArrayList<Fabricant> liste = new ArrayList<>();
        String json = webTarget.path("fabricants").request(MediaType.APPLICATION_JSON).get().readEntity(String.class);
        try {
            liste.addAll(Arrays.asList(objectMapper.readValue(json, Fabricant[].class)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return liste;
    }

}
