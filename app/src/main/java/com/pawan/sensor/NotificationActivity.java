package com.pawan.sensor;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.pawan.sensor.createChannel.BroadcastReciever;
import com.pawan.sensor.createChannel.CreateChannel;

public class NotificationActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManagerCompat;
    private Button btnNoti1, btnNoti2;
    private int count = 0;
    BroadcastReceiver broadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        broadcast = new BroadcastReciever();
        notificationManagerCompat = NotificationManagerCompat.from(this);
        CreateChannel channel = new CreateChannel(this);
        channel.createChannel();
        btnNoti1 = findViewById(R.id.notification1);
        btnNoti2 = findViewById(R.id.notification2);

        btnNoti1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNotification("Message 1", "Body 1");
            }
        });

        btnNoti2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNotification2("Message 2", "Body 2");

            }
        });


    }

    private void displayNotification(String message, String body) {
        Notification notification = new NotificationCompat.Builder(this, CreateChannel.CHANNEL_1)
                .setSmallIcon(R.drawable.ic_pan_tool_black_24dp)
                .setContentTitle(count++ + message)
                .setContentText(count++ + body)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManagerCompat.notify(count++, notification);
    }

    private void displayNotification2(String message, String body) {
        Notification notification = new NotificationCompat.Builder(this, CreateChannel.CHANNEL_1)
                .setSmallIcon(R.drawable.ic_pan_tool_black_24dp)
                .setContentTitle(count++ + message)
                .setContentText(count++ + body)
                .setCategory(NotificationCompat.CATEGORY_ALARM)
                .build();

        notificationManagerCompat.notify(count++, notification);

    }

    @Override
    protected void onStart() {
        super.onStart();

        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(broadcast, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadcast);

    }
}
