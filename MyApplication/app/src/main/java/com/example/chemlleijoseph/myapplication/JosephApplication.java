package com.example.chemlleijoseph.myapplication;

import android.app.Application;
import android.util.Log;

import com.example.chemlleijoseph.myapplication.util.UtilLog;

public class JosephApplication extends Application {

    @Override
    public void onCreate(){
        super.onCreate();
        UtilLog.setIsLog(true);
    }


}
