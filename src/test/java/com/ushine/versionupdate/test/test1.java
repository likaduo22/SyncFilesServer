package com.ushine.versionupdate.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketAddress;

/**
 * @author CHL
 * @Date 2021/6/17 10:19
 */
public class test1 {

    public static void main(String[] args) throws IOException {
        //接收来自服务端的消息
        DatagramSocket socket = new DatagramSocket(8686);
     //   DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
        byte[] bys = new byte[1024];

     /*   while (true) {
            socket.receive(packet);
            byte[] arr = packet.getData();
            InetAddress ip = packet.getAddress();
            int length = packet.getLength();
            int port = packet.getPort();
            System.out.println(ip + ":" + port + "->" + new String(arr, 0, length, "UTF-8"));
        }*/

        DatagramPacket dp = new DatagramPacket(bys, bys.length);
        socket.receive(dp);
        String s = new String(bys, 0, dp.getLength());
        /*FileOutputStream fos = new FileOutputStream("G:\\workSpace\\Month07\\Knowledgereview\\src\\UDP\\UDPsendfile\\b.txt");
        System.out.println("开始向本地文件写入");
        fos.write(s.getBytes());
        fos.close();*/
       // BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\360MoveData\\Users\\Administrator\\Desktop\\西信部署环境依赖\\test.jar"));
        //bos.write(bys);
        System.out.println("展示接收到的文件");
        System.out.println("接收到的数据是:"+s);

        InetAddress address = dp.getAddress();
        SocketAddress socketAddress = dp.getSocketAddress();

        System.out.println(socketAddress);


        // bos.close();
    }
}
