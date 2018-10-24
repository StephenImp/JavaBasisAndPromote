package com.cn.chainOfResponsibilityModel.badCodeRefactoring;

/**
 * Created by admin on 2018/8/17.
 */
public class ZongJian extends Manager{

    public ZongJian(String name) {
        super.name = name;
    }

    @Override
    public void requestApplications(Request request) {
        if (request.getRequestType().equals("请假") && request.getNumber() <= 5) {
            System.out.println(name + ":" + request.getRequestType() + "数量" + request.getNumber() + "被批准了。。。");
        } else {
            System.out.println(name + ":" + request.getRequestType() + "数量" + request.getNumber() + "我无权处理。。。");
            superior.requestApplications(request);
        }
    }
}
