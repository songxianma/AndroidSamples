package com.bdqn.app.listview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.bdqn.app.R;

import java.util.ArrayList;
import java.util.List;


public class ListViewArrayAdapterTestActivity extends Activity {

    private ListView mListView;

    private String[] strArr;
    private List<String> strList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adater);

        mListView = (ListView) this.findViewById(R.id.listView);
        //准备数据
        prepareArrDatas();
        prepareListDatas();

        //使用数组构造ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, strArr);

        //使用集合构造ArrayAdapter
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,strList);
        //设置Adapter，并显示
        mListView.setAdapter(adapter);
        //ListView的行点击
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showToast( "这是第" + position + "行");
            }
        });
    }

    //准备集合数据
    private void prepareListDatas() {
        strList = new ArrayList();
        for (int i = 0; i < 20; i++) {
            strList.add("集合的 第" + i + "行");
        }
    }

    //准备数组数据
    private void prepareArrDatas() {
        strArr = new String[20];
        for (int i = 0; i < 20; i++) {
            strArr[i] = "数组的 第" + i + "行";
        }
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }


}

