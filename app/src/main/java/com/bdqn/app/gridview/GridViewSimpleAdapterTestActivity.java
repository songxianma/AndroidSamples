package com.bdqn.app.gridview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.bdqn.app.R;
import com.bdqn.app.entity.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by teng on 2016/4/15.
 */
public class GridViewSimpleAdapterTestActivity extends AppCompatActivity {

    private GridView mGridView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview_test);
        mGridView = (GridView) this.findViewById(R.id.gridView);
        //准备数据
        prepareMapList();
        //构造Adapter
        String[] from = {"name", "age", "header"};
        int[] to = {R.id.tvName, R.id.tvAge, R.id.ivHeader};
        SimpleAdapter adapter = new SimpleAdapter(this, mMaps, R.layout.item_1, from, to);
        //显示
        mGridView.setAdapter(adapter);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Utils.showToast(getApplicationContext(), "这是第" + position + "行");
            }
        });

    }

    List<Map<String, Object>> mMaps = null;

    private void prepareMapList() {
        mMaps = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("name", "name= " + i);
            map.put("age", "年龄" + i);
            map.put("header", R.drawable.ic_launcher);
            mMaps.add(map);
        }
    }


}
