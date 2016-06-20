package com.bdqn.app.broadcastreceiver.sticky;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.bdqn.app.R;


public class TwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        IntentFilter filter = new IntentFilter();
        filter.addAction(OneActivity.ACTION_STICKY_BROADCAST);

        registerReceiver(mReceiver,filter);

    }

    BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()){
                case OneActivity.ACTION_STICKY_BROADCAST:

                    Log.e("TwoActivity","广播来了");
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
