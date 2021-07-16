package com.ushine.versionupdate.testTcp;

import java.io.*;
import java.net.Socket;

/**
 * @author CHL
 * @Date 2021/6/17 11:11
 */
public class TestTcpServer {



    void serve() throws IOException {

        // 创建Socket对象。参数1：服务端ip地址。参数2：端口号
        Socket socket = new Socket("127.0.0.1",9100);

        // 创建需要传输的文件。参数：文件
        FileInputStream fs = new FileInputStream("E:\\360MoveData\\Users\\Administrator\\Desktop\\西信部署环境依赖\\xq-showroom-0.0.1-SNAPSHOT.jar");
        // 创建本地流
        BufferedInputStream bis = new BufferedInputStream(fs);


        // 网络上面的流
        OutputStream os = socket.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(os);

        //写到服务器
        int data;
        while ((data = bis.read()) != -1){
            bos.write(data);
        }
        bos.flush();

        // 给服务器一个结束标志，表示数据已经传输完毕
        socket.shutdownOutput();

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String str;
        while ((str = br.readLine()) != null){
            System.out.println(str);
        }


        // 释放资源
        socket.close();
        os.close();
        bis.close();
    }

    public static void main(String[] args) throws IOException {

        TestTcpServer tcp = new TestTcpServer(); // 创建本类对象
        tcp.serve(); // 调用方法
    }



}
