package com.ushine.versionupdate.testTcp;

import java.io.*;
import java.net.InetAddress;

/**
 * @author CHL
 * @Date 2021/6/17 16:39
 */
public class TestReadFile {

    public static void main(String[] args) throws IOException {
/*
        File ctoFile = new File("E:\\360MoveData\\Users\\Administrator\\Desktop\\host\\host.txt");

        InputStreamReader rdCto = new InputStreamReader(new FileInputStream(ctoFile));

        BufferedReader bfReader = new BufferedReader(rdCto);

        String txtline = null;

        while ((txtline = bfReader.readLine()) != null) {

            System.out.println(txtline);

        }
        bfReader.close();*/

        InetAddress addr = InetAddress.getLocalHost();
        System.out.println("Local HostAddress: "+addr.getHostAddress());
                String hostname = addr.getHostName();
        System.out.println("Local host name: "+hostname);



    }
}
