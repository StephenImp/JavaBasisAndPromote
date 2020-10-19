package com.cn.myself.adapterModel.adapter2;

/**
 * Created by admin on 2018/8/16.
 */
public class ForeignCenter {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void attack() {
        System.out.println("国内中锋"+name+"进攻");
    }

    public void defense() {
        System.out.println("国内中锋"+name+"防守");
    }
}
