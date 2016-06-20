package com.bdqn.app.io.internal;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bdqn.app.R;
import com.bdqn.app.entity.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Android File在内部存储中的应用，类似 java 中的文件操作，都是使用IO来操作
 * <p/>
 * File 操作的目录为:  /data/data/应用包名/files，使用获取这个目录：<br/>
 * String fileDir = getFilesDir().getAbsolutePath();
 * <p/>
 * 创建文件有两种方式：
 * 第一种：使用Java里常用的形式
 * <pre class="prettyprint">
 * File file = new File(getFilesDir(), "test");
 * file.createNewFile();
 * </pre>
 * 第二种：Android 提供了更加简单的 openFileOutput 方法
 * <pre class="prettyprint">
 * //openFileOutput(String,int):第一个参数为要创建的文件名，第二个参数为创建模式，其返回的是创建了改文件之后的输入流，我们拿到这个流之后对文件进行写入操作
 * //如果没有该文件，则新建并返回输入流；如果存在该文件，则返回输入流
 * FileOutputStream outputStream = openFileOutput("test", Context.MODE_PRIVATE);
 * </pre>
 *
 * 读取文件的方式：类似上面的方式Android提供了 openFileInput,来去已有的文件，并返回它的输入流
 * <pre class="prettyprint">
 *     FileInputStream inputStream = openFileInput("test");
 * </pre>
 *
 */
public class FileOperateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_operate);

        createFile();

        readFile();

    }

    /**
     * 读取文件
     */
    private void readFile() {
        try {
            FileInputStream inputStream = openFileInput("test");
            InputStreamReader reader = new InputStreamReader(inputStream);
            StringBuilder builder = new StringBuilder();
            while (reader.ready()) {
                builder.append((char) reader.read());
            }
            reader.close();
            Utils.showToast(this, builder.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建文件，并将字符串 "Hello,World" 写入到创建的文件中
     */
    private void createFile() {
        try {
            String msg = "Hello，World";
            FileOutputStream outputStream = openFileOutput("test", Context.MODE_PRIVATE);
            outputStream.write(msg.getBytes());
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
