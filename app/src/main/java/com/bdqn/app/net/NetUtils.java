package com.bdqn.app.net;

import android.text.TextUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/**
 * 使用HttpUrlConnection 进行网络访问。
 * <p>
 * HttpURLConnectin 的使用步骤：
 * <li>1.首先需要一个URL地址。</li>
 * <li>2.然后通过URL获取到一个HttpURLConnection实例，通过调用openConnection()方法可以获得HttpURLConnection实例。</li>
 * <li>3.得到HttpURLConnection实例后。我们需要设置一下http请求的各种参数，例如设置请求方法，连接超时的时间等。</li>
 * <li>4.获取服务器返回的输入流，使用getInputStream方法获取。</li>
 * <li>5.读取内容并处理</li>
 * <li>6.关闭连接，通过调用disconnect方法关闭当前的连接。</li>
 * <p>
 * 记得一定要在AndroidMenifest.xml 里加入访问网络的权限：<uses-permission android:name="android.permission.INTERNET"/>
 */
public class NetUtils {

    private final String ENCODING = "UTF-8";
    private final int TIMEOUT_MS = 5000;

    public String get(String url) throws IOException {
        HttpURLConnection connection = openConnection(url);
        //使用GET请求
        connection.setRequestMethod("GET");
        return getContent(connection);
    }

    /**
     * 通过读取 HttpURLConnection的输入流，来获取请求内容
     *
     * @param connection
     * @return
     * @throws IOException
     */
    private String getContent(HttpURLConnection connection) throws IOException {
        StringBuilder builder = new StringBuilder();
        //返回码是否为200
        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            //获取输入流
            InputStream inputStream = connection.getInputStream();
            int len = 0;
            byte[] buffer = new byte[1024];
            while ((len = inputStream.read(buffer)) != -1) {
                builder.append(new String(buffer, 0, len));
            }
        }
        return builder.toString();
    }


    public String post(String url, Map<String, String> parames) throws IOException {
        if (parames == null && parames.isEmpty()) {
            return get(url);
        }
        //获取参数的byte[]
        byte[] data = getParamsBody(parames);
        HttpURLConnection connection = openConnection(url);
        //使用POST请求
        connection.setRequestMethod("POST");

        //setDoOutput 设置为true后才能写入参数
        //设置 内容类型
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        //设置 内容得长度
        connection.setRequestProperty("Content-Length", String.valueOf(data.length));
        //通过HttpURLConnection 的输出流 将POST请求的参数传递出去
        OutputStream outputStream = connection.getOutputStream();
        //将参数写入到 HttpURLConnection 的输出流里
        outputStream.write(data);
        return getContent(connection);
    }


    private HttpURLConnection openConnection(String url) throws IOException {
        //获得URL对象
        URL parseURL = new URL(url);
        //获得HttpURLConnection对象
        HttpURLConnection connection = (HttpURLConnection) parseURL.openConnection();
        //设置连接超时
        connection.setConnectTimeout(TIMEOUT_MS);
        //设置读取超时时间
        connection.setReadTimeout(TIMEOUT_MS);
        //不使用缓存
        connection.setUseCaches(false);
        //设置是否从httpUrlConnection读入，默认情况下是true;
        connection.setDoInput(true);
        //设置httpUrlConnection是否可以输出数据，默认情况下是false;
        connection.setDoOutput(true);
        return connection;
    }


    /**
     * 获取 POST方法的参数的byte[]
     *
     * @param params
     * @return
     * @throws UnsupportedEncodingException
     */
    private byte[] getParamsBody(Map<String, String> params) throws UnsupportedEncodingException {
        StringBuilder encodedParams = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            encodedParams.append(URLEncoder.encode(entry.getKey(), ENCODING));
            encodedParams.append('=');
            if (!TextUtils.isEmpty(entry.getValue())) {
                encodedParams.append(URLEncoder.encode(entry.getValue(), ENCODING));
            } else {
                encodedParams.append(URLEncoder.encode("", ENCODING));
            }
            encodedParams.append('&');
        }

        return encodedParams.toString().getBytes();
    }

}
