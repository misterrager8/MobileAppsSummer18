package com.example.chemlleijoseph.summer18project;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;

import com.google.android.gms.maps.MapView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class signUpActivity extends AppCompatActivity {

    @BindView(R.id.radio_group)
    RadioGroup radioGroup;

    ProgressBar bar;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            bar.incrementProgressBy(5);
        }
    };
    boolean isRunning = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
        bar = findViewById(R.id.progressBar);
        bar.setVisibility(View.INVISIBLE);

        Button submit = findViewById(R.id.submitButton);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bar.setVisibility(View.VISIBLE);
            }
        });

        Bundle bundle = new Bundle();
        EditText x = findViewById(R.id.editText);
        EditText y = findViewById(R.id.editText2);

        String one = x.getText().toString();
        String two = y.getText().toString();

        bundle.putString("email", one);
        bundle.putString("password", two);

        Intent intent = new Intent();
        intent.setClass(getBaseContext(), MainActivity.class);

        intent.putExtras(bundle);
    }


    public void onStart() {
        super.onStart();
        bar.setProgress(0);

        Thread background = new Thread(new Runnable() {
            public void run() {
                try {
                    for (int i = 0; i < 20 && isRunning; i++) {
                        Thread.sleep(1000);
                        handler.sendMessage(handler.obtainMessage());
                    }
                } catch (Throwable t) {
                    // just end the background thread
                }
            }
        });

        isRunning = true;
        background.start();
    }

    public void onStop() {
        super.onStop();
        isRunning = false;
    }
}

