package com.cn.decorativeModel.exercise1;

/**
 * Created by MOZi on 2019/2/25.
 */
public class A extends Decorator {

    private String addedState;

    @Override
    public void action(){

        //super.action();
        this.addedState = "New State";
        System.out.println("具体装饰对象A的操作"+addedState);
    }
}
