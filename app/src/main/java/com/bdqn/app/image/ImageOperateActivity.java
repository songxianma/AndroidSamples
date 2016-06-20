package com.bdqn.app.image;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bdqn.app.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


/**
 * res/raw和assets的相同点：
 * <p/>
 * 1.两者目录下的文件在打包后会原封不动的保存在apk包中，不会被编译成二进制。<br>
 * <p/>
 * res/raw和assets的不同点：<br>
 * <p/>
 * 1.res/raw中的文件会被映射到R.Java文件中，访问的时候直接使用资源ID即R.id.filename；assets文件夹下的文件不会被映射到R.java中，访问的时候需要AssetManager类。<br>
 * 2.res/raw不可以有目录结构，而assets则可以有目录结构，也就是assets目录下可以再建立文件夹
 */
public class ImageOperateActivity extends AppCompatActivity {

    private ImageView mImageView;

    Bitmap bitmap = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_operate);

        mImageView = (ImageView) findViewById(R.id.imageView);
    }

    /**
     * 获取raw目录下的文件
     *
     * @param view
     */
    public void getRawImage(View view) {
        InputStream inputStream = getResources().openRawResource(R.raw.raw_10);
        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
        mImageView.setImageBitmap(bitmap);
    }

    /**
     * 获取asset 目录下的文件
     *
     * @param view
     */
    public void getAssetsImage(View view) {
        AssetManager manager = getAssets();
        InputStream inputStream = null;
        try {
            inputStream = manager.open("asset_10.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (inputStream != null) {
            bitmap = BitmapFactory.decodeStream(inputStream);
            mImageView.setImageBitmap(bitmap);
        }
    }

    /**
     * 获取SD卡下的图片
     *
     * @param view
     */
    public void getSDImage(View view) {
        File picDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File[] pics = picDir.listFiles();
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(pics[2]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        bitmap = BitmapFactory.decodeStream(inputStream);
        mImageView.setImageBitmap(bitmap);
    }


    /**
     * 缩小图片
     *
     * @param view
     */
    public void reduceImage(View view) {
        InputStream inputStream = getResources().openRawResource(R.raw.raw_10);
        BitmapFactory.Options options = new BitmapFactory.Options();
        //如果我们把inJustDecodeBounds设为true，那么BitmapFactory.decode时并不会真的返回一个Bitmap给你，它仅仅会把它的宽，高取回来给你，这样就不会占用太多的内存，也就不会那么频繁的发生OOM了。
        options.inJustDecodeBounds = false;
        //载入的缩略图是原图大小的1/4,inSampleSize只能是2的整数次幂，如果不是的话，向下取得最大的2的整数次幂
        options.inSampleSize = 2;
        //为了节约内存我们还可以使用下面的几个字段：ALPHA_8,RGB_565, ARGB_4444, ARGB_8888
        options.inPreferredConfig = Bitmap.Config.ARGB_4444;    // 默认是Bitmap.Config.ARGB_8888
        bitmap = BitmapFactory.decodeStream(inputStream, null, options);

        mImageView.setImageBitmap(bitmap);
    }

}
