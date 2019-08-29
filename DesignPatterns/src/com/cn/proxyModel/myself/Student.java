package com.cn.proxyModel.myself;

/**
 * Created by MOZi on 2019/2/15.
 */
public class Student implements Person{

    @Override
    public void giveMoney() {
        System.out.println("上交50元班费");
    }
}
