package com.bdqn.app.fragments.dynamic;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bdqn.app.R;


public class AddFragment extends Fragment {


    public static AddFragment newInstance(Bundle bundle) {
        AddFragment addFragment = new AddFragment();
        addFragment.setArguments(bundle);
        return addFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String value = getArguments().getString("key");
        Toast.makeText(getActivity(), value, Toast.LENGTH_SHORT).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false);
    }


}
