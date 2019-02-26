package com.cn.chainOfResponsibilityModel.exercise1;

/**
 * Created by MOZi on 2019/2/25.
 */
abstract class Manager {

    protected String name;//当前管理者的名称

    Manager sup;//当前管理者的上级

//    public Manager() {
//    }
//
//    public Manager(String name) {
//        this.name = name;
//    }

     abstract void  action(Request request);

    public Manager getSup() {
        return sup;
    }

    public void setSup(Manager sup) {
        this.sup = sup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
