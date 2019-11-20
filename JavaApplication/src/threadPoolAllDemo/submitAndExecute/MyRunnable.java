package threadPoolAllDemo.submitAndExecute;

public class MyRunnable implements Runnable{

    private String taskName;

    public MyRunnable(final String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {

        try {
            System.out.println("Inside "+taskName);
        }catch (Exception e){
            throw new RuntimeException("RuntimeException from inside " + taskName);
        }


    }
}
