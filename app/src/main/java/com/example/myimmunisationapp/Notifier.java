package com.example.myimmunisationapp;

import android.app.Activity;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.view.View;
import android.widget.EditText;
import static com.example.myimmunisationapp.Notification.CHANNEL_1_ID;
import static com.example.myimmunisationapp.Notification.CHANNEL_2_ID;

public class Notifier extends Activity {

    private NotificationManagerCompat notificationManager;
    private EditText editTextTitle;
    private EditText editTextmessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);


        notificationManager = NotificationManagerCompat.from(this);

        editTextTitle = findViewById(R.id.edit_text_title);
        editTextmessage = findViewById(R.id.edit_text_message);
    }

    public void sendOnChannel1(View v){
        String title = editTextTitle.getText().toString();
        String message = editTextmessage.getText().toString();

        Uri sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        android.app.Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_alert)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setSound(sound)
                .build();
        notificationManager.notify(1, notification);

    }


    public void sendOnChannel2(View view) {
        String title = editTextTitle.getText().toString();
        String message = editTextmessage.getText().toString();
        android.app.Notification notification = new NotificationCompat.Builder(this, CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setVibrate(new long[]{1000,1000,1000,100,1000})
                .build();
        notificationManager.notify(2, notification);

    }
}

