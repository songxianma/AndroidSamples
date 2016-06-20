package com.bdqn.app.net;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.bdqn.app.R;
import com.bdqn.app.utils.LogUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 */
public class NetSampleActivity extends AppCompatActivity {

    private TextView mTvContent;
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_sample);

        mTvContent = (TextView) findViewById(R.id.tvContent);
        mWebView = (WebView) findViewById(R.id.wvContent);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setSupportZoom(false);
        mWebView.getSettings().setBuiltInZoomControls(false);
        mWebView.getSettings().setDefaultTextEncodingName("utf-8") ;
        mWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        mWebView.getSettings().setDefaultFontSize(18);

        new Thread(new Runnable() {
            @Override
            public void run() {
                String result = get();
                LogUtils.e(result);
                Message msg = new Message();
                msg.what = 1;
                msg.obj = result;
                myHandler.sendMessage(msg);
            }
        }).start();
    }

    private Handler myHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    mWebView.loadData(msg.obj.toString(), "text/html; charset=UTF-8", "utf-8");
//                    mTvContent.setText(Html.fromHtml(msg.obj.toString()));
                    mTvContent.setText(msg.obj.toString());
                    break;
            }
        }
    };


    private String get() {
        String urlString = "https://www.baidu.com/";
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            InputStream inputStream = connection.getInputStream();

            StringBuilder builder = new StringBuilder();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(buffer)) != -1) {
                builder.append(new String(buffer, 0, len));
            }

            return builder.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return urlString;
    }


}
