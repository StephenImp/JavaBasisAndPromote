package com.cn.concurrency.chapter1;

import java.util.Arrays;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018\9\13 0013.
 */
public class InterruptDemo {

    private static int i;

    public static void main(String[] args) throws InterruptedException {

//        Arrays.asList( "a", "b", "d" ).forEach(e -> {
//            System.out.println(e);
//        } );

        /**
         * interrupt比stop()更优雅
         */

        Thread thread = new Thread(() -> {

            while (!Thread.currentThread().isInterrupted()) {

                /**
                 * 让线程复位，这里并没有效果，具体的还是百度。
                 */
                Thread.interrupted();

                i++;
            }
            System.out.println("Num:"+i);
        });

        thread.start();

        TimeUnit.SECONDS.sleep(1);

        /**
         * 线程中断
         */
        thread.interrupt();
        System.out.println(Thread.currentThread().isInterrupted());
    }
}
