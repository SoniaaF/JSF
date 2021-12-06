package fr.fs.jsf.dao;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;


public class SdbmAPI {


    private String SERVICE_BASE_URI = "http://localhost:8085/";
    private static WebTarget webTarget;


    private SdbmAPI() {
        webTarget = ClientBuilder.newClient().target(SERVICE_BASE_URI);
    }

    public Invocation.Builder get(String path) {
        Invocation.Builder invocationBuilder = webTarget.path(path).request(MediaType.APPLICATION_JSON);
        return invocationBuilder;
    }

    public static synchronized WebTarget getInstance() {
        if (webTarget == null)
            new SdbmAPI();
        return webTarget;
    }
}