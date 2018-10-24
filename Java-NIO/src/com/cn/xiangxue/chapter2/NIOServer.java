package com.cn.xiangxue.chapter2;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Administrator on 2018\9\15 0015.
 */
public class NIOServer {

    private int port = 8000;
    private InetSocketAddress address = null;
    private Selector selector;//选择器

    public NIOServer(int port) {

        try {
            this.port = port;
            address = new InetSocketAddress(this.port);

            //new ServerSocket
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

            serverSocketChannel.socket().bind(address);

            //服务器通道设置成非阻塞的模式(服务器与客服端配对)
            serverSocketChannel.configureBlocking(false);

            selector = Selector.open();

            //每当有客户端连接上来的时候，默认它已经连接上来了
            //而这个连接我需要记录下他的状态 Connected
            //如BIO中用map来记录，一个道理。
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("服务器请求成功：" + this.port);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //selector开始轮询
    public void listen() {

        try {
            //轮询
            while (true) {
                //单线程还是多线程
                int wait = this.selector.select();//accpet()阻塞的 select()也是阻塞的
                if (wait == 0) {
                    continue;
                }

                //SelectionKey代表的是客户端和服务器端连接的一个关键
                Set<SelectionKey> keys = this.selector.selectedKeys();

                Iterator<SelectionKey> i = keys.iterator();

                while (i.hasNext()) {
                    SelectionKey key = i.next();

                    //针对每一个客户端进行相应的操作
                    //下面判断一下到底是进行读还是进行写
                    process(key);
                    i.remove();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //处理每一个客户端 key
    public void process(SelectionKey key) throws Exception {

        //中间数据交流的桥梁   缓冲区  底层（数组）
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        if (key.isAcceptable()) {
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
            SocketChannel client = serverSocketChannel.accept();
            client.configureBlocking(false);
            //客户端一旦连接上来 读写
            //往这个selector上注册key  READ 接下来可以读
            client.register(selector, SelectionKey.OP_READ);
        } else if (key.isReadable()) {

            SocketChannel client = (SocketChannel) key.channel();
            int len = client.read(buffer);

            //读取完成了
            if (len > 0) {
                buffer.flip();//固定--->通过这种方式完成读？（为什么是数组，这里是数组）

                String content = new String(buffer.array(), 0, len);
                client.register(selector, SelectionKey.OP_WRITE);
                System.out.println(content);
            }
            buffer.clear();
        }else if (key.isWritable()){

            SocketChannel client = (SocketChannel) key.channel();
            client.write(buffer.wrap("Hello Wold".getBytes()));
            client.close();
        }
    }


    public static void main(String[] args) {
        new NIOServer(8000).listen();
    }


}
