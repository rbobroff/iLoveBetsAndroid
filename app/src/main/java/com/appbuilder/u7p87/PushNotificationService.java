package com.appbuilder.u7p87;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class PushNotificationService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        String title = remoteMessage.getNotification().getTitle();
        String text = remoteMessage.getNotification().getBody();
        final String CHANNEL_ID = "HEADS_UP_NOTIFICATION";
        NotificationChannel channel = null;

        //этот функционал рассчитан на api выше 26 и android 8
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            channel = new NotificationChannel(
                    CHANNEL_ID,
                     "Heads Up Notification",
                    NotificationManager.IMPORTANCE_HIGH
            );

        getSystemService(NotificationManager.class).createNotificationChannel(channel);
            Notification.Builder notification = new Notification.Builder(this, CHANNEL_ID)
                    .setContentTitle(title)
                    .setContentText(text)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setAutoCancel(true);
            NotificationManagerCompat.from(this).notify(1, notification.build());
        super.onMessageReceived(remoteMessage);


    } //конец условия поддержки API 26 и выше

    }


} //конец класса
