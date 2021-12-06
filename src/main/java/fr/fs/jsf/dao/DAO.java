package fr.fs.jsf.dao;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.client.WebTarget;
import java.io.IOException;
import java.util.ArrayList;


public abstract class DAO<T> {
    WebTarget webTarget;
    ObjectMapper objectMapper;
    public DAO(WebTarget webTarget) {
        this.webTarget = webTarget;
        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public abstract void getByID(T object);

    public abstract ArrayList<T> getAll() throws IOException;


}
