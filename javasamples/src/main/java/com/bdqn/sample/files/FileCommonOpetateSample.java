package com.bdqn.sample.files;

import java.io.File;
import java.io.IOException;

/**
 * 在JAVA里无论是文件夹还是文件都被统称为文件。
 * <p>
 * File类只提供操作文件及目录的方法，并不能访问文件的内容，所以他描述的是文件本身的属性;如果要访问文件本身，用到了我们要用IO流.
 * <p>
 * 构造方法：
 * File 文件名/目录名 = new File("文件路径字符串");
 * <p>
 * 相关方法：
 * 1.文件检查的相关方法：
 * <ul>
 * <li>boolean isDirectory()：判断File对象是不是目录
 * <li>boolean isFile()：判断File对象是不是文件
 * <li>boolean exists()：判断File对象对应的文件或目录是不是存在
 * <li>boolean canWrite()：判断FIle对象对应的文件或目录是否可写
 * <li>boolean canRead()：判断FIle对象对应的文件或目录是否可读
 * </ul>
 * 2.文件操作的相关方法
 * <ul>
 * <li>boolean createNewFile()：路径名指定的文件不存在时，创建一个新的空文件
 * <li>boolean delete()：删除File对象对应的文件或目录
 * </ul>
 * 3.目录操作的相关方法
 * <ul>
 * <li>boolean mkdir()：单层创建空文件夹,只会根据传入名文件名来创建，不会考虑文件名是否存在目录符号（“/”等）
 * <li>boolean mkdirs()：多层创建文件夹，会去判断文件名是否含有文件的符号，如果含有就会一层一层的创建下来。
 * <li>String[] list()：返回这个目录下的所有文件及子目录，只对目录/文件夹 有效
 * <li>File[] listFiles()：返回File对象表示的路径下的所有文件对象数组
 * </ul>
 * <p>
 * 4.访问文件相关方法
 * <ul>
 * <li>String getName()：获得文件或目录的名字
 * <li>String getPath() ：获得文件或目录的相对路径
 * <li>String getAbsolutePath()：获得文件目录的绝对路径
 * <li>String getParent()：获得对象对应的目录的父级目录
 * <li>long lastModified()：获得文件或目录的最后修改时间
 * <li>long length() ：获得文件内容的长度
 * <li>boolean renameTo("新名字")：重命名此对象的名字，成功返回true，否则返回false
 * </ul>
 */
public class FileCommonOpetateSample {
    public static final String fileName = "myFile";
    public static final String dirName = "dir";


    public static void main(String[] args) {
//        createFile();
//        createDir();
//        createDirPath();

        filterSampe();

    }

    /**
     * 创建文件
     */
    public static void createFile() {
        File file = new File(fileName);
        if (!file.exists()) {//如果文件不存在就新建
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 创建目录
     */
    public static void createDir() {
        File file = new File(dirName);
        if (!file.exists()) {
            file.mkdir();// 只创建传入的目录名
        }
    }

    /**
     * 创建目录
     */
    public static void createDirPath() {
        File file = new File("C:\\TestSpace\\AndroidTestSpace\\Sample\\dirPath\\test");
        if (!file.exists()) {
            file.mkdirs();// 根据传入的目录名一层一层的创建目录
        }
    }

    public static void deleteFile1() {
        File file = new File("C:\\TestSpace\\AndroidTestSpace\\Sample\\dirPath\\test");
        if (!file.exists()) {
            file.delete();// 根据传入的目录名一层一层的创建目录
        }
    }

    public static void deleteFile2() {
        File file = new File("C:\\TestSpace\\AndroidTestSpace\\Sample\\dirPath\\test");
        if (!file.exists()) {
            file.deleteOnExit();// 根据传入的目录名一层一层的创建目录
        }
    }

    public static void getFileInfo() {
        File file = new File(dirName);
        if (file.isDirectory()) {
            String[] files = file.list();
        } else if (file.isFile()) {
            String name = file.getName();
            String absolutePath = file.getAbsolutePath();
            String parentPath = file.getParent();
        }
    }

    public static void filterSampe() {
        String path = "C:\\"; // 路径不要含有中文

        File file = new File(path);
        File[] files = file.listFiles(new MyFilenameFilter("txt"));
//        File[] files = file.listFiles();

        for (File f :  files) {
            System.out.println(f.getName());
        }
    }


}
