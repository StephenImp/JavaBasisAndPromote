package UncaughtExceptionHandlerDemo.caseTwo;

/**
 * 定义一个线程。模拟抛出空指针异常
 */
public class MyThread implements Runnable {

    static int i = 0;

    @Override
    public void run() {
        i++;
        throw  new NullPointerException("我的自定义异常!!!"+ i);
    }
}
