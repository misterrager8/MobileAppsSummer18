package com.example.chemlleijoseph.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RadioGroupActivity extends BaseActivity {

    private int checkedId;

    @BindView(R.id.radio_radiogroup)
    RadioGroup radioGroup;

    @OnClick(R.id.radio_group_bt)
    public void submit(View view){
        switch (checkedId){
            case R.id.radio_rb1:
                shortToast("You choose 1");
                break;
            case R.id.radio_rb2:
                shortToast("You choose 2");
                break;
            case R.id.radio_rb3:
                shortToast("You choose 3");
                break;
                default:
                    shortToast("You choose nothing");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_group);
        ButterKnife.bind(this);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                RadioGroupActivity.this.checkedId=checkedId;
            }
        });
    }
}
