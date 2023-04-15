package com.superior.tcp;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*

    构建一个客户端,一个服务端.
        客户端发送内容给服务端,服务端将内容打印到控制台上.

 */
public class TCPDemo1 {

    //客户端
    @Test
    public void client() {

        Socket socket = null;
        OutputStream os = null;
        try {
            //声明对方的IP地址；192.168.2.229
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            //声明对方的端口号
            int port = 8989;

            //创建一个Socket
            socket = new Socket(inetAddress, port);

            //发送数据
            //注:此处发送的数据是Byte数据流,易造成乱码;解决方案见服务端
            os = socket.getOutputStream();
            os.write("你好,我是客户端.".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭Socket
            try {
                if (os != null)
                    os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    //服务端
    @Test
    public void server() {

        ServerSocket serverSocket = null;
        Socket socket = null;//阻塞式的方法
        InputStream is = null;

        try {
            //声明端口号
            int port = 8989;

            //创建一个ServerSocket
            serverSocket = new ServerSocket(port);

            //调用accept(),接收客户端的Socket
            System.out.println("服务器已开启.");
            socket = serverSocket.accept();

            System.out.println("收到了来自于:" + socket.getInetAddress().getHostAddress() + "的连接");

            //接收数据
            is = socket.getInputStream();

            byte[] buffer = new byte[5];//此处,buffer读到了5个字节就放入String中转换,而汉字由3个字符组成,会造成乱码;

            //解决方法:使用字节数据输出流;内部维护了一个Byte[],
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            int len;
            while ((len = is.read(buffer)) != -1) {

//                String str = new String(buffer, 0, len);
//                System.out.print(str);

                baos.write(buffer, 0, len);

            }

            System.out.println(baos.toString());

            System.out.println("\n数据接收完毕");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭Socket,ServerSocket
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (serverSocket != null)
                    serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
