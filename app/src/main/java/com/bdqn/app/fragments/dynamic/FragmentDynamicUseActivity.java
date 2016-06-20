package com.bdqn.app.fragments.dynamic;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bdqn.app.R;

public class FragmentDynamicUseActivity extends AppCompatActivity {

    FragmentManager mFragmentManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_dynamic_use);
        mFragmentManager = getSupportFragmentManager();
    }


    public void addFragment(View view){
        Bundle bundle = new Bundle();
        bundle.putString("key","argument");
        AddFragment fragment = AddFragment.newInstance(bundle);
        mFragmentManager.beginTransaction().add(R.id.fragmentContainer,fragment).commit();
    }

    public void replaceFragment(View view){
        ReplaceFragment fragment = new ReplaceFragment();
        mFragmentManager.beginTransaction().replace(R.id.fragmentContainer,fragment).commit();
    }




}
