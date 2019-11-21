package threadPoolAllDemo.threadPollExceptionHandler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 基于观察者模式启动异常线程
 */
public class ThreadPool {

    public static void main(String[] args) {

        //创建观察者对象
        SimpleObserver simpleObserver = new SimpleObserver();
        //创建被观察者对象
        SimpleObservable simpleObservable = new SimpleObservable();

        //需要将观察者类加入到被观察者的观察者列表中
        simpleObservable.addObserver(simpleObserver);

        //启动被观察者，观察者线程也会同时被启动
        //创建一个可重用固定个数的线程池
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(1);

        fixedThreadPool.execute(simpleObservable);

    }
}
