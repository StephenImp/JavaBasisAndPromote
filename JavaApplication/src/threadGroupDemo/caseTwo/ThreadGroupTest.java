package threadGroupDemo.caseTwo;

import java.util.concurrent.TimeUnit;

/**
 * https://blog.csdn.net/suyimin2010/article/details/81025061
 * Java并发编程与技术内幕:ThreadGroup线程组应用
 */
public class ThreadGroupTest {

    public static void main(String[] args) {

        System.out.println("main thread start:");
        //创建5个线程，并入group里面进行管理
        ThreadGroup threadGroup = new ThreadGroup("Searcher");
        Result result = new Result();
        SearchTask searchTask = new SearchTask(result);

        for (int i = 0; i < 5; i++) {
            Thread thred = new Thread(threadGroup, searchTask);
            thred.start();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //通过这种方法可以看group里面的所有信息
         System.out.printf("Number of Threads: %d\n", threadGroup.activeCount());
        System.out.printf("Information about the Thread Group\n");
        threadGroup.list();


        //这样可以复制group里面的thread信息
        //如果您想要一次获得线程组中所有的线程来进行某种操作，可以使用enumerate()方法
        //activeCount()方法获得线程组中正在运行的线程数量，enumerate()方法要传入一个Thread数组
        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);

        for (int i = 0; i < threadGroup.activeCount(); i++) {
            System.out.printf("Thread %s: %s\n", threads[i].getName(),
                    threads[i].getState());
        }

        waitFinish(threadGroup);
        //将group里面的所有线程都给interpet
        threadGroup.interrupt();

        System.out.println("main thread end:");
    }


    private static void waitFinish(ThreadGroup threadGroup) {

        while (threadGroup.activeCount() > 0) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
