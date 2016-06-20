package com.bdqn.app.fragments.staticuse;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bdqn.app.R;

/**
 * Created by teng on 2016/4/22.
 */
public class FragmentStaticUse1 extends Fragment {

    View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_static_use1, container, false);
        return rootView;

    }

}
