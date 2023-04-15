package com.superior.tcp;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/*

    客户端发送文件给服务端,服务端将文件保存在本地

 */
public class TCPDemo2 {

    //客户端
    @Test
    public void client() throws IOException {//涉及到资源的关闭,应使用try-catch-finally结构处理异常

        //创建Socket
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        int port = 9898;

        Socket socket = new Socket(inetAddress,port);

        //创建File实例,FileInputStream实例
        FileInputStream fis = new FileInputStream(new File("image.png"));

        //通过Socket,获取输出流
        OutputStream os = socket.getOutputStream();

        //读写数据
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fis.read(buffer)) != -1){
            os.write(buffer,0,len);
        }

        System.out.println("数据发送完毕.");

        //关闭资源
        os.close();
        fis.close();
        socket.close();

    }

    //服务端
    @Test
    public void server() throws IOException {

        //创建ServerSocket
        int port = 9898;
        ServerSocket serverSocket = new ServerSocket(port);

        //接收来自于客户端的Socket
        System.out.println("服务器已开启.");
        Socket socket = serverSocket.accept();

        //通过Socket获取输入流
        InputStream is = socket.getInputStream();

        //将Socket中的文件输出,创建File实例,FileOutputStream实例
        File file = new File("image_copy.png");
        FileOutputStream fos = new FileOutputStream(file);

        //读写过程
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1){
            fos.write(buffer,0,len);
        }

        System.out.println("数据接收完毕.");

        //关闭资源
        fos.close();
        is.close();
        socket.close();
        serverSocket.close();

    }

}
