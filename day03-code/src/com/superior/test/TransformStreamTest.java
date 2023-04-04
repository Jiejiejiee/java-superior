package com.superior.test;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;

public class TransformStreamTest {


    @Test
    public void test() throws IOException {

        File file1 = new File("dbcp_gbk.txt");
        File file2 = new File("C:\\Users\\Li Wenjie\\Desktop\\dbcp_gbk_utf8.txt");

        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream(file2);

        InputStreamReader isr = new InputStreamReader(fis,"GBK");
        OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF8");

        char[] cBuffer = new char[1024];
        int len;
        while ((len = isr.read(cBuffer)) != -1){

            osw.write(cBuffer,0,len);

        }

        osw.close();
        isr.close();


    }

}
