package com.app.master.notificaciones;

import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by Rafael p on 24/5/2017.
 */

public class TokenFirebaseApp extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        //super.onTokenRefresh();
        String token=FirebaseInstanceId.getInstance().getToken();
        Toast.makeText(this, "El token es: "+token, Toast.LENGTH_SHORT).show();
        enviarToken(token);
    }

    public void enviarToken(String token){

    }
}
