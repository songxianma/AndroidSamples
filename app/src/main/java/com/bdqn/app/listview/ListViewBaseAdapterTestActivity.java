package com.bdqn.app.listview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.bdqn.app.R;
import com.bdqn.app.adapter.UserListAdapter;
import com.bdqn.app.entity.User;

import java.util.ArrayList;
import java.util.List;


public class ListViewBaseAdapterTestActivity extends Activity {

    private ListView mListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adater);
        mListView = (ListView) this.findViewById(R.id.listView);
        //准备数据
        prepareUserList();
        //构造Adapter
        UserListAdapter adapter = new UserListAdapter(this, mUsers);
        //显示
        mListView.setAdapter(adapter);
        //行点击
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showToast("这是第" + position + "行");
            }
        });
    }

    private List<User> mUsers;
    private void prepareUserList() {
        mUsers = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            User user = new User();
            user.name = "User Name " + i;
            user.email = "litengit@16" + i + ".com";
            user.address = "火星" + i + "号";
            mUsers.add(user);
        }
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }


}

