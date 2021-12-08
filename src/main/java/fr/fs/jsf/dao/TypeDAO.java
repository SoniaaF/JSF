package fr.fs.jsf.dao;

import fr.fs.jsf.metier.Type;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class TypeDAO extends DAO<Type> {

    public TypeDAO(WebTarget webTarget) { super(webTarget); }

    @Override
    public void getByID(Type object) {

    }

    public ArrayList<Type> getAll() {
        ArrayList<Type> liste = new ArrayList<>();
        String json = webTarget.path("types").request(MediaType.APPLICATION_JSON).get().readEntity(String.class);
        try {
            liste.addAll(Arrays.asList(objectMapper.readValue(json, Type[].class)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return liste;
    }

}
