package com.example.chemlleijoseph.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.chemlleijoseph.myapplication.adapter.AdvanceListViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdvanceListViewActivity extends BaseActivity {

    private ListView listView;
    private List<String> list = new ArrayList<String>();
    private AdvanceListViewAdapter adapter;

    //@BindView(R.id.activity_advance_list_view) ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance_list_view);

        View view = getLayoutInflater().inflate(R.layout.listview_header, null);


        list.add("Hello");
        list.add("Hello, how are you?");
        list.add("I am fine, thank you");

        listView = findViewById(R.id.adv_lv);
        adapter = new AdvanceListViewAdapter(this, list);
        listView.setAdapter(adapter);
        listView.addHeaderView(view);

       /* TextView tv = new TextView(this);
        tv.setText("HeaderView");
        tv.setTextSize(50);
        lv.addHeaderView(tv);

        TextView tv1 = new TextView(this);
        tv1.setText("FooterView");
        tv1.setTextSize(50);
        lv.addHeaderView(tv1);*/
    }
}
