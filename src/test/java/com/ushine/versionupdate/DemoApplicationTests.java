package com.ushine.versionupdate;

import com.ushine.versionupdate.server.udp.Udp;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class DemoApplicationTests {
/*
    @Resource
    private TcpServer tcpServer;*/

    @Resource
    private Udp udp;
    @Test
    void contextLoads() {

        //tcpServer.serve("");
        udp.udpClient();
    }
}
