package threadGroupDemo.caseOne;

import org.junit.Test;


/**
 *
 * https://blog.csdn.net/hshqiang/article/details/83029200
 *
 * 1.获取当前线程组名
 *
 * 2.将线程放入到一个线程组中去
 *
 * 可以统一管理整个线程组中的线程，您可以使用以下方式来产生线程组，而且一并指定其线程组：
 *
 * 3.复制线程组
 *
 * 4.未捕获异常处理
 * ThreadGroup中有一个uncaughtException()方法。当线程组中某个线程发生Unchecked exception异常时，
 * 由执行环境调用此方法进行相关处理，如果有必要，可以重新定义此方法
 */
public class DemoOne {


    /**
     * 获取当前线程组名
     */
    @Test
    public void test1(){
        System.out.println(Thread.currentThread().getThreadGroup().getName());
    }

    /**
     * 将线程放入到一个线程组中去
     */
    @Test
    public void test2(){

        ThreadGroup threadGroup1 = new ThreadGroup("group1");

        ThreadGroup threadGroup2 = new ThreadGroup("group2");

        Thread thread1 =new Thread(threadGroup1, "group1's member");

        Thread thread2 =new Thread(threadGroup2, "group2's member");

    }

    /**
     * 复制线程组：
     */
    @Test
    public void Test3(){

        ThreadGroup threadGroup = new ThreadGroup("group");

        //这样可以复制group里面的thread信息
        //这里的activeCount很明显就是取得活动的线程，
        // 注意。默认情况 下，连同其子线程组也会进行复制。
        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
    }

}
