package UncaughtExceptionHandlerDemo.caseTwo;

/**
 * 自定义一个异常处理
 */
public class MyExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("-------------exception---------------");
        System.out.println("线程信息:"+t.toString());
        System.out.println("异常信息:"+e.getMessage());

    }
}
