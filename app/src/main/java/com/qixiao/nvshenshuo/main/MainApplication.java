package com.qixiao.nvshenshuo.main;

import android.app.Application;

import cn.sharesdk.framework.ShareSDK;

/**
 * Created by admin on 2015/6/10.
 */
public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ShareSDK.initSDK(this);
    }
}
