package com.superior.io_stream.file_stream;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*

    输出时,文件可以不存在,程序会帮我们自动创建

    *字符流不适合处理非文本文件

 */
public class FileWriterDemo {
    //文件内容写入
    @Test
    public void test1() {
        FileWriter fileWriter = null;

        try {

            //1.创建file类的对象,指明要写入的文件名称
            File file2 = new File("info.txt");

            //2.创建输出流
//            fileWriter = new FileWriter(file2);//文件覆盖
            fileWriter = new FileWriter(file2, true);//文件内容追加

            //3.写出具体过程:write(String str)  /  write(char[] cdata)
            fileWriter.write("abcdefg\n");
            fileWriter.write("hijklmn\n");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            //4.关闭资源
            try {
                if (fileWriter != null)
                    fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }

    //复制一份hello.txt,命名为hello_copy.txt文件
    @Test
    public void test2() {
        FileReader fr = null;
        FileWriter fw = null;

        try {
            //1.创建file对象
            File file1 = new File("hello.txt");
            File file2 = new File("hello_copy.txt");

            //2.创建输入流,输出流
            fr = new FileReader(file1);
            fw = new FileWriter(file2);

            //3.数据的读入和写出
            char[] cdata = new char[5];
            int len;//记录每次读入到cdata中的字符个数
            while ((len = fr.read(cdata)) != -1) {

                //错误写法
//                fw.write(cdata);

                //write(char[] cdata,int fromIndex,int len)
                fw.write(cdata, 0, len);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流资源
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
