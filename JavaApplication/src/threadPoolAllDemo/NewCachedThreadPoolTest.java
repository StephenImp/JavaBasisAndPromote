package threadPoolAllDemo;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * https://blog.csdn.net/hnd978142833/article/details/80253784
 *
 * 线程池为无限大，当执行当前任务时上一个任务已经完成，会复用执行上一个任务的线程，而不用每次新建线程
 */
public class NewCachedThreadPoolTest {

    public static void main(String[] args) {

        //创建一个可缓存线程池
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            try {
                //sleep可明显看到使用的是线程池里面以前的线程，没有创建新的线程
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            cachedThreadPool.execute(() -> {
                //打印正在执行的缓存线程信息
                System.out.println(Thread.currentThread().getName() + "正在被执行");
                try {
                    //throw new Exception("线程处理异常。。。");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            });
        }
        //cachedThreadPool.shutdown();  //线程处理完成后，线程池关闭
    }
}
