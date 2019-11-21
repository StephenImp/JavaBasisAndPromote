package threadGroupDemo.caseThree;

/**
 * ThreadGroup中有一个uncaughtException()方法。
 * 当线程组中某个线程发生Unchecked exception异常时，
 * 由执行环境调用此方法进行相关处理，如果有必要，您可以重新定义此方法
 */
public class ThreadGroupDemo {

    public static void main(String[] args) {

        ThreadGroup threadGroup1 =
                // 这是匿名类写法
                new ThreadGroup("group1") {
                    // 继承ThreadGroup并重新定义以下方法
                    // 在线程成员抛出unchecked exception
                    // 会执行此方法
                    public void uncaughtException(Thread t, Throwable e) {
                        System.out.println(t.getName() + ": "
                                + e.getMessage());
                    }
                };
        // 这是匿名类写法
        Thread thread1 =
                // 这个线程是threadGroup1的一员
                new Thread(threadGroup1,
                        new Runnable() {
                            public void run() {
                                // 抛出unchecked异常
                                throw new RuntimeException("测试异常");
                            }
                        });

        thread1.start();
    }
}
