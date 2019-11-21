package UncaughtExceptionHandlerDemo.caseThree;

public class MyRunnable implements Runnable{

    private String taskName;

    public MyRunnable(final String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {

        throw new RuntimeException("RuntimeException from inside " + taskName);

//        try {
//            System.out.println("Inside "+taskName);
//        }catch (Exception e){
//            throw new RuntimeException("RuntimeException from inside " + taskName);
//        }
    }
}
