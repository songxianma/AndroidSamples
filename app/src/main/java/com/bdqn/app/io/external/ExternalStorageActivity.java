package com.bdqn.app.io.external;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bdqn.app.R;
import com.bdqn.app.utils.LogUtils;

import java.io.File;
import java.io.IOException;


/**
 * ExternalStorage 外部存储:也分为公共文件和私有文件.<br/>
 * 公共文件：可以被自由访问，并且文件的数据在应用卸载掉之后依然存在。<br/>
 * 私有文件：其实由于是外部存储的原因即是是这种类型的文件也能被其他程序访问，
 * 只不过一个应用私有的文件对其他应用其实是没有访问价值的（恶意程序除外）。
 * 外部存储上，应用私有文件的价值在于卸载之后，这些文件也会被删除。类似于内部存储。
 * <p/>
 * 获取外部存储的根目录：类似这种：/storage/sdcard
 * <pre class="prettyprint">
 * String path = Environment.getExternalStorageDirectory().getAbsolutePath();
 * <pre/>
 * 在手机系统里会在存储空间里创建一些特定功能的文件夹，比如图片，音乐，电影等；如何获取这些类型文件所在目录？
 * 这里获取图片所在的目录，类似这种：/storage/sdcard/Android/data/com.liteng.app/files/Pictures
 * <pre class="prettyprint">
 * String path = Environment.getExternalStorageDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath();
 * <pre/>
 */
public class ExternalStorageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_storage);

        getExternalStoragePath();

        getExternalFileDir();

        getExternalStoragePublicDir();
    }

    /**
     * 获取外部存储的的根目录
     */
    public void getExternalStoragePath() {
        String path = Environment.getExternalStorageDirectory().getAbsolutePath();
        File file = Environment.getExternalStorageDirectory();
        try {
            String canonicalPath = file.getCanonicalPath();
            LogUtils.e(canonicalPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        LogUtils.e(path);
    }

    /**
     * 获取相册这应用所在的私有的外部存储目录
     */
    public void getExternalFileDir() {
        String path = getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath();
        LogUtils.e(path);
    }

    /**
     * 获取图片所在的目录
     */
    public void getExternalStoragePublicDir() {
        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath();
        LogUtils.e(path);
    }


}
