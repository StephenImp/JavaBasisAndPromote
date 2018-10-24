package com.cn.chainOfResponsibilityModel.model1;

/**
 * Created by admin on 2018/8/16.
 */
public class ConcreteHandler1 extends Handler {

    @Override
    public void handleRequest(int request) {
        if (request >= 0 && request < 10) {
            System.out.println("ConcreteHandler1:request"+request);
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}
