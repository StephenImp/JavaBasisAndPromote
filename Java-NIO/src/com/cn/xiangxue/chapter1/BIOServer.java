package com.cn.xiangxue.chapter1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2018\9\15 0015.
 * BIO针对单线程
 * 如果读或者写操作并没有完成，那么它（当前线程）是不能进行其他操作的。
 *
 *
 * BIO--->NIO的演变过程
 */
public class BIOServer {

    public static void server1(){

        ServerSocket server = null;
        Socket socket = null;
        InputStream in = null;
        OutputStream out = null;

        try {
            server = new ServerSocket(8000);
            System.out.println("服务端请求成功，监听的端口为8000");

            //阻塞  客户端
            socket = server.accept();
            in = socket.getInputStream();

            byte[] buffer = new byte[1024];
            int len = 0;

            //读取客户端数据
            while((len = in.read(buffer))>0){
                System.out.println(new String(buffer,0,len));
            }

            //向客户端写数据
            out = socket.getOutputStream();
            out.write("hello,everybody!".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //多线程
    public void server2(){

        ServerSocket server = null;
        try {
            server = new ServerSocket(8000);
            System.out.println("服务端请求成功，监听的端口为8000");

            while (true){
                //记录操作
                Socket socket = server.accept();

                //针对每个连接创建一个线程，去处理IO操作
                //socket来了之后就创建了线程，不合理
                new Thread(new ServerHandler(socket)).start();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //线程池
    public void server3(){

        ServerSocket server = null;
        ExecutorService executorService = Executors.newFixedThreadPool(60);

        try {
            server = new ServerSocket(8000);
            System.out.println("服务端请求成功，监听的端口为8000,等待客户端连接。。。");
            while (true){
                Socket socket = server.accept();

                //使用线程池中的线程去执行每个对应的任务
                executorService.execute(new ServerHandler(socket));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //java NIO 原型。
    public void server4(){

        ServerSocket server = null;

        Map map = new HashMap();


        ExecutorService executorService = Executors.newFixedThreadPool(60);

        try {
            server = new ServerSocket(8000);
            System.out.println("服务端请求成功，监听的端口为8000,等待客户端连接。。。");
            while (true){
                Socket socket = server.accept();
                map.put(socket+"1,2,3....","Connected");

                //when IO 操作  再new Thread()  进行IO操作

                //使用线程池中的线程去执行每个对应的任务
                executorService.execute(new ServerHandler(socket));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
