package com.cn.myself.decorativeModel.exercise1;

/**
 * Created by MOZi on 2019/2/25.
 */
public class B extends Decorator {

    private void funcB(){
        System.out.println("类B独有的方法");
    }

    @Override
    void action(){

        funcB();

    }
}
