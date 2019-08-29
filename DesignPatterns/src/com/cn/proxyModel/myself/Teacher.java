package com.cn.proxyModel.myself;

public class Teacher implements Person {
    @Override
    public void giveMoney() {
        System.out.println("上交100元班费");
    }
}
