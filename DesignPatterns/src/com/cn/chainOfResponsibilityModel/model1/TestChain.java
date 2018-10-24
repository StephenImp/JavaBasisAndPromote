package com.cn.chainOfResponsibilityModel.model1;

/**
 * Created by admin on 2018/8/17.
 */
public class TestChain {

    public static void main(String[] args) {

        //形式①
        ConcreteHandler1 handler1 = new ConcreteHandler1();
        ConcreteHandler2 handler2 = new ConcreteHandler2();
        ConcreteHandler3 handler3 = new ConcreteHandler3();

        handler1.setSuccessor(handler2);
        handler2.setSuccessor(handler3);


        int requests[] = {5,9,12,15,18,24,26};

        for(int request:requests){
            handler1.handleRequest(request);
        }
    }
}
