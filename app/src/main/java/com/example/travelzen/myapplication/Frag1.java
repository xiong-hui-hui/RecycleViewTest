package com.example.travelzen.myapplication;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import de.greenrobot.event.EventBus;

/**
 * Created by hui.xiong on 2015/11/3.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class Frag1 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.frag1,null);
        Button btn= (Button) view.findViewById(R.id.button);
        EventBus.getDefault().register(this);
        return view;
    }


    public void onEventMainThread(String s){

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }
}
