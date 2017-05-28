package com.app.master.notificaciones;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Toast;

import com.app.master.notificaciones.RestApi.AdaptadorRetrofit;
import com.app.master.notificaciones.RestApi.Endpoind;
import com.app.master.notificaciones.RestApi.ModeloRespuesta;
import com.google.firebase.iid.FirebaseInstanceId;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void notificaciones(View v){
        String token= FirebaseInstanceId.getInstance().getToken();
        enviarTokenRegistro(token);

    }
    private void enviarTokenRegistro(String token){
        AdaptadorRetrofit adaptadorRetrofit=new AdaptadorRetrofit();
        Endpoind endpoind=adaptadorRetrofit.establecerConexionRestApi();
        Call<ModeloRespuesta> usuarioToken=endpoind.registrarToken(token);
        usuarioToken.enqueue(new Callback<ModeloRespuesta>() {
            @Override
            public void onResponse(Call<ModeloRespuesta> call, Response<ModeloRespuesta> response) {
                Toast.makeText(MainActivity.this, "Token enviado", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ModeloRespuesta> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error al enciar token", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
