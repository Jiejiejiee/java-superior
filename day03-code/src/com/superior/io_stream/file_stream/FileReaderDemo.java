package com.superior.io_stream.file_stream;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {

    /**异常处理方式使用throws IOException不太合适
     *
     @Test
     public void test() throws IOException {

     //1.创建file类的对象,对应着hellow.txt文件
     File file = new File("hellow.txt");
     //        System.out.println(file.exists());

     //2.创建输入型的字符流,用于读取数据
     FileReader fileReader = new FileReader(file);

     //3.读取数据,并显示在控制台上
     //        System.out.println((char) fileReader.read());

     //方式一:
     //        int data = fileReader.read();
     //        while (data != -1){
     //
     //            System.out.print((char) data);
     //            data = fileReader.read();
     //
     //        }

     //方式二:
     int data;
     while ((data = fileReader.read()) != -1){
     System.out.print((char) data);
     }

     //4.流资源关闭操作(必须要关闭,否则会资源泄露)
     fileReader.close();

     }
     */
    @Test
    public void test1() throws IOException {

        //1.创建file类的对象,对应着hellow.txt文件
        File file = new File("hellow.txt");
        //        System.out.println(file.exists());

        //2.创建输入型的字符流,用于读取数据
        FileReader fileReader = new FileReader(file);

        //3.读取数据,并显示在控制台上
        //        System.out.println((char) fileReader.read());

        //方式一:
        //        int data = fileReader.read();
        //        while (data != -1){
        //
        //            System.out.print((char) data);
        //            data = fileReader.read();
        //
        //        }

        //方式二:
        int data;
        while ((data = fileReader.read()) != -1){
            System.out.print((char) data);
        }

        //4.流资源关闭操作(必须要关闭,否则会资源泄露)
        fileReader.close();

    }

    @Test
    public void test2() {

        FileReader fileReader = null;
        try {
            //1.创建file类的对象,对应着hellow.txt文件
            File file = new File("hellow.txt");
//        System.out.println(file.exists());

            //2.创建输入型的字符流,用于读取数据
            fileReader = new FileReader(file);

            //3.读取数据,并显示在控制台上
//        System.out.println((char) fileReader.read());

            //方式一:
//        int data = fileReader.read();
//        while (data != -1){
//
//            System.out.print((char) data);
//            data = fileReader.read();
//
//        }

            //方式二:
            int data;
            while ((data = fileReader.read()) != -1){
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流资源关闭操作(必须要关闭,否则会资源泄露)
            try {
                if (fileReader != null)
                    fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //前两个方法每次只读一个字符,效率低
    @Test
    public void test3() {

        FileReader fileReader = null;
        try {
            //1.创建file类的对象,对应着hellow.txt文件
            File file = new File("hellow.txt");
//        System.out.println(file.exists());

            //2.创建输入型的字符流,用于读取数据
            fileReader = new FileReader(file);

            //3.读取数据,并显示在控制台上
            //每次读取多个字符存放到字符数组中
            char[] cbuffer = new char[5];
            int len = 0;
            while ((len = fileReader.read(cbuffer)) != -1) {
                //遍历数组

                //错误写法,会造成数组中的字符多输出
//                for (int i = 0; i < cbuffer.length; i++) {
//                    System.out.print(cbuffer[i]);
//            }

                for (int i = 0; i < len; i++) {
                    System.out.print(cbuffer[i]);
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流资源关闭操作(必须要关闭,否则会资源泄露)
            try {
                if (fileReader != null)
                    fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
