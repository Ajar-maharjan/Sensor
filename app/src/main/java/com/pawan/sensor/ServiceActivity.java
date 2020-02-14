package com.pawan.sensor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.pawan.sensor.service.myService;

public class ServiceActivity extends AppCompatActivity {

    Button btnOne, btnTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        btnOne = findViewById(R.id.button123);
        btnTwo = findViewById(R.id.button212);
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMyService();
            }

        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopMyService();
            }
        });
    }

    private void startMyService() {
        startService(new Intent(this, myService.class));
    }

    private void stopMyService() {
        startService(new Intent(this, myService.class));
    }
}
