package threadGroupDemo.caseFour;

/**
 * https://www.iteye.com/blog/cunzhangok-1633761
 */
public class ThreadGroupDemo2 {

    public static void main(String[] args) {
        // 建立异常处理者
        ThreadExceptionHandler handler = new ThreadExceptionHandler();
        ThreadGroup threadGroup1 = new ThreadGroup("group1");
        // 这是匿名类写法
        // 这个线程是threadGroup1的一员
        Thread thread1 = new Thread(threadGroup1, new Runnable() {
                            public void run() {
                            // 抛出unchecked异常
                            throw new RuntimeException("测试异常");
                            }
                        });
        // 设置异常处理者
        thread1.setUncaughtExceptionHandler(handler);
        thread1.start();
    }
}
