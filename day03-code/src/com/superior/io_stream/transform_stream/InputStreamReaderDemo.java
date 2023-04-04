package com.superior.io_stream.transform_stream;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/*

    InputStreamReader & OutputStreamWriter

    解码时使用的字符集,必须与当初编码时使用的字符集相同
        解码集必须与编码集兼容,例如:gbk --> utf-8,如果文件中只有英文,也不会出现乱码.其都向下兼容了ASCii

    ascii:主要用来存储a,b,c等英文字符,常用的标点符号.每个字符占一个字节

    /iso-8859-1:每个字符占一个字节,向下兼容ascii

    gbk:常用的中文码表,存储中文简体繁体,英文和数字(每个字符占一个字节),使用了双字节编码方案,向下兼容ascii

    utf-8:世界主要语言,使用1-4个不等的字节表示一个字符,中文为3个字符

 */
public class InputStreamReaderDemo {

    @Test
    public void test1() throws IOException {

        File file = new File("dbcp_utf-8.txt");

        FileInputStream fis = new FileInputStream(file);
//        InputStreamReader isr = new InputStreamReader(fis);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");//显示的使用UTF-8字符集

        char[] cBuffer = new char[1024];
        int len;

        while ((len = isr.read(cBuffer)) != -1){

            String str = new String(cBuffer,0,len);
            System.out.println(str);

        }

        isr.close();

    }

    @Test
    public void test2() throws IOException {

        File file = new File("dbcp_gbk.txt");

        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis,"gbk");

        char[] cBuffer = new char[1024];
        int len;

        while ((len = isr.read(cBuffer)) != -1){

            String str = new String(cBuffer,0,len);
            System.out.println(str);

        }

        isr.close();

    }

}
