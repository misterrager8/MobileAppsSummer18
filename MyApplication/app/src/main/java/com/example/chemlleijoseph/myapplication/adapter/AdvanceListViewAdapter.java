package com.example.chemlleijoseph.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;

import com.example.chemlleijoseph.myapplication.R;

import java.util.ArrayList;

public class AdvanceListViewAdapter extends BaseAdapter {

    private final Context context;
    private final LayoutInflater inflater;
    private ArrayList<String> list;

    public AdvanceListViewAdapter(Context context, ArrayList<String> list){
        this.context = context;
        this.list = list;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d("ViewHolder", "getView");
        RecyclerView.ViewHolder viewHolder;
        if (convertView == null){
            Log.d("ViewHolder", "getView");
            convertView = inflater.inflate(R.layout.activity_advance, parent, false);
            //viewHolder = new RecyclerView.ViewHolder();
            //viewHolder.rl_odd = (RelativeLayout) convertView.findViewById(R.id.odd);
            //viewHolder.rl_even = (RelativeLayout) convertView.findViewById(R.id.even);
           // convertView.setTag(viewHolder);
        }else{
            viewHolder = (RecyclerView.ViewHolder)convertView.getTag();

        }
        if (position%2 ==0){
           // viewHolder.rl_odd.setVisibility(View.INVISIBLE);
           // viewHolder.rl_even.setVisibility(View.VISIBLE);
        }else{
           // viewHolder.rl_odd.setVisibility(View.VISIBLE);
           // viewHolder.rl_even.setVisibility(View.INVISIBLE);
        }
        return convertView;
    }
    private class ViewHolder{
        RelativeLayout rl_odd;
        RelativeLayout rl_even;
    }
}
