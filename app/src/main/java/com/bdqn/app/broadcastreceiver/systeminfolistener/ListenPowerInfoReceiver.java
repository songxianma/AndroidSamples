package com.bdqn.app.broadcastreceiver.systeminfolistener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * 监听电源信息
 */
public class ListenPowerInfoReceiver extends BroadcastReceiver {
    public ListenPowerInfoReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        switch (intent.getAction()) {
            case Intent.ACTION_POWER_CONNECTED://连接电源
                Log.e("监听电源","连接电源");
                Toast.makeText(context, "连接电源", Toast.LENGTH_SHORT).show();
                break;
            case Intent.ACTION_POWER_DISCONNECTED://断开电源
                Log.e("监听电源","断开电源");
                Toast.makeText(context, "断开电源", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
