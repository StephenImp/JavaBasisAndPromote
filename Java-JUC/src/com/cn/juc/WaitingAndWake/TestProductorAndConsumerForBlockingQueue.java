package com.cn.juc.WaitingAndWake;


import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 我们这里使用LinkedBlockingQueue，它是一个已经在内部实现了同步的队列，
 * 它可以在生成对象时指定容量大小。它用于阻塞操作的是put()和take()方法。
 *
 * put()方法：类似于我们上面的生产者线程，容量达到最大时，自动阻塞。
 * take()方法：类似于我们上面的消费者线程，容量为0时，自动阻塞。
 */
public class TestProductorAndConsumerForBlockingQueue {

    private static final int CAPACITY = 5;

    public static void main(String args[]){
        LinkedBlockingDeque<Integer> blockingQueue = new LinkedBlockingDeque<Integer>(CAPACITY);

        Thread producer1 = new Producer("P-1", blockingQueue, CAPACITY);
        Thread producer2 = new Producer("P-2", blockingQueue, CAPACITY);
        Thread consumer1 = new Consumer("C-1", blockingQueue, CAPACITY);
        Thread consumer2 = new Consumer("C-2", blockingQueue, CAPACITY);
        Thread consumer3 = new Consumer("C-3", blockingQueue, CAPACITY);

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();
    }


    /**
     * 生产者
     */
    public static class Producer extends Thread{
        private LinkedBlockingDeque<Integer> blockingQueue;
        String name;
        int maxSize;
        int i = 0;

        public Producer(String name, LinkedBlockingDeque<Integer> queue, int maxSize){
            super(name);
            this.name = name;
            this.blockingQueue = queue;
            this.maxSize = maxSize;
        }

        @Override
        public void run(){
            while(true){
                try {
                    blockingQueue.put(i);
                    System.out.println("[" + name + "] Producing value : +" + i);
                    i++;

                    //暂停最多1秒
                    Thread.sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    /**
     * 消费者
     */
    public static class Consumer extends Thread{
        private LinkedBlockingDeque<Integer> blockingQueue;
        String name;
        int maxSize;

        public Consumer(String name, LinkedBlockingDeque<Integer> queue, int maxSize){
            super(name);
            this.name = name;
            this.blockingQueue = queue;
            this.maxSize = maxSize;
        }

        @Override
        public void run(){
            while(true){
                try {
                    int x = blockingQueue.take();
                    System.out.println("[" + name + "] Consuming : " + x);

                    //暂停最多1秒
                    Thread.sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
