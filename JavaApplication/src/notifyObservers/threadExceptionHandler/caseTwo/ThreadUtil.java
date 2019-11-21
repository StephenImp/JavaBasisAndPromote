package notifyObservers.threadExceptionHandler.caseTwo;

public class ThreadUtil {

    private static Thread thread;

    private ThreadUtil( ) {

    }
    //添加线程标示
    public static  void addThread(Thread value){
        if(thread == null){
            thread = value;
        }
    }
    //获取线程标示
    public static Thread getLocalThread(){
        if(thread != null){
            return thread;
        }else {
            return null;
        }
    }

    //删除线程标示
    public static void deleteThread(Thread value){
        if(thread != null){
            thread = null;
        }
    }

}
