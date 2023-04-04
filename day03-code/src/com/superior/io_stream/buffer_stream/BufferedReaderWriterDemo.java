package com.superior.io_stream.buffer_stream;

import org.junit.Test;

import java.io.*;

public class BufferedReaderWriterDemo {

    @Test
    public void test1() throws IOException {

        File file = new File("info.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        char[] cBuffer = new char[1014];
        int len;

        while ((len = br.read(cBuffer)) != -1) {

            //方法1:
//            for (int i = 0; i < len; i++) {
//                System.out.println(cBuffer[i]);
//            }

            //方法2:
            String str = new String(cBuffer,0,len);
            System.out.println(str);

        }

        br.close();

    }

    @Test
    public void test2() throws IOException {

        File file = new File("info.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String data;

        while ((data = br.readLine()) != null) {

            System.out.println(data);

        }

        br.close();

    }

    //使用BufferedReder和BufferedWriter实现文本文件的复制
    @Test
    public void test3() throws IOException {

        File file1 = new File("info.txt");
        File file2 = new File("info_copy.txt");

        BufferedReader br = new BufferedReader(new FileReader(file1));
        BufferedWriter bw = new BufferedWriter(new FileWriter(file2));

        String data;
        while ((data = br.readLine()) != null){

//            bw.write(data + "\n");//换行

            bw.write(data);
            bw.newLine();//换行

            bw.flush();//刷新,每当调用此方法时,就会主动将内存中的数据写出到磁盘文件中

        }

        bw.close();
        br.close();

    }

}
