package com.bdqn.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by teng on 2016/5/19.
 */
public class App extends Application {

    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }
}
