package com.bdqn.app.gridview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.bdqn.app.R;
import com.bdqn.app.entity.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by teng on 2016/4/15.
 */
public class GridViewArrayAdapterTestActivity extends AppCompatActivity {

    private GridView mGridView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview_test);
        mGridView = (GridView) this.findViewById(R.id.gridView);

        //准备数据
        prepareStringArr();
        prepareStringList();
        //构造Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, strArr);
        //显示
        mGridView.setAdapter(adapter);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Utils.showToast(getApplicationContext(), "这是第" + position + "行");
            }
        });
    }

    private String[] strArr = null;

    private void prepareStringArr() {
        strArr = new String[15];
        for (int i = 0; i < 15; i++) {
            strArr[i] = "item " + i;
        }
    }

    private List<String> strList = null;

    private void prepareStringList() {
        strList = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            strList.add("item " + i);
        }
    }

}
