package com.ushine.versionupdate.thread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author CHL
 * @Date 2021/6/21 15:20
 */
@Component
@Slf4j
public class TcpServer {

    @Value(value = "${version.num}")
    private int num;

    //@PostConstruct
    void initTcp() {
            try {
                ServerSocket server = new ServerSocket(9100);
                log.info("TCP服务器启动....");
                int count = 0;
                //如果有多个客户端连接上来，服务端重新为客户端分配线程，这是一个服务端对应多个客户端的关键
                while (true) {
                    count++;
                    Socket socket = server.accept();
                    System.out.println("tcp已经连接" + (count) + "客户端：" + socket.getRemoteSocketAddress());
                    //启动段服务端向客户端发送消息的进程
                    //new Thread(new TcpReceiveThread(socket,num)).start();
                    new Thread(new TcpSendThread(socket)).start();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


