package com.bdqn.app.fragments.lifecycle;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bdqn.app.R;
import com.bdqn.app.utils.LogUtils;

public class FragmentLifecyle extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        LogUtils.e("Fragment-=-=-=-=-=-onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtils.e("Fragment-=-=-=-=-=-onCreate");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LogUtils.e("Fragment-=-=-=-=-=-onCreateView");
        return inflater.inflate(R.layout.fragment_lifecyle, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LogUtils.e("Fragment-=-=-=-=-=-onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        LogUtils.e("Fragment-=-=-=-=-=-onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtils.e("Fragment-=-=-=-=-=-onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        LogUtils.e("Fragment-=-=-=-=-=-onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        LogUtils.e("Fragment-=-=-=-=-=-onStop");
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        LogUtils.e("Fragment-=-=-=-=-=-onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtils.e("Fragment-=-=-=-=-=-onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        LogUtils.e("Fragment-=-=-=-=-=-onDetach");
    }
}
