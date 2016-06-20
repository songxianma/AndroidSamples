package com.bdqn.app.broadcastreceiver.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.bdqn.app.broadcastreceiver.BroadcastReceiverSampleActivity;

/**
 * 在清单文件中注册广播接收者，是不会创建它的，只会系统中有个标记。
 */
public class MyReceiver extends BroadcastReceiver {
    public static final String TAG = MyReceiver.class.getSimpleName();

    public MyReceiver() {
        Log.e(TAG, "My Receiver Constructor");
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        switch (action) {
            case BroadcastReceiverSampleActivity.ACTION_SEND_BROADCAST:
                Log.e(TAG,"---------"+TAG+"---------");
                break;
        }
    }
}
