package com.bdqn.app.broadcastreceiver.orderedbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.bdqn.app.broadcastreceiver.BroadcastReceiverSampleActivity;

public class OrderedBroadcastReceiver1 extends BroadcastReceiver {
    public OrderedBroadcastReceiver1() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        switch (intent.getAction()){
            case BroadcastReceiverSampleActivity.ACTION_SEND_ORDERED_BROADCAST:
                Log.e("Receiver1","-----OrderedBroadcastReceiver1---------------");
                break;
        }
    }
}
