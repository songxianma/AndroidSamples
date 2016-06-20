package com.bdqn.app.io;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bdqn.app.R;
import com.bdqn.app.io.external.ExternalStorageActivity;
import com.bdqn.app.io.internal.InternalStorageActivity;

/**
 * Android 的文件的存放位置分为：内部存储和外部存储
 * <p/>
 * 其实内部存储和外部存储是在Android在早期的叫法，那时内部存储是固定的，而外部存储可以是用SD卡来扩展。
 * 但是到现在很多手机都将机身的内存扩展了很多。虽然机身的内存很大了，但是所有的安卓设备都还是有外部存储和内部存储。
 *
 * 内部存储：内部存储不是内存。它属于系统的一部分，如果我们把文件存储到内部存储中，那么文件默认只能被当前的应用访问。
 * 外部存储：外部存储中的文件是可以被用户或者其他应用程序修改。相当于我们使用过的SD卡，我们在文件管理器看到的就是外部存储的文件。
 */
public class IOSampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_io_sample);
    }


    public void showInternalStorageOperateSample(View view) {
        startActivity(new Intent(this, InternalStorageActivity.class));
    }

    public void showExternalStorageOperateSample(View view) {
        startActivity(new Intent(this, ExternalStorageActivity.class));
    }

}
