package com.ushine.versionupdate.testTcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author CHL
 * @Date 2021/6/17 11:12
 */
public class TestTcpRevice {


    void client() throws IOException { // 连接套接字方法

        //服务端

        // 创建一个Socket对象
        ServerSocket ss = new ServerSocket(9100);
        Socket socket = ss.accept();

        // 创建本地的流
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\360MoveData\\Users\\Administrator\\Desktop\\西信部署环境依赖\\00.jar"));

        // 网络上面的流
        InputStream is = socket.getInputStream();

        int data;
        while ((data = is.read()) != -1){
            bos.write(data);
        }

        PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        pw.println("接收完毕！");
        pw.flush();

        // 释放资源
        bos.close();
        socket.close();
        ss.close();
    }


    public static void main(String[] args) throws IOException { // 主方法
        TestTcpRevice clien = new TestTcpRevice(); // 创建本例对象
        clien.client(); // 调用连接方法
    }


}
