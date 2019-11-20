package UncaughtExceptionHandlerDemo.caseTwo;

public class TestTwo {

    public static void main(String[] args) {
        for (int i = 0; i <3 ; i++) {
            Thread thread = new Thread(new MyThread());
            thread.setUncaughtExceptionHandler(new MyExceptionHandler());
            thread.start();
        }
    }

}
