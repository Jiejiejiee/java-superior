package com.superior.test.chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

    public static void main(String[] args) throws IOException, InterruptedException {

        //1.连接服务器
        Socket socket = new Socket("127.0.0.1",9898);

        //2.开启两个线程
        //(1)线程负责接受服务器转发的消息
        Receive receive = new Receive(socket);
        receive.start();

        //(2)线程负责发送消息
        Send send = new Send(socket);
        send.start();

        send.join();

        socket.close();


    }

}

class Send extends Thread{

    private Socket socket;

    public Send(Socket socket){

        super();
        this.socket = socket;

    }

    public void run(){

        try {
            Scanner input = new Scanner(System.in);

            OutputStream os = socket.getOutputStream();

            //按行打印
            PrintStream ps = new PrintStream(os);

            //从键盘不断输入自己的话,发送给服务器,由服务器转发给其他人
            while (true){

                System.out.print("自己说的:");
                String str = input.nextLine();

                if ("bye".equals(str)){
                    break;
                }

                ps.println(str);

            }
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

class Receive extends Thread{

    private Socket socket;

    public Receive(Socket socket) {
        super();
        this.socket = socket;
    }

    public void run(){

        try {
            InputStream is = socket.getInputStream();
            Scanner input = new Scanner(is);

            while (input.hasNextLine()){

                String line = input.nextLine();
                System.out.println(line);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}