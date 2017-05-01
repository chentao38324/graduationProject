package com.chentao.teachingapp;

import android.app.Application;

import com.chentao.teachingapp.database.DBManager;

import io.rong.imkit.RongIM;

/**
 * Created by chentao on 17-4-20.
 */

public class TeachingApp extends Application {
    private static TeachingApp appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;

        //初始化数据库
        DBManager.init(this);

        RongIM.init(this);
    }
}
