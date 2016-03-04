package com.example.travelzen.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by hui.xiong on 2016/3/4.
 */
public class SingleAdapter extends RecyclerView.Adapter<SingleAdapter.MyViewHolder>{

    Context mContext;
    List<String> mList;
    public SingleAdapter(Context context, List<String> list){
        mContext =context;
        mList=list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder viewHolder =new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_single,parent,false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
      holder.tv.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.num);
        }
    }


}
