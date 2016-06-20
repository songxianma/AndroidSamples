package com.bdqn.app.listview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.bdqn.app.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ListViewSimpleAdapterTestActivity extends Activity {

    private ListView mListView;
    private List<Map<String, Object>> mMapList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adater);
        mListView = (ListView) this.findViewById(R.id.listView);

        //准备数据
        prepareMapList();
        //构造adapter
        String[] from = {"header","name","age"};
        int[] to = {R.id.ivHeader,R.id.tvName,R.id.tvAge};
        SimpleAdapter adapter = new SimpleAdapter(this, mMapList, R.layout.item_1, from, to);
        //显示
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showToast("这是第" + position + "行");
            }
        });
    }

    public void prepareMapList() {
        mMapList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("header", R.drawable.ic_launcher);
            map.put("name", "name = " + i);
            map.put("age", "age = " + (i * i));
            mMapList.add(map);
        }
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }


}

