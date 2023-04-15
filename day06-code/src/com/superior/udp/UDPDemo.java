package com.superior.udp;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class UDPDemo {

    //发送端
    @Test
    public void sender() throws IOException {

        //1.创建DatagramSocket实例
        DatagramSocket ds = new DatagramSocket();

        //将数据,目的地ip和端口号封装在DatagramSocket数据报中
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        int port = 9898;

        byte[] bytes = "我是发送端.".getBytes(StandardCharsets.UTF_8);

        //构建数据报
        DatagramPacket packet = new DatagramPacket(bytes,0,bytes.length,inetAddress,port);

        ds.send(packet);

        ds.close();

    }

    //接收端
    @Test
    public void receiver() throws IOException {

        //1.创建DatagramSocket实例
        int port = 9898;
        DatagramSocket ds = new DatagramSocket(port);

        //2.创建数据报对象,用于接收发送端发送过来的数据
        byte[] buffer = new byte[1024 * 64];
        DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);

        //3.接收数据
        ds.receive(packet);

        //4.获取数据,并打印到控制台上
        String str = new String(packet.getData(),0,packet.getLength());
        System.out.println(str);

        ds.close();

    }
}
