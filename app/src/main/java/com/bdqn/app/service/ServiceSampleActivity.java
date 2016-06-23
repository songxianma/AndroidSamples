package com.bdqn.app.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bdqn.app.R;
import com.bdqn.app.utils.LogUtils;

public class ServiceSampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_sample);
    }


    public void start(View view) {
        Intent intent = new Intent(this, LocalService.class);
        startService(intent);
    }

    public void stop(View view) {
        Intent intent = new Intent(this, LocalService.class);
        stopService(intent);
    }

    private boolean isBind = false;

    public void bind(View view) {
        Intent intent = new Intent(this, LocalService.class);
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);
        isBind = true;
    }

    public void unbind(View view) {
        unbindService();
    }

    private void unbindService() {
        if (isBind) {
            unbindService(serviceConnection);
            isBind = false;
        }
    }

    LocalService localService = null;
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            LocalService.LocalBinder binder = (LocalService.LocalBinder) service;
            //在这里我们获取到Service对象，可以跟我们的Service进行交互
            localService = binder.getService();
            Toast.makeText(ServiceSampleActivity.this, "连接成功 = " + localService.member,
                    Toast.LENGTH_SHORT).show();
        }

        //service的连接意外丢失时调用这个．比如当service崩溃了或被强杀了．当客户端解除绑定时，这个方法不会被调用．
        @Override
        public void onServiceDisconnected(ComponentName name) {
            localService = null;
            Toast.makeText(ServiceSampleActivity.this, "连接中断",
                    Toast.LENGTH_SHORT).show();

            LogUtils.e("-------------------连接中断--------------------------");

        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        unbindService();
    }
}
