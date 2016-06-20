package com.bdqn.app.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.bdqn.app.R;
import com.bdqn.app.adapter.RecyclerViewAdapter;

public class RecyclerViewSampleActivity extends AppCompatActivity {

    private String[] mStringArr;

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_sample);

        String[] stringArr = preArrsData();

        mRecyclerView = (RecyclerView) findViewById(R.id.recylerView);
        RecyclerView.LayoutManager manager = null;
        //List竖向滑动
        //manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        //List横向滑动
        //manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        // Grid 横向滑动
        //manager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.HORIZONTAL);
        // Grid 竖向滑动
        manager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, stringArr);
        mRecyclerView.setAdapter(adapter);
    }


    private String[] preArrsData() {
        mStringArr = new String[150];
        for (int i = 0; i < 150; i++) {
            mStringArr[i] = "Item " + i;
        }
        return mStringArr;
    }


}
