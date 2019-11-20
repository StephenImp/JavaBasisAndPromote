package threadPoolAllDemo.executeOne;

public class MyThread implements Runnable {

    private String taskName;

    public MyThread(String taskName){
        this.taskName = taskName;
    }

    @Override
    public void run() {

        System.out.println(taskName+" 正在被执行。。。");

    }
}
