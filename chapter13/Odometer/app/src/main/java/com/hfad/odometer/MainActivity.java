package com.hfad.odometer;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.widget.TextView;

public class MainActivity extends Activity {

    private OdometerService odometer;
    private boolean bound = false;

    private ServiceConnection connection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder binder) {
                OdometerService.OdometerBinder odometerBinder =
                    (OdometerService.OdometerBinder) binder;
                odometer = odometerBinder.getOdometer();
                bound = true;
            }
            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                bound = false;
            }
        };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        watchMileage();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, OdometerService.class);
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (bound) {
            unbindService(connection);
            bound = false;
        }
    }

    private void watchMileage() {
        final TextView distanceView = (TextView)findViewById(R.id.distance);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
                @Override
                public void run() {
                    double distance = 0.0;
                    if (odometer != null) {
                        distance = odometer.getMiles();
                    }
                    String distanceStr = String.format("%1$,.2f miles", distance);
                    distanceView.setText(distanceStr);
                    handler.postDelayed(this, 1000);
                }
            });
    }
}
