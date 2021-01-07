package com.cn.myself.chainOfResponsibilityModel.exercise1;

/**
 * Created by MOZi on 2019/2/25.
 */
public class TestDemo {


    public static void main(String[] args) {

        JingLi jingLi = new JingLi("张三");
        ZongJian zongJian = new ZongJian("李四");
        ZongJingLi zongJingLi = new ZongJingLi("总经理");


        jingLi.setSup(zongJian);
        zongJian.setSup(zongJingLi);

        Request request = new Request();
        request.setWage(190);

        jingLi.action(request);

    }


}
