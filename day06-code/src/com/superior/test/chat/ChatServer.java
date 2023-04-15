package com.superior.test.chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import static com.superior.test.chat.ChatServer.online;

public class ChatServer {


    //使用集合来存储所有在线的客户端
    static ArrayList<Socket> online = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        //1.启动服务器,绑定端口号
        ServerSocket serverSocket = new ServerSocket(9898);

        //2.接收多个客户端同时连接
        while (true){

            Socket socket = serverSocket.accept();

            online.add(socket);//把新连接的客户端添加到online列表中

            //线程负责获取socket中的数据,并分发给当前聊天室的所有客户端
            MessageHandler mh = new MessageHandler(socket);
            mh.start();

        }

    }

}

class MessageHandler extends Thread{

    private Socket socket;
    private String ip;

    public MessageHandler(Socket socket) {
        super();
        this.socket = socket;
    }

    public void run(){

        try {
            ip = socket.getInetAddress().getHostAddress();

            //插入:给其他用户转发"用户上线"
            sendToOther(ip+"上线了!");

            //(1)接收该用户端的发送信息
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String str;
            while ((str = br.readLine()) != null){
                //(2)转发给其他客户端
                sendToOther(ip+":"+str);
            }

            //转发该用户下线
            sendToOther(ip+"下线了!");
        } catch (IOException e) {
            try {
                sendToOther(ip+"掉线了");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } finally {
            //从在线用户中移除
            online.remove(socket);
        }


    }

    public void sendToOther(String message) throws IOException {

        for (Socket on : online){

            OutputStream every = on.getOutputStream();

            //使用PrintStream,调用其中的按行打印方法;println()
            PrintStream ps = new PrintStream(every);

            ps.println(message);

        }

    }

}
