package com.cn.myself.chainOfResponsibilityModel.model1;

/**
 * Created by admin on 2018/8/17.
 */
public class ConcreteHandler2 extends Handler {

    @Override
    public void handleRequest(int request) {
        if (request >= 10 && request < 20) {
            System.out.println("ConcreteHandler2:request"+request);
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}
