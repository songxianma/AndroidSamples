package com.bdqn.app.gridview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.bdqn.app.R;
import com.bdqn.app.adapter.UserListAdapter;
import com.bdqn.app.entity.User;
import com.bdqn.app.entity.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by teng on 2016/4/15.
 */
public class GridViewBaseAdapterTestActivity extends AppCompatActivity {

    private GridView mGridView;
    private List<User> mUsers;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview_test);
        mGridView = (GridView) this.findViewById(R.id.gridView);
        //准备数据
        prepareUserList();
        //构造Adapter
        UserListAdapter adapter = new UserListAdapter(this, mUsers);
        mGridView.setAdapter(adapter);

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Utils.showToast(getApplicationContext(), "这是第" + position + "行");
            }
        });

    }


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
}
