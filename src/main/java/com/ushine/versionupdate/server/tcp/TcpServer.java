/*
package com.ushine.versionupdate.server.tcp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

*/
/**
 * @author CHL
 * @Date 2021/6/17 15:30
 *//*

@Component
@Slf4j
public class TcpServer {

    @Value(value = "${version.port}")
    private int port;

    @Value(value = "${jar.path}")
    private String filePath;

    public void serve() throws IOException {


        //创建可缓存的线程池
        ExecutorService executor = Executors.newCachedThreadPool();

        ServerSocket service = null;

        //ServerSocket server = new ServerSocket(port);//创建  ServerSocket类

        try () {

            service = new ServerSocket(port);


        } catch (Exception e) {

            e.printStackTrace();
        }


        Socket socket = server.accept();

        // 创建需要传输的文件。参数：文件
        FileInputStream fs = new FileInputStream(filePath);
        // 网络上面的流
        OutputStream os = socket.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(os);

        //写到服务器
        byte[] data = new byte[1024];
        int i;
        int dataCounter = 0;
        while ((i = fs.read(data)) != -1) {
            bos.write(data, 0, i);
            dataCounter += i;
        }

        //String size = (fs.available() / 1000) + "k";

        log.info("服务端更新文件下发完毕!" + "文件长度:" + dataCounter);

        fs.close();
        os.flush();
        os.close();
        socket.close();
    }
}*/
