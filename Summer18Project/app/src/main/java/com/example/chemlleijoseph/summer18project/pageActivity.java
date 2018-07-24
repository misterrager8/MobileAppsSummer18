package com.example.chemlleijoseph.summer18project;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class pageActivity extends AppCompatActivity {
    public static final String mBroadcastStringAction = "com.example.chemlleijoseph.summer18project.string";
    public static final String mBroadcastIntegerAction = "com.example.chemlleijoseph.summer18project.integer";
    public static final String mBroadcastArrayListAction = "com.example.chemlleijoseph.summer18project.arraylist";
    private TextView mTextView;
    private IntentFilter mIntentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);
        mTextView = (TextView) findViewById(R.id.textview1);
        mIntentFilter = new IntentFilter();
        mIntentFilter.addAction(mBroadcastStringAction);
        mIntentFilter.addAction(mBroadcastIntegerAction);
        mIntentFilter.addAction(mBroadcastArrayListAction);

        final Intent serviceIntent = new Intent(this, BroadcastService.class);
        Button download = findViewById(R.id.button);
        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(serviceIntent);
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        registerReceiver(mReceiver, mIntentFilter);
    }

    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            mTextView.setText(mTextView.getText()
                    + "Status: \n");
            if (intent.getAction().equals(mBroadcastStringAction)) {
                mTextView.setText(mTextView.getText()
                        + intent.getStringExtra("Data") + "\n\n");
            } else if (intent.getAction().equals(mBroadcastIntegerAction)) {
                mTextView.setText(mTextView.getText().toString()
                        + intent.getIntExtra("Data", 0) + "\n\n");
            } else if (intent.getAction().equals(mBroadcastArrayListAction)) {
                mTextView.setText(mTextView.getText()
                        + intent.getStringArrayListExtra("Data").toString()
                        + "\n\n");
                Intent stopIntent = new Intent(pageActivity.this,
                        BroadcastService.class);
                stopService(stopIntent);
            }
        }
    };

    @Override
    protected void onPause() {
        unregisterReceiver(mReceiver);
        super.onPause();
    }

}
