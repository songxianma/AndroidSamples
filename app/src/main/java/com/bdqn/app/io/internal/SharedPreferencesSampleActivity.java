package com.bdqn.app.io.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bdqn.app.R;
import com.bdqn.app.entity.Utils;

/**
 * SharedPreferences：改存储方式只能存储在内部，存储时是以 key-value 的形式存储。存储的文件是xml形式。
 * 它不适用于存储过大的数据，一般用于存储一些简单的配置信息。
 * <p/>
 * SharedPreferences 支持6种形式的，分别是
 * String,int,long,boolean,float,Set<String>
 * <p/>
 * 使用步骤：
 * <ul>
 * 1.获取SharedPreferences 的对象。在创建时，要传入文件名和存储模式<br/>
 * SharedPreferences sp = getSharedPreferences("user",MODE_PRIVATE);<br/>
 * 2.获取到编辑器<br/>
 * SharedPreferences.Editor editor = sp.edit();<br/>
 * 3.使用编辑器以键值对的形式存储我们的需要存储的内容<br/>
 * editor.putString("name", "李腾");<br/>
 * editor.putString("passwrod", "123456");<br/>
 * 4.提交我们需要存储的内容<br/>
 * editor.commit();
 * </ul>
 * <p/>
 * 我们存储完数据之后，如果获取到我们存储的数据呢？<br/>
 * sp.getString("key",null);//第一个参数是我们存储的键值，第二个参数表示如果我们没有获取存储值，则返回第二个参数。<br/>
 * 其它形式的的数据跟上面的类似。
 * <p/>
 */

public class SharedPreferencesSampleActivity extends AppCompatActivity {

    SharedPreferences mSharedPreferences = null;
    SharedPreferences.Editor mEditor = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences_sample);

        mSharedPreferences = getSharedPreferences("user", Context.MODE_APPEND);
        mEditor = mSharedPreferences.edit();

        SharedPreferences sp = getSharedPreferences("user", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("name", "李腾");
        editor.putString("passwrod", "123456");
        editor.commit();
    }

    private void saveName() {
        mEditor.putString("name", "张三");
        mEditor.commit();
    }

    private void getName() {
        String name = mSharedPreferences.getString("name", null);
        Utils.showToast(this, name);
    }

    private void saveAge() {
        mEditor.putInt("age", 35);
        mEditor.commit();
    }

    private void getAge() {
        int age = mSharedPreferences.getInt("age", 0);
        Utils.showToast(this, age + "");
    }

    private void saveHeight() {
        mEditor.putFloat("height", 173.5f);
        mEditor.commit();
    }

    private void getHeight() {
        float height = mSharedPreferences.getFloat("height", 0f);
        Utils.showToast(this, height + "");
    }

    private void saveWeight() {
        mEditor.putLong("weight", 55L);
        mEditor.commit();
    }

    private void getWeight() {
        float weight = mSharedPreferences.getLong("weight", 0L);
        Utils.showToast(this, weight + "");
    }

}
