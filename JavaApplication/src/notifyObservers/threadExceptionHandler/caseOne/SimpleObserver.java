package notifyObservers.threadExceptionHandler.caseOne;


import java.util.Observable;
import java.util.Observer;



/**
 * Created by Administrator on 2016-03-24.
 *
 * 观察者 线程 类
 *
 */
public class SimpleObserver implements Observer {

    @Override
    public void update(Observable observable ,Object data){
        //重启线程
        System.out.println("5秒后重启线程");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SimpleObservable simpleObservable = new SimpleObservable();
        SimpleObserver simpleObserver = new SimpleObserver();
        //需要将观察者类加入到被观察者的观察者列表中
        simpleObservable.addObserver(simpleObserver);
        simpleObservable.run();
    }

}
