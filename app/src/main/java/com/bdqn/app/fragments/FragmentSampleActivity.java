package com.bdqn.app.fragments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bdqn.app.R;
import com.bdqn.app.fragments.dynamic.FragmentDynamicUseActivity;
import com.bdqn.app.fragments.lifecycle.FragmentLifecycleActivity;
import com.bdqn.app.fragments.staticuse.FragmentStaticUseActivity;

public class FragmentSampleActivity extends AppCompatActivity {

    Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_sample);
        mIntent = new Intent();
    }

    public void showFragmentLifeCycle(View view) {
        mIntent.setClass(this, FragmentLifecycleActivity.class);
        startActivity(mIntent);
    }

    public void showFragmentStaticUse(View view) {
        mIntent.setClass(this, FragmentStaticUseActivity.class);
        startActivity(mIntent);
    }

    public void showFragmentDynamicUse(View view){
        mIntent.setClass(this, FragmentDynamicUseActivity.class);
        startActivity(mIntent);
    }

}
