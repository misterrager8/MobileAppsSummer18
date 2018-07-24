package com.example.chemlleijoseph.myapplication;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HandlerActivity extends AppCompatActivity {

    @BindView(R.id.handler_et)
    EditText editText;

    @OnClick(R.id.handler_countdown)
    public void countdown(View view){
        runHandler.postDelayed(runnable, 1000);
    }

    Handler downloadHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    editText.setText("Started");
                    Toast.makeText(HandlerActivity.this, String.valueOf(msg.arg1), Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    editText.setText("Downloading");
                    break;
                case 3:
                    editText.setText("Finished");
                    break;
            }
        }
    };

    Handler runHandler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            String s = editText.getText().toString();
            int number = Integer.valueOf(s);
            if (number >0){
                number-=1;
            }
            editText.setText(String.valueOf(number));
            runHandler.postDelayed(runnable, 1000);
        }
    };

    @OnClick(R.id.handler_download)
    public void download(View view){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message msg = new Message();
                msg.what=1;
                msg.arg1=123;
                downloadHandler.sendMessage(msg);
                try {
                    Thread.sleep(3000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                Message msg2 = new Message();
                msg2.what=2;
                downloadHandler.sendMessage(msg2);
                try {
                    Thread.sleep(3000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                Message msg3 = new Message();
                msg3.what=3;
                downloadHandler.sendMessage(msg3);
                try {
                    Thread.sleep(3000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        ButterKnife.bind(this);
    }

    class DownloadThread extends Thread{
        @Override
        public synchronized void start() {
            super.start();
            try {
                editText.setText("Start");
                Thread.sleep(2000);
                editText.setText("Download");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
