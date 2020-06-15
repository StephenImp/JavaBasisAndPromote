package event;

/**
 * ④ 定义一个监听器
 *
 * 如果谁想监听MySource的value值改变了，就在MySource哪儿注册一下，
 *      然后写消息处理代码，就可以了,我们定义这样一个监听者：
 */
public class MyListener implements Listener {
    @Override
    public void eventChanged(MyEvent e) {
        // TODO Auto-generated method stub
        System.out.println("MyListener value changed to:" + e.getValue());
    }
}
