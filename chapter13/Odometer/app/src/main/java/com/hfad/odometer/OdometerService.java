package com.hfad.odometer;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;

public class OdometerService extends Service {

    private final IBinder binder = new OdometerBinder();
    private static double distanceInMeters;
    private static Location lastLocation = null;
    private LocationListener listener;
    private LocationManager locManager;

    public class OdometerBinder extends Binder {
        OdometerService getOdometer() {
            return OdometerService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public void onCreate() {
        listener = new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    if (lastLocation == null) {
                        lastLocation = location;
                    }
                    distanceInMeters += location.distanceTo(lastLocation);
                    lastLocation = location;
                }

                @Override
                public void onProviderDisabled(String arg0) {}

                @Override
                public void onProviderEnabled(String arg0) {}

                @Override
                public void onStatusChanged(String arg0, int arg1, Bundle bundle) {}
            };
        locManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, listener);
    }

    @Override
    public void onDestroy() {
        if (locManager != null && listener != null) {
            locManager.removeUpdates(listener);
            locManager = null;
            listener = null;
        }
    }

    public double getMiles() {
        return this.distanceInMeters / 1609.344;
    }
}
