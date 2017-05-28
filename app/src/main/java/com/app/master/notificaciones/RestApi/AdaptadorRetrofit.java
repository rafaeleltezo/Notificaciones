package com.app.master.notificaciones.RestApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rafael p on 28/5/2017.
 */

public class AdaptadorRetrofit {
    public Endpoind establecerConexionRestApi(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(Endpoind.class);
    }
}
