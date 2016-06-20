package com.bdqn.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bdqn.app.R;
import com.bdqn.app.entity.User;

import java.util.List;

/**
 * Created by teng on 2016/4/14.
 */
public class UserListAdapter extends BaseAdapter {

    private List<User> mUsers = null;
    private LayoutInflater mInflater = null;

    public UserListAdapter(Context context, List<User> users) {
        mInflater = LayoutInflater.from(context);
        mUsers = users;
    }

    @Override
    public int getCount() { // ListView 的行数
        return mUsers == null ? 0 : mUsers.size();
    }

    @Override
    public Object getItem(int position) { // ListView 每一行的数据
        return mUsers == null ? null : mUsers.get(position);
    }

    @Override
    public long getItemId(int position) {// ListView每一行的Id
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) { // 对getView进行优化，利用缓存的item，减少不必要的View的创建
            convertView = mInflater.inflate(R.layout.item_2, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        //填充每一行的数据
        User user = mUsers.get(position);
        holder.mTvName.setText(user.name);
        holder.mTvEmail.setText(user.email);
        holder.mTvAddress.setText(user.address);
        return convertView;
    }


    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getViewTypeCount() {
        return super.getViewTypeCount();
    }

    /**
     * 创建一个实体类，用来装每一行的控件,这样我们可以很容易的通过对象调用它们。
     */
    private static class ViewHolder {
        public TextView mTvName;
        public TextView mTvEmail;
        public TextView mTvAddress;

        public ViewHolder(View convertView) {
            mTvName = (TextView) convertView.findViewById(R.id.tvName);
            mTvEmail = (TextView) convertView.findViewById(R.id.tvEmail);
            mTvAddress = (TextView) convertView.findViewById(R.id.tvAddress);
        }
    }
}
