package com.pawan.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ProximitySensor extends AppCompatActivity {
private SensorManager sensorManager;
private TextView tvProximity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity_sensor);

        tvProximity=findViewById(R.id.tvProximity);
        proximity();
    }

    private void proximity() {
        sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);

        Sensor sensor=sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        SensorEventListener proxyListener=new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                if (event.values[0]<=4)
                {
                    tvProximity.setText("Object is near");
                }
                else if (event.values[0]>4)
                {
                    tvProximity.setText("Object is far");
                }
                else
                {
                    tvProximity.setText("No sensor found");
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };

            sensorManager.registerListener(proxyListener,sensor,SensorManager.SENSOR_DELAY_NORMAL);


    }
    }
