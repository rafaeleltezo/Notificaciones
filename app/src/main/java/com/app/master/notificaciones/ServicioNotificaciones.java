package com.app.master.notificaciones;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by Rafael p on 24/5/2017.
 */

public class ServicioNotificaciones extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
       // super.onMessageReceived(remoteMessage);
        Intent i=new Intent(this,MainActivity.class);
        Uri uri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,1,i,PendingIntent.FLAG_ONE_SHOT);
        NotificationCompat.Builder notificationCompat=new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.christmas_star_48)
                .setContentTitle("notificacion")
                .setContentText(remoteMessage.getNotification().getBody())
                .setSound(uri)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);
        NotificationManager notification=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notification.notify(2,notificationCompat.build());
    }
}
