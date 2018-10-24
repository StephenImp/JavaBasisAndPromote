package com.cn.MultithReadingReturn;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by admin on 2018/6/14.
 */
public class CallableFuture {

    public static void main(String[] args) {
        //创建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(2) ;

        //创建三个有返回值的任务
        CallableTest c1 = new CallableTest("线程1") ;
        CallableTest c2 = new CallableTest("线程2") ;
        CallableTest c3 = new CallableTest("线程3") ;

        /**
         * 这个Future可以取消任务的执行或者等待完成得到返回值。
         */
        Future f1 = pool.submit(c1) ;
        Future f2 = pool.submit(c2) ;
        Future f3 = pool.submit(c3) ;

        try {
            System.out.println(f1.get().toString());
            System.out.println(f2.get().toString());
            System.out.println(f3.get().toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally{
            pool.shutdown();
        }

    }
}
