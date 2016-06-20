package com.bdqn.app.broadcastreceiver.orderedbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.bdqn.app.broadcastreceiver.BroadcastReceiverSampleActivity;

public class OrderedBroadcastReceiver extends BroadcastReceiver {
    public OrderedBroadcastReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        switch (intent.getAction()){
            case BroadcastReceiverSampleActivity.ACTION_SEND_ORDERED_CUSTOM_BROADCAST:
                Log.e("Receiver","-----OrderedBroadcastReceiver---------------");
                break;
        }
    }
}
