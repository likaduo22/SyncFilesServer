package com.ushine.versionupdate.server.udp;

import lombok.extern.slf4j.Slf4j;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author CHL
 * @Date 2021/6/18 15:01
 */
//@Configuration
@Slf4j
public class Udp {

    /*@Resource
    private TcpServer tcpServer;*/
    //@PostConstruct
    public void udpClient() {

        try (
                // 1.创建服务器端DatagramSocket，指定端口
                DatagramSocket socket = new DatagramSocket(8800)
        ) {
            /*
             * 接收客户端发送的数据
             */
            // 2.创建数据报，用于接收客户端发送的数据
            byte[] data = new byte[1024];// 创建字节数组，指定接收的数据包的大小
            DatagramPacket packet = new DatagramPacket(data, data.length);
            // 3.接收客户端发送的数据
            log.info("****服务器端已经启动，等待客户端发送数据");
            socket.receive(packet);// 此方法在接收到数据报之前会一直阻塞
            // 4.读取数据
            String info = new String(data, 0, packet.getLength());

            log.info("我是服务器，客户端说：" + info);

            if (info.equals("需要更新嘛?")) {

                log.info("开始启动tcp服务端,准备下发更新文件!");

                /*
                 * 向客户端响应数据
                 */
                // 1.定义客户端的地址、端口号、数据
                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                byte[] data2 = "需要".getBytes();
                // 2.创建数据报，包含响应的数据信息
                DatagramPacket packet2 = new DatagramPacket(data2, data2.length, address, port);
                // 3.响应客户端
                socket.send(packet2);

               // tcpServer.serve();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
