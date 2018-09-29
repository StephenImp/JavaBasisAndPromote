package com.cn.adapterModel.adapter2;

/**
 * Created by admin on 2018/8/16.
 */
public class Forwards extends Player {

    private String name;

    public Forwards(){}

    public Forwards(String name) {
        this.name = name;
    }

    @Override
    public void attack() {
        System.out.println("前锋"+name+"进攻");
    }

    @Override
    public void defense() {
        System.out.println("前锋"+name+"防守");
    }
}
