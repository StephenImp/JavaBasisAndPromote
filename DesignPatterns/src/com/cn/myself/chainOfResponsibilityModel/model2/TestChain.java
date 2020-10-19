package com.cn.myself.chainOfResponsibilityModel.model2;

/**
 * Created by admin on 2018/8/17.
 */
public class TestChain {

    public static void main(String[] args) {

        //形式②
        Handler handler = new ConcreteHandler1();
        handler.setSuccessor(new ConcreteHandler2())
                .setSuccessor(new ConcreteHandler3());


        int requests[] = {5,9,12,15,18,24,26};

        for(int request:requests){
            handler.handleRequest(request);
        }
    }
}
