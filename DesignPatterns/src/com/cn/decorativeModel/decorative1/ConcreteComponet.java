package com.cn.decorativeModel.decorative1;

/**
 * 
 ************************************************************
 * @类名 : ConcreteComponet.java
 *
 * @DESCRIPTION : 具体的零件类
 *                  定义了一个具体的对象，也可以给这个对象添加一些职责。
 * @AUTHOR :  admin
 * @DATE :  2017年9月14日
 ************************************************************
 */
public class ConcreteComponet extends Component {

    @Override
    public void Operation() {
        System.out.println("需要被装饰的对象");
    }

}
