package UncaughtExceptionHandlerDemo.caseOne;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * ThreadGroup?
 * 哎，不明白
 */
public class TestOne {

    public static void main(String[] args) {
        setDefaultUncaughtExceptionHandler();
        test();
    }

    private static void test() {

        new Thread(() -> {
            System.out.println("子线程异常前");
            System.out.println(1 / 0);
        }).start();

        System.out.println("当前线程异常前");
        System.out.println(1 / 0);
        System.out.println("异常后的代码不能执行了");
    }

    private static void setDefaultUncaughtExceptionHandler() {

        /**
         *
         * UncaughtExceptionHandler
         *
         * 所有已知实现类：ThreadGroup
         *
         * 当 Thread 因未捕获的异常而突然终止时，调用处理程序的接口。
         *
         * 当某一线程因未捕获的异常而即将终止时，Java 虚拟机将使用 Thread.getUncaughtExceptionHandler() 查询该线程以获得其 UncaughtExceptionHandler 的线程，并调用处理程序的 uncaughtException 方法，将线程和异常作为参数传递。
         *
         * 如果某一线程没有明确设置其 UncaughtExceptionHandler，则将它的 ThreadGroup 对象作为其 UncaughtExceptionHandler。如果 ThreadGroup 对象对处理异常没有什么特殊要求，那么它可以将调用转发给默认的未捕获异常处理程序。
         *
         * void uncaughtException(Thread t, Throwable e)
         * 当给定线程因给定的未捕获异常而终止时，调用该方法。
         * Java 虚拟机将忽略该方法抛出的任何异常。
         */
        Thread.UncaughtExceptionHandler currentHandler = (t, e) -> System.out.println("【当前线程的Handler处理异常信息】" + t.toString() + "\n" + e.getMessage());

        Thread.UncaughtExceptionHandler defaultHandler = (t, e) -> {
            StringWriter writer = new StringWriter();
            PrintWriter printWriter = new PrintWriter(writer);
            printWriter.write("start------------\n");
            e.printStackTrace(printWriter);
            printWriter.write("------------end");
            printWriter.close();
            System.out.println("【默认的Handler处理异常信息】" + writer.getBuffer().toString());
        };


        /**
         *
         * setUncaughtExceptionHandler
         *
         * public void setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler eh)
         * 设置该线程由于未捕获到异常而突然终止时调用的处理程序。
         * 通过明确设置未捕获到的异常处理程序，线程可以完全控制它对未捕获到的异常作出响应的方式。
         * 如果没有设置这样的处理程序，则该线程的 ThreadGroup 对象将充当其处理程序。
         *
         * public Thread.UncaughtExceptionHandler getUncaughtExceptionHandler()
         * 返回该线程由于未捕获到异常而突然终止时调用的处理程序。
         * 如果该线程尚未明确设置未捕获到的异常处理程序，则返回该线程的 ThreadGroup 对象，除非该线程已经终止，在这种情况下，将返回 null
         */
        Thread.currentThread().setUncaughtExceptionHandler(currentHandler);


        /**
         *
         * setDefaultUncaughtExceptionHandler
         *
         * 设置当线程由于未捕获到异常而突然终止，并且没有为该线程定义其他处理程序时所调用的默认处理程序。
         *
         * 未捕获到的异常处理首先由线程控制，然后由线程的 ThreadGroup 对象控制，最后由未捕获到的默认异常处理程序控制。
         *
         * 如果线程不设置明确的未捕获到的异常处理程序，并且该线程的线程组（包括父线程组）未特别指定其 uncaughtException 方法，则将调用默认处理程序的 uncaughtException 方法。
         *
         * 通过设置未捕获到的默认异常处理程序，应用程序可以为那些已经接受系统提供的任何“默认”行为的线程改变未捕获到的异常处理方式（如记录到某一特定设备或文件）。
         *
         * 请注意，未捕获到的默认异常处理程序通常不应顺从该线程的 ThreadGroup 对象，因为这可能导致无限递归。
         *
         * public static Thread.UncaughtExceptionHandler getDefaultUncaughtExceptionHandler()
         * 返回线程由于未捕获到异常而突然终止时调用的默认处理程序。如果返回值为 null，则没有默认处理程序。
         */
        Thread.setDefaultUncaughtExceptionHandler(defaultHandler);
    }
}
