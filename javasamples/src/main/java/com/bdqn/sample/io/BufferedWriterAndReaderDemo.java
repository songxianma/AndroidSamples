package com.bdqn.sample.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符流缓冲简单示例
 *
 * 为提高读写的效率，提供缓存的读写操作
 * <p/>
 * 缓冲必须有被缓冲的对象，就是流对象。缓冲对象在创建时必须有被缓存的对象。
 * <p/>
 * 带有缓存区的操作，一定要有刷新操作。
 * 带有缓存的流对象都要调用flush
 */
public class BufferedWriterAndReaderDemo {


    public static void main(String[] args) {
        createAndWrite();

        readFile();

        System.out.println();
        System.out.println();

        readLinesFile();

        readAndWrite();
    }

    public static void createAndWrite() {
        try {
            //使用FileWriter,来创建文件，如果该文件存在会被覆盖，不存在会被创建
            FileWriter fileWriter = new FileWriter("testBuffer.txt");
            //创建一个字符写入流的缓冲对象，并与指定的被缓冲流相关联
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            //将字符写入到缓冲区
            bufferedWriter.write("abcdef");
            //换行，该方法只有该对象有
            bufferedWriter.newLine();
            bufferedWriter.write("ghijklmn");
            bufferedWriter.flush();
            //关闭缓冲区其实关闭的被缓冲的对象
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void readFile() {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            //读取的位置，文本输入流
            fileReader = new FileReader("testBuffer.txt");
            //创建缓冲输入流，并与指定的被缓冲流相关联
            bufferedReader = new BufferedReader(fileReader);
            char[] buffer = new char[1024];
            //读取的字符数
            int len = 0;
            //将读取到数据缓存到buffer数组
            while ((len = bufferedReader.read(buffer)) != -1) {
                System.out.print(new String(buffer, 0, len));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void readLinesFile() {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            //读取的位置，文本输入流
            fileReader = new FileReader("testBuffer.txt");
            //创建缓冲输入流，并与指定的被缓冲流相关联
            bufferedReader = new BufferedReader(fileReader);
            String line = null;
            //一行一行的读取
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void readAndWrite() {
        FileReader fileReader = null;
        FileWriter fileWriter = null;

        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            fileReader = new FileReader("testBuffer.txt");
            bufferedReader = new BufferedReader(fileReader);

            fileWriter = new FileWriter("testBuffer1.txt");
            bufferedWriter = new BufferedWriter(fileWriter);

            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.flush();
                bufferedWriter.close();
                fileReader.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
