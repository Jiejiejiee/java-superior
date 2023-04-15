package com.superior.url;

import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo1 {

    @Test
    public void test() throws MalformedURLException {

//        String str = "http://127.0.0.1:8080/examples/image.jpg";
        String str = "http://localhost:8080/examples/image.jpg?name=lwj";

        URL url = new URL(str);

        //public String getProtocol( )   获取该URL的协议名
        String protocol = url.getProtocol();
        System.out.println(protocol);

        //public String getHost( )      获取该URL的主机名
        String host = url.getHost();
        System.out.println(host);

        //public String getPort( )      获取该URL的端口号
        int port = url.getPort();
        System.out.println(port);

        //public String getPath( )      获取该URL的文件路径
        String path = url.getPath();
        System.out.println(path);

        //public String getFile( )       获取该URL的文件名
        String file = url.getFile();
        System.out.println(file);

        //public String getQuery(  )    获取该URL的查询名
        String query = url.getQuery();
        System.out.println(query);

    }

}
