package com.bdqn.sample.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符流的基本示例
 */
public class FileWriterAndReaderDemo {

    public static final String LINE_SEPARATER = System.getProperty("line.separator");


    public static void main(String[] args) {
        createAndWriteStrings();
        appendToFile();

        readFiles();
        readFilesByBuffer();


        readAndWrite();
    }


    /**
     * 使用FileWriter创建文件，并且往该文件中写入文本数据。
     */
    public static void createAndWriteStrings() {
        FileWriter fileWriter = null;
        try {
            //使用FileWriter,来创建文件，如果该文件存在会被覆盖，不存在会被创建
            fileWriter = new FileWriter("test.txt");
            //写入字符串，它会把数据写入到临时缓冲区
            fileWriter.write("abcdefg");
            fileWriter.write(LINE_SEPARATER);//写入一个Windows下的换行符"\r\n",如果在Linux下，只需使用"\n"
            fileWriter.write("hahahah");
            //刷新该流的缓冲
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    //关闭此流，但要先刷新它。在关闭该流之后，再调用 write() 或 flush() 将导致抛出 IOException。关闭以前关闭的流无效。
                    fileWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException("关闭失败");
                }
            }
        }
    }

    public static void appendToFile() {
        FileWriter fileWriter = null;
        try {
            //使用FileWriter,来创建文件，如果该文件存在，并且第二个参数如果为true;则可以对文件进行续写
            fileWriter = new FileWriter("test.txt", true);
            //写入字符串，它会把数据写入到临时缓冲区
            fileWriter.write("123456");
            fileWriter.write(LINE_SEPARATER);//写入一个Windows下的换行符"\r\n",如果在Linux下，只需使用"\n"
            fileWriter.write("xixixixi");
            //刷新该流的缓冲
            fileWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                    //关闭此流，但要先刷新它。在关闭该流之后，再调用 write() 或 flush() 将导致抛出 IOException。关闭以前关闭的流无效。
                } catch (IOException e) {
                    throw new RuntimeException("关闭失败");
                }
            }
        }
    }

    /**
     * 读取文件
     * 一个一个的字符读取。
     */
    public static void readFiles() {
        //创建一个读取字符数据的流对象
        FileReader fileReader = null;
        try {
            //传入要读取的文件的路径，并且文件必须是存在的。
            fileReader = new FileReader("test.txt");
            //使用read() 读取字符,每调用一次就读取一个字符，其返回int值，需要char强转，如果读取到末尾没有内容了会返回-1.
            //作为整数读取的字符，范围在 0 到 65535 之间 (0x00-0xffff)，如果已到达流的末尾，则返回 -1
//            int ch = fileReader.read();.

            //读取的字符数
            int ch = 0;
            while ((ch = fileReader.read()) != -1) {
                System.out.print((char) ch);
            }

            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用数组作为缓存，读取文件。
     */
    public static void readFilesByBuffer() {
        System.out.println();
        System.out.println();
        System.out.println();

        FileReader reader = null;
        try {
            reader = new FileReader("test.txt");
            char[] buffer = new char[0124];
            //读取的字符数
            int len = 0;
            //将读取到数据缓存到buffer数组。
            while ((len = reader.read(buffer)) != -1) {
                System.out.print(new String(buffer, 0, len));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取某个文件，写入到另一个文件
     */
    public static void readAndWrite() {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("test1.txt");
            fileReader = new FileReader("test.txt");
            char[] buffer = new char[1024];
            //读取的字符数
            int len = 0;
            while ((len = fileReader.read(buffer)) != -1) {
                fileWriter.write(buffer, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileWriter.flush();
                fileWriter.close();
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
