package com.pawan.sensor.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class myService extends Service {
    public Context context = this;
    public Handler handler = null;
    public Runnable runnable = null;


    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "Service created!", Toast.LENGTH_SHORT).show();

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                double randomNo = getRandomDouble(1, 200);
                Toast.makeText(context, "Random number = " + randomNo, Toast.LENGTH_SHORT).show();
                handler.postDelayed(runnable, 2000);
            }
        };
        handler.postDelayed(runnable, 2000);
    }

    public static double getRandomDouble(double min, double max) {
        return (Math.random() * ((max - min) + 1) + min);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
        Toast.makeText(context, "Service Stopped", Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
