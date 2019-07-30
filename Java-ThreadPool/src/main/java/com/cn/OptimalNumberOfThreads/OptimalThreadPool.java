package com.cn.OptimalNumberOfThreads;

//import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by admin on 2018/7/2.
 */
public class OptimalThreadPool {

//    public static final int CORES = Runtime.getRuntime().availableProcessors();
//
//    private static final ExecutorService pools = Executors.newFixedThreadPool(CORES > 2 ? CORES - 2 : CORES,
//            new ThreadFactoryBuilder().setNameFormat("service-worker-%d").build());
//
//    public static void run(Runnable task) {
//        try {
//            pools.execute(task);
//        } catch (Exception e) {
//            System.out.println("ThreadPool - run error " + e);
//        }
//    }
//
//    public static <T> Future<T> run(Callable<T> taskWithResult) {
//        try {
//            return pools.submit(taskWithResult);
//        } catch (Exception e) {
//            System.out.println("ThreadPool - run taskWithResult error " + e);
//        }
//        return null;
//    }
}
