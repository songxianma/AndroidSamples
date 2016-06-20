package com.bdqn.app.io.internal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bdqn.app.R;

/**
 * 内部存储不是内存。它属于系统的一部分，如果我们把文件存储到内部存储中，那么文件默认只能被当前的应用访问。
 * 当我们在内部存储中创建文件，这个文件会在应用包名所在的目录下；它会跟应用关联起来。当我们卸载应用之后，我们创建的文件也会被删掉。
 * 手机的内存非常宝贵，我们的应用和手机系统都运行在内存里，所以对于文件在内部存储的操作，应尽量的避免。
 * <p/>
 * 我们常用的文件存储有：SharedPreferences、SQLite,File。这些都可以内部存储中存储
 * <p/>
 * 一般我们获取内部存储都要用Context
 */
public class InternalStorageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage_actvitiy);
    }


    public void showSharedPreferencesSample(View view){
        Intent intent = new Intent(this,SharedPreferencesSampleActivity.class);
        startActivity(intent);
    }

    public  void showFileOperateSample(View view){
        startActivity(new Intent(this,FileOperateActivity.class));
    }



}
