package com.bdqn.app.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import com.bdqn.app.R;
import com.bdqn.app.utils.LogUtils;

public class LocalService extends Service {

    private NotificationManager manager;

    public int member = 10;

    public LocalService() {
        LogUtils.e("LocalService Constructor");
    }


    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.e("onCreate");

        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        showNotification();
    }

    private void showNotification() {
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, ServiceSampleActivity.class), PendingIntent.FLAG_CANCEL_CURRENT);

        Notification.Builder  builder = new Notification.Builder(this);
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setTicker("This is a notification");
        builder.setContentTitle("NOTIFICATION");
        builder.setContentText("This is a local Notification");
        builder.setContentIntent(contentIntent);
        Notification notification = builder.getNotification();
        //设置点击通知后，通知消失
        notification.flags = Notification.FLAG_AUTO_CANCEL;

        manager.notify(1,notification);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LogUtils.e("onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtils.e("onDestory");
    }

    @Override
    public IBinder onBind(Intent intent) {
        LogUtils.e("onBind");
        return binder;
    }

    private IBinder binder = new LocalBinder();

    public class LocalBinder extends Binder {
        LocalService getService(){
            return  LocalService.this;
        }
    }

}
