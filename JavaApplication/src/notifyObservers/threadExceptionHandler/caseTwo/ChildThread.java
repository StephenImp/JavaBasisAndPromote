package notifyObservers.threadExceptionHandler.caseTwo;

public class ChildThread implements Runnable{

    @Override
    public void run(){
        try{
            //do something
        }
        catch(Exception outEx){
            //log
        }
        finally{
            //删除childThread标示
            Thread thread = ThreadUtil.getLocalThread();
            ThreadUtil.deleteThread(thread);
        }
    }


}
