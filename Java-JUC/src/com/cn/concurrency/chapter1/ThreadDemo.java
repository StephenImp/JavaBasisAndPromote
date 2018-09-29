package com.cn.concurrency.chapter1;

/**
 * Created by Administrator on 2018\9\13 0013.
 */
public class ThreadDemo implements Runnable {
    @Override
    public void run() {

    }

    public static void main(String[] args) {
        new Thread(new ThreadDemo()).start();
    }
}
