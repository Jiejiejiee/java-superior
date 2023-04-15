package com.superior.tcp;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*

    从客户端发送文件给服务器,服务器保存到本地,并返回 "发送成功" 给客户端,并关闭相应的连接

 */
public class TCPDemo3 {

    //客户端
    @Test
    public void client() throws IOException {//涉及到资源的关闭,应使用try-catch-finally结构处理异常

        //创建Socket
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        int port = 9898;

        Socket socket = new Socket(inetAddress,port);

        //创建File实例,FileInputStream实例
        FileInputStream fis = new FileInputStream("image.png");

        //通过Socket,获取输出流
        OutputStream os = socket.getOutputStream();

        //读写数据
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fis.read(buffer)) != -1){
            os.write(buffer,0,len);
        }

        System.out.println("数据发送完毕.");

        //表明客户端不再发送数据了,防止服务端一直等待客户端造成死锁
        socket.shutdownOutput();

        //接收来自服务端的信息
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] endBuffer = new byte[5];
        int endLen;
        while ((endLen = is.read(endBuffer)) != -1){
            baos.write(endBuffer,0,endLen);
        }

        System.out.println(baos.toString());

        //关闭资源
        baos.close();
        is.close();
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
        FileOutputStream fos = new FileOutputStream("image_copy1.png");

        //读写过程
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1){
            fos.write(buffer,0,len);
        }

        System.out.println("数据接收完毕.");

        //服务端发送信息给客户端
        OutputStream os = socket.getOutputStream();
        os.write("图片已接收.".getBytes());

        //关闭资源
        os.close();
        fos.close();
        is.close();
        socket.close();
        serverSocket.close();

    }

}
