package event;

import java.util.Vector;

/**
 *  ③ 做一个事件发生者
 *
 * 　● 当事件源中的value值发生改变时，会促发事件
 * 　● 监听器在事件源上注册，事件源会保存该监听器，在事件触发时调用监听器的事件处理方法
 */
public class MySource {

    private int value;
    private Vector<Listener> listeners = new Vector<>();

    /**
     * 添加监听器
     * @param listener
     */
    public void addListener(Listener listener){
        listeners.add(listener);
    }

    public void setValue(int value){
        this.value = value;
        //发送消息
        MyEvent e = new MyEvent();
        e.setValue(value);
        for(int i = 0; i < listeners.size(); i++){
            listeners.get(i).eventChanged(e);
        }
    }
}
