package com.bdqn.app.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.bdqn.app.R;
import com.bdqn.app.broadcastreceiver.sticky.OneActivity;

public class BroadcastReceiverSampleActivity extends AppCompatActivity {

    public static final String TAG = BroadcastReceiverSampleActivity.class.getSimpleName();

    //Action 起名：包名+功能名
    public static final String ACTION_SEND_BROADCAST = "com.bdqn.sample.send_broadcast";
    public static final String ACTION_SEND_CUSTOM_BROADCAST = "com.bdqn.sample.send_custom_broadcast";


    // 有序广播的Action
    public static final String ACTION_SEND_ORDERED_BROADCAST = "com.bdqn.sample.send_ordered_broadcast";
    public static final String ACTION_SEND_ORDERED_CUSTOM_BROADCAST = "com.bdqn.sample.send_ordered_custom_broadcast";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_receiver_sample);

        IntentFilter filter = new IntentFilter();
//        filter.addAction(ACTION_SEND_BROADCAST);
        filter.addAction(ACTION_SEND_ORDERED_CUSTOM_BROADCAST);
        filter.setPriority(123);
        //注册广播
        registerReceiver(mReceiver, filter);
    }

    /**
     * 发送普通广播
     *
     * @param view
     */
    public void send(View view) {
        Intent intent = new Intent();
        intent.setAction(ACTION_SEND_BROADCAST);

        sendBroadcast(intent);
    }

    /**
     * 发送粘性广播
     *
     * @param view
     */
    public void sendSticky(View view) {
        startActivity(new Intent(this, OneActivity.class));
    }

    /**
     * 发送有序广播
     *
     * @param view
     */
    public void sendOrdered(View view) {
        Intent intent = new Intent();
//        intent.setAction(ACTION_SEND_ORDERED_BROADCAST);
        intent.setAction(ACTION_SEND_ORDERED_CUSTOM_BROADCAST);
//        sendBroadcast(intent);

        sendOrderedBroadcast(intent, null

        );
    }


    BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()) {
                case ACTION_SEND_BROADCAST:
                    Log.e(TAG, "-------mReceiver---------");
                    break;
                case ACTION_SEND_ORDERED_CUSTOM_BROADCAST:
                    Log.e(TAG, "-------mReceiver------ ACTION_SEND_ORDERED_CUSTOM_BROADCAST---");
                    break;
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mReceiver);
    }
}

