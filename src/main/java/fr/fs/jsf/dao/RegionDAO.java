package fr.fs.jsf.dao;


import fr.fs.jsf.metier.Region;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

public class RegionDAO extends DAO<Region> {


    public RegionDAO(WebTarget webTarget) {
        super(webTarget);


    }

    @Override
    public void getByID(Region object) {

    }


    public ArrayList<Region> getAll() {
        ArrayList<Region> liste = new ArrayList<>();
        Response response = webTarget.path("regions").request(MediaType.APPLICATION_JSON).get();
        liste.addAll(response.readEntity(new GenericType<List<Region>>() {
        }));
        return liste;
    }



}