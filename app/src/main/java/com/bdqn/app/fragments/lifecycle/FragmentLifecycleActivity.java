package com.bdqn.app.fragments.lifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bdqn.app.R;
import com.bdqn.app.utils.LogUtils;

public class FragmentLifecycleActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtils.e("Activity-=-=-=-=-=-onCreate");
        setContentView(R.layout.activity_fragment_lifecycle);
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtils.e("Activity-=-=-=-=-=-onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtils.e("Activity-=-=-=-=-=-onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtils.e("Activity-=-=-=-=-=-onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtils.e("Activity-=-=-=-=-=-onStop");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtils.e("Activity-=-=-=-=-=-onDestroy");
    }
}
