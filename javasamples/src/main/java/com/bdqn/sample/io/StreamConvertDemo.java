package com.bdqn.sample.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

/**
 * 字符流和字节流之间的转换示例
 *
 * 当我们需要键盘录入的数据写入到一个文件中时，使用字节流不太方便，我们就可以使用转换流
 */
public class StreamConvertDemo {


    public static void main(String[] args) {
        try {
//            convertByteInputStream2TextReaderStream();

            convertByteOutputStream2TextWriterStream();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * 将字节输入流转换为字符输入流
     *
     * @throws IOException
     */
    private static void convertByteInputStream2TextReaderStream() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("myFile");
        //InputStreamReader 是将字节流转换为字符流的桥梁；它会在读取流之后会再次读取编码表，所有会有一个编码类型
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, Charset.defaultCharset());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.print(line);
        }

        bufferedReader.close();
        inputStreamReader.close();
        fileInputStream.close();
    }


    /**
     * 将字节输流转换为字符流
     *
     * @throws IOException
     */
    private static void convertByteOutputStream2TextWriterStream() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("myFile");
        FileOutputStream fileOutputStream = new FileOutputStream("myFile_2");

        //InputStreamReader 是字节流通向字符流的桥梁：它使用指定的 charset 读取字节并将其解码为字符。它使用的字符集可以由名称指定或显式给定，或者可以接受平台默认的字符集。
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, Charset.defaultCharset());
        //OutputStreamWriter 是字符流通向字节流的桥梁：可使用指定的 charset 将要写入流中的字符编码成字节。它使用的字符集可以由名称指定或显式给定，否则将接受平台默认的字符集。
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            bufferedWriter.write(line);
        }

        bufferedReader.close();
        bufferedWriter.flush();
        bufferedWriter.close();
        inputStreamReader.close();
        outputStreamWriter.close();
        fileInputStream.close();
        fileOutputStream.close();
    }


}
