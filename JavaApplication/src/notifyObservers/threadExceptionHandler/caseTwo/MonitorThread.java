package notifyObservers.threadExceptionHandler.caseTwo;

public class MonitorThread implements Runnable {
    @Override
    public void run() {

        while(true){
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread thread = ThreadUtil.getLocalThread();
            //存在线程，休眠10秒
            if(thread!=null){
                System.out.println("历史数据上传线程正常运行");
            }else{//不存在线程，重启线程
                Thread newThread = new Thread(new ChildThread());
                ThreadUtil.addThread(newThread);
                thread.start();
            }
        }

    }
}
