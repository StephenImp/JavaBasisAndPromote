package com.cn.adapterModel.adapter2;

/**
 * Created by admin on 2018/8/16.
 */
public class Guards extends Player {

    private String name;

    public Guards(){}

    public Guards(String name) {
        this.name = name;
    }

    @Override
    public void attack() {
        System.out.println("后卫"+name+"进攻");
    }

    @Override
    public void defense() {
        System.out.println("后卫"+name+"防守");
    }
}
