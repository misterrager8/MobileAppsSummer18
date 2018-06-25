package com.example.chemlleijoseph.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.example.chemlleijoseph.myapplication.R;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CheckBoxActivity extends BaseActivity {

    @BindView(R.id.checkbox1)
    CheckBox ck1;

    @BindView(R.id.checkbox2)
    CheckBox ck2;

    @BindView(R.id.checkbox3)
    CheckBox ck3;

    @OnClick(R.id.check_submit)
    public void submit(View v){
        String msg = "You checked: ";
        for (Map.Entry<Integer, Boolean> entry : checklist.entrySet()){
            if (entry.getValue()){
                switch (entry.getKey()){
                    case R.id.checkbox1:
                        msg += "CheckBox1 ";
                        break;
                    case R.id.checkbox2:
                        msg += "CheckBox2 ";
                        break;
                    case R.id.checkbox3:
                        msg += "CheckBox3 ";
                        break;
                        default:
                            msg += "Nothing";
                            break;
                }
            }
        }
        shortToast(msg);
    }

    private Map<Integer, Boolean> checklist= new HashMap<Integer, Boolean>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        ButterKnife.bind(this);
        ck1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checklist.put(buttonView.getId(), isChecked);
            }
        });
        ck2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checklist.put(buttonView.getId(), isChecked);
            }
        });
        ck3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checklist.put(buttonView.getId(), isChecked);
            }
        });
    }
}
