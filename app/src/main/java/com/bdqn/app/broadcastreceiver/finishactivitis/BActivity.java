package com.bdqn.app.broadcastreceiver.finishactivitis;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.bdqn.app.R;


public class BActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
    }

    public void killAAndB(View view) {
        Intent intent = new Intent(AActivity.ACTION_KILL_A_B);
        intent.putExtra("key","value");
        sendBroadcast(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("BBBBBBBB","onDestroy");
    }
}
