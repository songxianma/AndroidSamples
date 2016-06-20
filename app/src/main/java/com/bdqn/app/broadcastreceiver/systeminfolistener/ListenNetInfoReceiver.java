package com.bdqn.app.broadcastreceiver.systeminfolistener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class ListenNetInfoReceiver extends BroadcastReceiver {
    public ListenNetInfoReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        switch (intent.getAction()) {
//            case "android.net.conn.CONNECTIVITY_CHANGE":
//                break;
            case ConnectivityManager.CONNECTIVITY_ACTION:
                //获取到连接管理器
                ConnectivityManager manager = (ConnectivityManager)
                        context.getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo info = manager.getActiveNetworkInfo();
                if (null != info) {
                    boolean connected = info.isConnected();
                    NetworkInfo.State state = info.getState();
                    info.getType();
                    Log.e("网络状态", connected ? "网络已连接" : "网络不可用");
                    Log.e("网络状态", state.toString());
                }
                break;
        }
    }
}
