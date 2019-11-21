package UncaughtExceptionHandlerDemo.caseThree;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * https://blog.csdn.net/u010458765/article/details/53063762
 */
public class RunnableTest {

    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(2);

        /**
         * execute(Runnable x) 没有返回值。可以执行任务，但无法判断任务是否成功完成。
         */
        //pool.execute(new MyRunnable("Task1"));

        /**
         * submit(Runnable x) 返回一个future。可以用这个future来判断任务是否成功完成。请看下面：
         */

        for (int i = 0; i <5 ; i++) {

            String taskName = "Task"+i;

            Future  future = pool.submit(new MyRunnable(taskName));

            try {
                if (future.get() == null) {//如果Future's get返回null，任务完成
                    System.out.println(taskName+":任务完成");
                }
            }catch (Exception e) {
                //否则我们可以看看任务失败的原因是什么
                System.out.println("捕获失败异常。。。"+e.getCause().getMessage());
            }
        }

        pool.shutdown();

    }
}
