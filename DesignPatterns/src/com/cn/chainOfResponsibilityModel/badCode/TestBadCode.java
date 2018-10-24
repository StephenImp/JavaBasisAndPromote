package com.cn.chainOfResponsibilityModel.badCode;

import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by admin on 2018/8/16.
 */
public class TestBadCode {

    public static void main(String[] args) {

        Manager jinLi = new Manager("经理");
        Manager zongJian = new Manager("总监");
        Manager zongJingLi = new Manager("总经理");


        Request request = new Request();
        request.setRequestType("加薪");
        request.setRequestContent("小蔡请求加薪");
        request.setNumber(1000);

        jinLi.GetResult("经理",request);
        zongJian.GetResult("总监",request);
        zongJingLi.GetResult("总经理",request);

        Request request2 = new Request();
        request2.setRequestType("请假");
        request2.setRequestContent("小蔡请求请假");
        request2.setNumber(3);

        jinLi.GetResult("经理",request);
        zongJian.GetResult("总监",request);
        zongJingLi.GetResult("总经理",request);

    }


}
