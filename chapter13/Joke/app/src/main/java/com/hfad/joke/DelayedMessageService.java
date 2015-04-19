package com.hfad.joke;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
// import android.util.Log; // Used in log version
// import android.os.Handler; // Used in Toast version
// import android.widget.Toast; // Used in Toast version

public class DelayedMessageService extends IntentService {

    public static final String EXTRA_MESSAGE = "message";
    // private Handler handler; // Used in Toast version
    public static final int NOTIFICATION_ID = 5453;
    
    public DelayedMessageService() {
        super("DelayedMessageService");
    }

    // @Override // Used in Toast version
    // public int onStartCommand(Intent intent, int flags, int startId) {
    //     handler = new Handler();
    //     return super.onStartCommand(intent, flags, startId);
    // }

    @Override
    protected void onHandleIntent(Intent intent) {
        synchronized (this) {
            try {
                wait(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String text = intent.getStringExtra(EXTRA_MESSAGE);
        showText(text);
    }

    private void showText(final String text) {
        // Log.v("DelayedMessageService", "The message is: " + text); // Used in log version
        // handler.post(new Runnable() { // Used in Toast version
        //         @Override
        //         public void run() {
        //             Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
        //         }
        //     });
        Intent intent = new Intent(this, MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent =
            stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        Notification notification = new Notification.Builder(this)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle(getString(R.string.app_name))
            .setAutoCancel(true)
            .setPriority(Notification.PRIORITY_MAX)
            .setDefaults(Notification.DEFAULT_VIBRATE)
            .setContentIntent(pendingIntent)
            .setContentText(text)
            .build();
        NotificationManager notificationManager =
            (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID, notification);
    }
}
