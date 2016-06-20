package com.bdqn.app.broadcastreceiver.sticky;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bdqn.app.R;


public class OneActivity extends AppCompatActivity {

    public static final String ACTION_STICKY_BROADCAST = "action_sticky_broadcast";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
    }
    public void sendStickyBroadcast(View view){
        Intent intent = new Intent(ACTION_STICKY_BROADCAST);
//        sendBroadcast(intent);
        sendStickyBroadcast(intent);
    }


    public void jump2Two(View view){
        Intent intent = new Intent(this,TwoActivity.class);
        startActivity(intent);
    }


}
