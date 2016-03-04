package com.example.travelzen.myapplication;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import de.greenrobot.event.EventBus;

/**
 * Created by hui.xiong on 2015/11/3.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class frag2 extends Fragment {
    private TextView tv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.frag2,null);
        tv= (TextView) v.findViewById(R.id.textView2);
        EventBus.getDefault().register(this);
        return v;
    }
    public void onEventMainThread(String s){
        tv.setText(s);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

}
