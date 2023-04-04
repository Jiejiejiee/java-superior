package com.superior.io_stream.buffer_stream;

import org.junit.Test;

import java.io.*;

public class BufferStreamDemo {

    @Test
    public void test1() {

        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            fis = null;
            fos = null;

            //1.创建file类的对象
            File srcFile = new File("image.jpg");
            File destFile = new File("image_copy.jpg");

            //2.创建相关的字节流,缓冲流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3.数据的读入和写出
            byte[] bdata = new byte[1024];//1kb
            int len;
            while ((len = bis.read(bdata)) != -1) {

                bos.write(bdata, 0, len);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流资源
            //外层流的关闭,也会自动对内层流进行关闭,内存流的关闭可以省略
            if (bos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
//        //内层流的关闭
//        if (fos != null)
//            fos.close();
//        if (fis != null)
//            fis.close();
        }

    }

}
