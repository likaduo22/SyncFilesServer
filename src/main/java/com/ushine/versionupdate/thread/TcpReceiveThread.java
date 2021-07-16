package com.ushine.versionupdate.thread;

import lombok.extern.slf4j.Slf4j;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author CHL
 * @Date 2021/6/22 11:14
 */

@Slf4j
public class TcpReceiveThread extends Thread{

    private int num;

    private Socket socket;

    TcpReceiveThread(Socket socket, int num) {
        this.socket = socket;
        this.num = num;
    }

    @Override
    public void run() {

        try {
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            String s = dataInputStream.readUTF();

            DataOutputStream dos=new DataOutputStream(socket.getOutputStream());

            if(!s.equals(num+"")){

                dos.writeUTF("ok");
                dos.flush();

                new Thread(new TcpSendThread(socket)).start();
            }else {
                dos.writeUTF("不需要");
                dos.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
