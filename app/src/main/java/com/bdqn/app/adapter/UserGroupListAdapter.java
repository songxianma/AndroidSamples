package com.bdqn.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bdqn.app.entity.Entity;
import com.bdqn.app.entity.Group;
import com.bdqn.app.R;
import com.bdqn.app.entity.User;

import java.util.List;

/**
 * Created by teng on 2016/4/14.
 */

public class UserGroupListAdapter extends BaseAdapter {
    private final int COUNT = 2;

    private final int TYPE_GROUP = 0;
    private final int TYPE_USER = 1;

    private List<Entity> mEntities;
    private LayoutInflater mInflater;

    public UserGroupListAdapter(Context context, List<Entity> entities) {
        mEntities = entities;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() { // ListView 的行数
        return mEntities == null ? 0 : mEntities.size();
    }

    @Override
    public Object getItem(int position) { // ListView 每一行的数据
        return mEntities == null ? null : mEntities.get(position);
    }

    @Override
    public long getItemId(int position) {// ListView每一行的Id
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        int type = TYPE_GROUP;
        Entity entity = mEntities.get(position);
        if (entity instanceof Group) {
            type = TYPE_GROUP;
        } else if (entity instanceof User) {
            type = TYPE_USER;
        }
        return type;
    }

    @Override
    public int getViewTypeCount() {
        return COUNT;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        int type = getItemViewType(position);
        if (convertView == null) { // 对getView进行优化，利用缓存的item，减少不必要的View的创建
            switch (type) {
                case TYPE_GROUP:
                    convertView = mInflater.inflate(R.layout.group_item, parent, false);
                    holder = new GroupHolder(convertView);
                    convertView.setTag(holder);
                    break;
                case TYPE_USER:
                    convertView = mInflater.inflate(R.layout.item_2, parent, false);
                    holder = new UserHolder(convertView);
                    convertView.setTag(holder);
                    break;
                default:
                    break;
            }
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (holder instanceof GroupHolder) {
            Group group = (Group) mEntities.get(position);
            ((GroupHolder) holder).tvGroupName.setText(group.name);
        }else if (holder instanceof UserHolder) {
            User user = (User) mEntities.get(position);
            ((UserHolder) holder).mTvName.setText(user.name);
            ((UserHolder) holder).mTvEmail.setText(user.email);
            ((UserHolder) holder).mTvAddress.setText(user.address);
        }
        return convertView;
    }

    public static class ViewHolder{
    }

    /**
     * 分组布局的ViewHolder
     */
    public static class GroupHolder extends ViewHolder{
        public TextView tvGroupName;

        public GroupHolder(View convertView) {
            this.tvGroupName = (TextView) convertView.findViewById(R.id.tvGroupName);
        }
    }

    /**
     * 用户布局的ViewHolder
     */
    public static class UserHolder extends ViewHolder{
        public TextView mTvName;
        public TextView mTvEmail;
        public TextView mTvAddress;

        public UserHolder(View convertView) {
            mTvName = (TextView) convertView.findViewById(R.id.tvName);
            mTvEmail = (TextView) convertView.findViewById(R.id.tvEmail);
            mTvAddress = (TextView) convertView.findViewById(R.id.tvAddress);
        }
    }
}
