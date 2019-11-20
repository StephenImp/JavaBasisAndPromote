package threadPoolAllDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 因为线程池大小为3，每个任务输出打印结果后sleep 2秒，所以每两秒打印3个结果。---前面三个线程没执行完就等待
 * 定长线程池的大小最好根据系统资源进行设置。如Runtime.getRuntime().availableProcessors()
 */
public class NewFixedThreadPoolTest {

    public static void main(String[] args) {
        //创建一个可重用固定个数的线程池
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            fixedThreadPool.execute(() -> {
                try {
                    //打印正在执行的缓存线程信息
                    System.out.println(Thread.currentThread().getName() + "正在被执行");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
