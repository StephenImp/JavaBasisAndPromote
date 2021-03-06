package com.cn.myself.decorativeModel.decorative1;

public class ConcreteDecoratorA extends Decorator {
    
    /**
     * 本类特有的功能，区别于ConcreteDecoratorB
     */
    private String addedState;


    /**
     * 装饰类的方法中实现装饰方法，
     */
    @Override
    public void Operation(){

        /**
         * 首先运行原Component的Operation(),Z
         * 再执行本类的功能，
         * 如addedState，相当于对原Component进行装饰
         */
        super.Operation();
        this.addedState = "New State";
        System.out.println("具体装饰对象A的操作"+addedState);
    }

}
