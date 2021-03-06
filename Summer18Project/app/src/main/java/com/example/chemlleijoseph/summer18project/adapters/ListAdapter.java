package com.example.chemlleijoseph.summer18project.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.chemlleijoseph.summer18project.R;

import java.util.List;

public class ListAdapter extends BaseAdapter {
    private List<String> list;
    private Context context;
    private LayoutInflater inflater;

    public ListAdapter(Context context, List<String> list){
        this.context=context;
        this.list=list;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = inflater.inflate(R.layout.item_listview_main, parent, false);
            TextView textView = convertView.findViewById(R.id.main_adapter_tv);
            convertView.setTag(textView);
        }


        TextView textView = (TextView) convertView.getTag();
        textView.setText(list.get(position));
        return convertView;
    }
}
