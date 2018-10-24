package com.cn.xiangxue.chapter1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Administrator on 2018\9\15 0015.
 */
public class ServerHandler implements Runnable {

    private Socket socket;

    public ServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        InputStream in = null;

        try {
            in = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            //读取客服端数据
            while ((len = in.read(buffer))>0){
                System.out.println(new String(buffer,0,len));
            }

            //向客户端写数据
            OutputStream out = socket.getOutputStream();
            out.write("hello everybody!".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
