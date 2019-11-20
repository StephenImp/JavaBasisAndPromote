package threadPoolAllDemo.executeOne;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestNewCachedThreadDemo {

    public static void main(String[] args) {

        //创建一个可缓存线程池
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            try {
                //sleep可明显看到使用的是线程池里面以前的线程，没有创建新的线程
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            cachedThreadPool.execute(new MyThread("taskName"+i));
        }

        //cachedThreadPool.shutdown();  //线程处理完成后，线程池关闭

    }
}
