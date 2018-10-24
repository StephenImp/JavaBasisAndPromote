package com.cn.chainOfResponsibilityModel.model1;

/**
 * Created by admin on 2018/8/17.
 */
public class ConcreteHandler3 extends Handler {

    @Override
    public void handleRequest(int request) {
        if (request >= 20 && request < 30) {
            System.out.println("ConcreteHandler3:request"+request);
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}
