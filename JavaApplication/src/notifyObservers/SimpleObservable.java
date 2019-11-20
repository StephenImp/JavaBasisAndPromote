package notifyObservers;

import java.util.Observable;

//被观察者类
//这个类是一个被观察者类，它继承了Observable类，表示这个类是可以被观察的。
public class SimpleObservable extends Observable {

    private int data = 0;

    public int getData(){
        return data;
    }

    /**
     * 然后在setData()方法里面，也就是数据改变的地方，
     * 来调用Observable类的setChanged()方法和notifyObservers()方法，
     * 表示数据已改变并通知所有的Observer调用它们的update()方法做一些处理。
     *
     * 注意：只有在setChange()被调用后，notifyObservers()才会去调用update()，否则什么都不干
     * @param i
     */
    public void setData(int i){
        if(this.data != i) {
            this.data = i;
            setChanged();

            //只有在setChange()被调用后，notifyObservers()才会去调用update()，否则什么都不干。
            notifyObservers();
        }
    }

}
