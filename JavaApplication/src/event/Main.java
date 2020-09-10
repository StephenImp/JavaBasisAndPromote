package event;

/**
 * https://blog.csdn.net/qq369201191/article/details/51204006
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {

        //定义一个监听器
        MyListener listener = new MyListener();
        MyListenerTwo myListenerTwo = new MyListenerTwo();

        //事件监听器
        MySource s = new MySource();

        //将自定义的监听器加到事件监听器中
        s.addListener(listener);
        s.addListener(myListenerTwo);

        //事件触发动作
        //事件的值一改变，那么就会通知这个事件监听器下的所有监听，这个事件触发了
        s.setValue(100);
    }
}
