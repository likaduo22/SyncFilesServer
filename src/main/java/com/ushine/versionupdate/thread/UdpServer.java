package com.ushine.versionupdate.thread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author CHL
 * @Date 2021/6/21 14:25
 */
@Component
@Slf4j
public class UdpServer {

    @Value(value = "${version.num}")
    private int num;
   // @PostConstruct
   void initUdp() {

        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(8800);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        byte[] data = new byte[1024];
        DatagramPacket packet = new DatagramPacket(data, data.length);

        log.info(".....UDP服务器启动......");
        int count = 0;
        String info ;

        while (true) {

            try {
                socket.receive(packet);
                log.info("udp客户端已连接!");
                info = new String(data, 0, packet.getLength());
                log.info("收到"+packet.getAddress()+"的版本号："+info);
                log.info("服务端版本号:"+num);
                count++;

                UdpReceive udpServerThread = new UdpReceive(packet,info,num);
                udpServerThread.run();

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


            //String info = new String(data, 0, packet.getLength());
            //System.out.println("我是服务器,客户端说:" + info);
          //  System.out.println("该客户端IP地址为:" + packet.getAddress());
            System.out.println("udp客户端:"+packet.getAddress()+"连接次数:" + count);
        }
    }

}