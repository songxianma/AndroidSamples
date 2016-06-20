package com.bdqn.app.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bdqn.app.R;

/**
 * Created by teng on 2016/4/22.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter {

    private String[] mStringArr;
    private Context mContext;
    private LayoutInflater mInflater;

    public RecyclerViewAdapter(Context context, String[] stringArr) {
        mStringArr = stringArr;
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View convertView = mInflater.inflate(R.layout.item_recyclerview, parent, false);
        RecyclerViewViewHolder viewViewHolder = new RecyclerViewViewHolder(convertView);
        return viewViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        RecyclerViewViewHolder viewHolder = (RecyclerViewViewHolder) holder;
        viewHolder.mTextView.setText(mStringArr[position]);
    }

    @Override
    public int getItemCount() {
        return mStringArr.length;
    }


    private class RecyclerViewViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;

        public RecyclerViewViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tvItemRecyclerView);
        }
    }


}
