package com.cn.myself.chainOfResponsibilityModel.badCodeRefactoring;

/**
 * Created by admin on 2018/8/17.
 */
public class ZongJingLi extends Manager{

    public ZongJingLi(String name) {
        super.name = name;
    }

    @Override
    public void requestApplications(Request request) {

        if (request.getRequestType().equals("请假")) {
            System.out.println(name + ":" + request.getRequestType() + "数量" + request.getNumber() +  "被批准了。。。");
        } else if (request.getRequestType().equals("加薪") && request.getNumber() <= 500) {
            System.out.println(name + ":" + request.getRequestType() + "数量" + request.getNumber() + "被批准了。。。");
        } else if (request.getRequestType().equals("加薪") && request.getNumber() > 500) {
            System.out.println(name + ":" + request.getRequestType() + "数量" + request.getNumber() + "再说吧。。。");
        }else {
            System.out.println("...");
        }
    }
}
