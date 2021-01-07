package com.cn.myself.chainOfResponsibilityModel.exercise1;

/**
 * Created by MOZi on 2019/2/25.
 */
public class JingLi extends Manager{

    public JingLi(String name){
        this.name = name;
    }

    @Override
    void action(Request request) {

        if (request.getWage()<50){

            System.out.println("涨薪不超过50，"+name+"阔以批一哈");

        }else {

            System.out.println(name+"无权审批！！！");
            sup.action(request);
        }

    }
}
