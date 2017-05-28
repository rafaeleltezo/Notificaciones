package com.app.master.notificaciones.RestApi;

/**
 * Created by Rafael p on 28/5/2017.
 */

public class ModeloRespuesta {
    private String id;
    private String token;

    public ModeloRespuesta() {
    }

    public ModeloRespuesta(String id, String token) {
        this.id = id;
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
