package com.superior.url;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/*

    将url代表的资源下载到本地

 */
public class URLDemo2 {

    @Test
    public void test() throws IOException {

        URL url = new URL("http://localhost:8080/examples/image.jpg");

        //创建URLConnection实例,建立与服务器的连接
        URLConnection urlConnection = (HttpURLConnection) url.openConnection();

        //获取输入流,创建输出流
        InputStream is = urlConnection.getInputStream();
        File file = new File("dest.png");
        FileOutputStream fos = new FileOutputStream(file);

        //读写数据
        byte[] bytes = new byte[1024];
        int len;
        while ((len = is.read(bytes)) != -1){
            fos.write(bytes,0,len);
        }

        System.out.println("文件下载完成.");

        //关闭资源
        fos.close();
        is.close();
        ((HttpURLConnection) urlConnection).disconnect();

    }

}
