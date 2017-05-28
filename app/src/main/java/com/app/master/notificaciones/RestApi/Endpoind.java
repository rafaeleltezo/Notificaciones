package com.app.master.notificaciones.RestApi;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Rafael p on 28/5/2017.
 */

public interface Endpoind {

    @FormUrlEncoded
    @POST(ConstantesRestApi.KEY_POST_ID_TOKEN)
    Call<ModeloRespuesta>registrarToken(@Field("token")String token);
}
