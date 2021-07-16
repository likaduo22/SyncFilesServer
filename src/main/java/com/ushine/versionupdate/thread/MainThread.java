package com.ushine.versionupdate.thread;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author CHL
 * @Date 2021/6/23 16:11
 */
@Component
public class MainThread {
    @Resource
    private UdpServer udpServer;
    @Resource
    private TcpServer tcpServer;

    @PostConstruct
    public void startThread(){

        //ExecutorService executorService = Executors.newCachedThreadPool();

        CountDownLatch latch = new CountDownLatch(2);

        System.out.println("主线程开始执行…… ……");
        //第一个子线程执行
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            udpServer.initUdp();
            System.out.println("子线程："+Thread.currentThread().getName()+"执行");
            latch.countDown();
        });
        executorService.shutdown();

        //第二个子线程执行
        ExecutorService es2 = Executors.newSingleThreadExecutor();
        es2.execute(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tcpServer.initTcp();
            System.out.println("子线程："+Thread.currentThread().getName()+"执行");
            latch.countDown();
        });
        es2.shutdown();
        System.out.println("等待两个线程执行完毕…… ……");
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("两个子线程都执行完毕，继续执行主线程");
    }

}
