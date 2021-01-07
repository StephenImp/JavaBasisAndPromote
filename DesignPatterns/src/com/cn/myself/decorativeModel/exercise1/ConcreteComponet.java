package com.cn.myself.decorativeModel.exercise1;

/**
 * 
 ************************************************************
 * @类名 : ConcreteComponet.java
 *
 * @DESCRIPTION : 具体的零件类
 *                  定义了一个具体的对象，也可以给这个对象添加一些职责。
 * @DATE :  2019.2.25
 ************************************************************
 */
public class ConcreteComponet extends Component {


    @Override
    void action() {
        System.out.println("我是需要被装饰的类");
    }
}
