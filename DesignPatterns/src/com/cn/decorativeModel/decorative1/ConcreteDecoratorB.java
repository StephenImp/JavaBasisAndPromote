package com.cn.decorativeModel.decorative1;

public class ConcreteDecoratorB extends Decorator {


    /**
     * 本类特有的功能，区别于ConcreteDecoratorA
     */
    public void addedBehavior() {
        System.out.println("正在执行ConcreteDecoratorB.addedBehavior()");
    }

    
    @Override
    public void Operation(){

        /**
         * 首先运行原Component的Operation(),
         * 再执行本类的功能，如addedBehavior()，
         * 相当于对原Component进行装饰
         */
        super.Operation();
        addedBehavior();
        System.out.println("具体装饰对象B的操作");
    }



}
