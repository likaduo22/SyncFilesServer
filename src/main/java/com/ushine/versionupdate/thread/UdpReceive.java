package com.ushine.versionupdate.thread;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author CHL
 * @Date 2021/6/21 14:26
 */

@Slf4j
public class UdpReceive extends Thread {

    private DatagramPacket datagramPacket;

    private String info;

    private int num;

    UdpReceive(DatagramPacket datagramPacket, String info,int num) {
        this.datagramPacket = datagramPacket;
        this.info = info;
        this.num = num;
    }

    //private static AtomicBoolean initialized = new AtomicBoolean(false);

    @Override
    public void run() {

        log.info("Address:::"+datagramPacket.getAddress());

        InetAddress inetAddress = datagramPacket.getAddress();

        int port2 = datagramPacket.getPort();

        byte[] data2;

        if (Integer.parseInt(info) != num) {

             data2 = "需要".getBytes();

        }else {

            data2 = "不需要".getBytes();
        }

        DatagramPacket datagramPacket2 = new DatagramPacket(data2, data2.length, inetAddress, port2);

        try (DatagramSocket socket = new DatagramSocket()) {

            socket.send(datagramPacket2);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
