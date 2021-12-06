package fr.fs.jsf.dao;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;


public class GeoAPI {


    private String SERVICE_BASE_URI = "https://geo.api.gouv.fr/";
    private static WebTarget webTarget;


    private GeoAPI() {
        webTarget = ClientBuilder.newClient().target(SERVICE_BASE_URI);
    }

    public Invocation.Builder get(String path) {
        Invocation.Builder invocationBuilder = webTarget.path(path).request(MediaType.APPLICATION_JSON);
        return invocationBuilder;
    }

    public static synchronized WebTarget getInstance() {
        if (webTarget == null)
            new GeoAPI();
        return webTarget;
    }
}