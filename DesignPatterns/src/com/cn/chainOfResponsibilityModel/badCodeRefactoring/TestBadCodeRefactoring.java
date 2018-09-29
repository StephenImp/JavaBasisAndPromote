package com.cn.chainOfResponsibilityModel.badCodeRefactoring;

/**
 * Created by admin on 2018/8/16.
 */
public class TestBadCodeRefactoring {

    public static void main(String[] args) {

        JingLi jingLi = new JingLi("经理");
        ZongJian zongJian = new ZongJian("总监");
        ZongJingLi zongJingLi = new ZongJingLi("总经理");

        jingLi.setSuperior(zongJian);
        zongJian.setSuperior(zongJingLi);

        Request request = new Request();
        request.setRequestType("加薪");
        request.setRequestContent("小蔡请求加薪");
        request.setNumber(1000);

        jingLi.requestApplications(request);

        Request request2 = new Request();
        request2.setRequestType("请假");
        request2.setRequestContent("小蔡请求请假");
        request2.setNumber(3);

        jingLi.requestApplications(request2);

    }


}
