package com.superior.io_stream.transform_stream;

import org.junit.Test;

import java.io.*;

public class OutputStreamWriterDemo {

    @Test
    public void test1() throws IOException {

        File file1 = new File("dbcp_gbk.txt");
        File file2 = new File("dbcp_gbk_to_utf8.txt");

//        FileInputStream fis = new FileInputStream(file1);
//        InputStreamReader isr = new InputStreamReader(fis);

//        FileOutputStream fos = new FileOutputStream(file2);
//        OutputStreamWriter osw = new OutputStreamWriter(fos);

        InputStreamReader isr = new InputStreamReader(new FileInputStream(file1),"GBK");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file2),"UTF8");

        char[] cBuffer = new char[1024];
        int len;
        while ((len = isr.read(cBuffer)) != -1){

            osw.write(cBuffer,0,len);

        }

        osw.close();
        isr.close();

    }

}
