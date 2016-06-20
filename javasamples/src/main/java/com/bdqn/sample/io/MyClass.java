package com.bdqn.sample.io;


import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 文件的操作分为读和写。根据读写的功能区分为输入流和输出流。如果再根据具体功能细分还可以分为字节输入流，字节输出流，字符输入流，字符输出流。
 * <p/>
 * 字节流分为字节输入流，字节输出流，它们的有两个顶级的抽象父类：InputStream 和 OutputStream.<br/>
 * 它们具体功能由各个子类完成，一般它们的子类都以Stream结尾。
 * <p/>
 * <p/>
 * 字符流分为字符输入流，字符输出流，它们的有两个顶级的抽象父类：Reader 和 Writer.
 * 它们具体功能由各个子类完成，一般字符输入流的子类都以Reader结尾。字符输出流的子类都以Writer结尾。
 */

public class MyClass {

    public static void main(String[] args) {
        try {
//            readKeyboard();

//            readKeyboardUpper();

            readKeyboardUseScanner();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 只读取一次
     *
     * @throws IOException
     */
    private static void readKeyboard() throws IOException {
        //系统的输入设备的输入流，不需要关闭
        InputStream inputStream = System.in;
        //该方法为阻塞方法
        int ch = inputStream.read();
        System.out.print(ch);
    }

    public static void readKeyboardUpper() throws IOException {
        InputStream inputStream = System.in;
        StringBuilder builder = new StringBuilder();
        int ch = 0;
        while ((ch = inputStream.read()) != -1) {
            builder.append((char) ch);
            System.out.print(builder.toString().toUpperCase());
            builder.delete(0, builder.length());
        }

    }

    public static void readKeyboardUseScanner() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.print(scanner.nextLine());
        }
    }


}
