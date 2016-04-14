package com.botou.hx.marketclient;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2016/4/13.
 */
public class BaseApplication extends Application{
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getmContext(){
        return mContext;
    }
}
