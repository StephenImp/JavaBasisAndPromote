package com.cn.myself.chainOfResponsibilityModel.exercise1;

/**
 * Created by MOZi on 2019/2/25.
 */
public class ZongJian extends Manager {

    public ZongJian(String name) {

        this.name = name;
    }

    @Override
    void action(Request request) {

        if (request.getWage()<100){

            System.out.println("涨薪不超过100，"+name+"阔以批一哈");
        }else {

            System.out.println(name+"无权审批！！！");
            sup.action(request);
        }

    }
}
