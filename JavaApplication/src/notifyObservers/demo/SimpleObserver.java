package notifyObservers.demo;


import java.util.Observable;
import java.util.Observer;

/**
 * 观察者类
 */
public class SimpleObserver implements Observer {

    public SimpleObserver(SimpleObservable simpleObservable){
        simpleObservable.addObserver(this );
    }

    /**
     * 通过生成被观察者（SimpleObservable类）的实例，
     * 来调用addObserver(this)方法让观察者（SimpleObserver类）达到观察被观察者（SimpleObservable类）的目的。
     *
     * 然后还要复写update()方法，做数据改变后的一些处理。
     * @param observable
     * @param data
     */
    @Override
    public void update(Observable observable ,Object data){  // data为任意对象，用于传递参数

        SimpleObservable simpleObservable = (SimpleObservable) observable;
        System.out.println("Data has changed to : " + simpleObservable.getData());
    }

}
