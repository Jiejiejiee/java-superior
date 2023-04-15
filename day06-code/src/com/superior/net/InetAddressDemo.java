package com.superior.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*

    InetAddress类的一个实例就代表一个IP地址

        实例化:

                InetAddress getByName(String host)
                InetAddress getLocalHost()

 */
public class InetAddressDemo {

    public static void main(String[] args) {

        //实例化;InetAddress getByName(String host)
        try {
            //获取指定IP对应的InetAddress的实例
            InetAddress inet1 = InetAddress.getByName("192.168.21.1");
            System.out.println(inet1);

            InetAddress inet2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inet2);//www.baidu.com/14.119.104.254; DNS域名解析

            System.out.println(inet1.getHostName());//192.168.21.1
            System.out.println(inet1.getHostAddress());//192.168.21.1

            System.out.println(inet2.getHostName());//www.baidu.com
            System.out.println(inet2.getHostAddress());//14.119.104.254


            //获取本地IP对应的InetAddress的实例
            InetAddress inet3 = InetAddress.getByName("127.0.0.1");
            System.out.println(inet3);

            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost);




        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


    }

}
