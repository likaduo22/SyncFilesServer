package com.ushine.versionupdate.thread;

import com.ushine.versionupdate.versionManagement.constant.ProjectConstant;
import com.ushine.versionupdate.versionManagement.model.Project;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.Socket;

/**
 * @author CHL
 * @Date 2021/6/21 15:30
 */
@Slf4j
public class TcpSendThread extends Thread {

    private Socket socket;

    TcpSendThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
     /*   try (
                // 创建需要传输的文件。参数：文件
                FileInputStream fs = new FileInputStream("E:\\360MoveData\\Users\\Administrator\\Desktop\\tls\\test.jar");
                OutputStream os = socket.getOutputStream();
                // 网络上面的流
                BufferedOutputStream bos = new BufferedOutputStream(os)
        ) {
            //while (true) {
                //写到服务器
                byte[] data = new byte[1024];
                int i;
                int dataCounter = 0;
                while ((i = fs.read(data)) != -1) {
                    bos.write(data, 0, i);
                    dataCounter += i;
                }
                log.info("tcp服务端文件下发完毕!"+dataCounter);
           // }
        } catch (Exception e) {
            e.printStackTrace();
        }*/


        try (
                FileInputStream fs = new FileInputStream("E:\\360MoveData\\Users\\Administrator\\Desktop\\tls\\noSql.zip");
                OutputStream os = socket.getOutputStream()
        ){

            ObjectOutputStream os1 = new ObjectOutputStream(os);

            Project project = new Project();

            project.setVersion(1);
           // project.setPath("E:\\360MoveData\\Users\\Administrator\\Desktop\\同步\\tls.zip");
            project.setServerPath("D:\\project");
            project.setNoSql(ProjectConstant.NO_HAVE);
            project.setPort(9001+"");

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] data = new byte[1024];
            int i;
            while ((i = fs.read(data)) != -1) {
                baos.write(data, 0, i);
            }


            project.setProjectFile(baos.toByteArray());
            os1.writeObject(project);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
