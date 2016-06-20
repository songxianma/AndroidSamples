package com.bdqn.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bdqn.app.fragments.FragmentSampleActivity;
import com.bdqn.app.gridview.GridViewArrayAdapterTestActivity;
import com.bdqn.app.gridview.GridViewBaseAdapterTestActivity;
import com.bdqn.app.gridview.GridViewSimpleAdapterTestActivity;
import com.bdqn.app.image.ImageOperateActivity;
import com.bdqn.app.io.IOSampleActivity;
import com.bdqn.app.listview.ListViewArrayAdapterTestActivity;
import com.bdqn.app.listview.ListViewBaseAdapterTestActivity;
import com.bdqn.app.listview.ListViewMultiLayoutTestActivity;
import com.bdqn.app.listview.ListViewSimpleAdapterTestActivity;
import com.bdqn.app.net.NetSampleActivity;
import com.bdqn.app.recyclerview.RecyclerViewSampleActivity;
import com.bdqn.app.sqlite.SqliteSampleActivity;

public class MainActivity extends AppCompatActivity {

    Intent mIntent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIntent = new Intent();
    }

    public void showListViewArrayAdapter(View view) {
        mIntent.setClass(this, ListViewArrayAdapterTestActivity.class);
        startActivity(mIntent);
    }

    public void showListViewSimpleAdapter(View view) {
        mIntent.setClass(this, ListViewSimpleAdapterTestActivity.class);
        startActivity(mIntent);
    }

    public void showListViewBaseAdapter(View view) {
        mIntent.setClass(this, ListViewBaseAdapterTestActivity.class);
        startActivity(mIntent);
    }

    public void showListViewMultiLayout(View view) {
        mIntent.setClass(this, ListViewMultiLayoutTestActivity.class);
        startActivity(mIntent);
    }

    public void showGridViewArrayAdapter(View view) {
        mIntent.setClass(this, GridViewArrayAdapterTestActivity.class);
        startActivity(mIntent);
    }

    public void showGridViewSimpleAdapter(View view) {
        mIntent.setClass(this, GridViewSimpleAdapterTestActivity.class);
        startActivity(mIntent);
    }

    public void showGridViewBaseAdapter(View view) {
        mIntent.setClass(this, GridViewBaseAdapterTestActivity.class);
        startActivity(mIntent);
    }


    public void showFragmentsSample(View view) {
        mIntent.setClass(this, FragmentSampleActivity.class);
        startActivity(mIntent);
    }

    public void showRecyclerViewAdapter(View view) {
        mIntent.setClass(this, RecyclerViewSampleActivity.class);
        startActivity(mIntent);
    }

    public void showFileOperateSample(View view) {
        mIntent.setClass(this, IOSampleActivity.class);
        startActivity(mIntent);
    }


    public void showImageOperateSample(View view) {
        mIntent.setClass(this, ImageOperateActivity.class);
        startActivity(mIntent);
    }

    public void showSqliteOperateSample(View view) {
        mIntent.setClass(this, SqliteSampleActivity.class);
        startActivity(mIntent);
    }

    public void showNetRequestSample(View view) {
        mIntent.setClass(this, NetSampleActivity.class);
        startActivity(mIntent);
    }


}
