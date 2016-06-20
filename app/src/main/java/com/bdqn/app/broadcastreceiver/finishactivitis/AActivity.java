package com.bdqn.app.broadcastreceiver.finishactivitis;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.bdqn.app.R;


public class AActivity extends AppCompatActivity {

    public static final String ACTION_KILL_A_B = "com.bdqn.sample.kill_a_b";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        IntentFilter filter = new IntentFilter();
        filter.addAction(ACTION_KILL_A_B);
        registerReceiver(mReceiver,filter);
    }

    public void jump2B(View view){
        startActivity(new Intent(this,BActivity.class));
    }

    BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()){
                case ACTION_KILL_A_B:
                    String value = intent.getStringExtra("key");
                    finish();
                    break;
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("AAAAAAA","onDestroy");
        unregisterReceiver(mReceiver);
    }
}
