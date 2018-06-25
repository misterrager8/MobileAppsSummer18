package com.example.chemlleijoseph.myapplication.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

import com.example.chemlleijoseph.myapplication.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class customDialog extends Dialog {

    private CustomDialogEventListener listener;

    public interface CustomDialogEventListener{
        public void onClickListener(String msg);
    }

    public customDialog(@NonNull Context context, CustomDialogEventListener listener) {
        super(context, R.style.dialog);
        this.listener=listener;
    }

    @OnClick(R.id.dialog_ok)
    public void ok(View view){
        listener.onClickListener("OK");
        dismiss();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_custom);
        ButterKnife.bind(this);
    }
}
