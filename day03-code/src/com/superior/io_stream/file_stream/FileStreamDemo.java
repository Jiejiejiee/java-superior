package com.superior.io_stream.file_stream;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


/*

    字节流通常是用来处理文本文件的,但是涉及到文本文件的复制操作,也可以使用字节流

            可能出现中文乱码 Test2()

 */
public class FileStreamDemo {

    //复制一份image.jpg,命名为image_copy.jpg
    @Test
    public void test1() {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            //1.创建file类的对象
            File srcFile = new File("image.jpg");
            File destFile = new File("image_copy.jpg");

            //2.创建相关的字节流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            //3.数据的读入和写出
            byte[] bdata = new byte[1024];//1kb
            int len;
            while ((len = fis.read(bdata)) != -1) {

                fos.write(bdata, 0, len);
                fos.flush();//刷新

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流资源
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    @Test
    public void test2() {
        FileInputStream fis = null;

        try {
            //1.创建file类的对象
            File srcFile = new File("hello.txt");

            //2.创建相关的字节流
            fis = new FileInputStream(srcFile);

            //3.数据的读入和写出
            byte[] bdata = new byte[2];
            int len;
            while ((len = fis.read(bdata)) != -1) {

                String str = new String(bdata,0,len);
                System.out.print(str);//�����;出现乱码

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流资源
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
