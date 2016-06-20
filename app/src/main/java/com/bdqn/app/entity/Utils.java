package com.bdqn.app.entity;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by teng on 2016/4/14.
 */
public class Utils {
    public static String TAG = "-=-=-李腾-=-=-";

    public static void e(String msg) {
        Log.e(TAG, msg);
    }

    public static void showToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

}
