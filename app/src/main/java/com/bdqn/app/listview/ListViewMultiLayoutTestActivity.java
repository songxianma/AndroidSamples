package com.bdqn.app.listview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.bdqn.app.R;
import com.bdqn.app.adapter.UserGroupListAdapter;
import com.bdqn.app.entity.Entity;
import com.bdqn.app.entity.Group;
import com.bdqn.app.entity.User;

import java.util.ArrayList;
import java.util.List;


public class ListViewMultiLayoutTestActivity extends Activity {

    private ListView mListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adater);

        mListView = (ListView) this.findViewById(R.id.listView);
        prepareUserGroupList();

        UserGroupListAdapter adapter = new UserGroupListAdapter(this, mEntities);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showToast("这是第" + position + "行");
            }
        });
    }

    private List<Entity> mEntities = null;

    private void prepareUserGroupList() {
        mEntities = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Entity entity = null;
            if (i % 2 == 0) {
                entity = new Group();
                ((Group) entity).name = "分组 " + i;
            } else {
                entity = new User();
                ((User) entity).name = "User Name " + i;
                ((User) entity).email = "litengit@16" + i + ".com";
                ((User) entity).address = "火星" + i + "号";
            }

            mEntities.add(entity);
        }
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}

