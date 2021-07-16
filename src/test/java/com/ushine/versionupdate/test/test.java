package com.ushine.versionupdate.test;

import java.awt.*;
import java.io.IOException;

/**
 * @author CHL
 * @Date 2021/6/17 10:16
 */
public class test {

    public static void main(String[] args) throws IOException, InterruptedException {


        Process proc = Runtime.getRuntime().exec("cmd.exe /c start  E:\\sss\\startJar.bat");
        int processCode = proc.waitFor();
        System.out.println("Process code: " + processCode);


    }


}


