package com.cn.concurrency.chapter1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2018\9\13 0013.
 * 共享变量问题
 * 要分清楚，是原子性问题，还是可见性问题。
 */
public class SafeDemo {

    //private static int count = 0;
    private static AtomicInteger count = new AtomicInteger(0);

    public static void inc()  {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //count++;
        count.getAndIncrement();
    }

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 1000; i++) {
            new Thread(()->SafeDemo.inc()).start();
        }

        Thread.sleep(1000);

        System.out.println("运行结果:"+count);
    }

}
