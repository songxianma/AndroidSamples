package com.bdqn.sample.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *字节流简单示例
 */
public class InputStreamAndOutputStreamDemo {

    public static void main(String[] args) {
//        createAndWriteFile();

//        createAndWriteFile1();

        createAndWriteFileUseBuffer();
    }


    /**
     * 使用FileOutputStream 和 FileInputStream 来读写图片文件
     */
    public static void createAndWriteFile() {
        try {
            File file = new File("huawei.jpg");
            File file1 = new File("huaweiInterview_1.jpg");

            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file1);
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, len);
            }

            fileOutputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 使用FileOutputStream 和 FileInputStream 来读写文本文件
     */
    public static void createAndWriteFile1() {
        try {
            File file = new File("myFile");
            File file1 = new File("file_1.txt");
            //根据文件路径获取输入流，如果文件找不到，会抛出FileNotFoundException
            FileInputStream fileInputStream = new FileInputStream(file);
            //根据文件路径创建输出流，如果文件不存在，就创建文件
            FileOutputStream fileOutputStream = new FileOutputStream(file1);

            byte[] buffer = new byte[1024];
            int len = 0;
            // 每一次都将读取到的内容存储到buffer数组里
            while ((len = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, len);
                //打印读取到的内容
                System.out.print(new String(buffer, 0, len));
            }

            fileOutputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 通过缓冲读取文件
     */
    private static void createAndWriteFileUseBuffer() {
        FileInputStream fileInputStream = null;
        BufferedInputStream bufferedInputStream = null;

        FileOutputStream fileOutputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            //根据文件路径获取输入流，如果文件找不到，会抛出FileNotFoundException
            fileInputStream = new FileInputStream("huawei.jpg");
            //根据文件输入流创建缓冲输入流
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            fileOutputStream = new FileOutputStream("huaweiInterview_2.jpg");
            //根据文件输出流创建缓冲输出流
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            byte[] buffer = new byte[1024];
            int len = 0;
            // 每一次都将读取到的内容存储到buffer数组里
            while ((len = bufferedInputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer, 0, len);
            }
            //带有缓存的流对象都要调用flush
            bufferedOutputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


}
