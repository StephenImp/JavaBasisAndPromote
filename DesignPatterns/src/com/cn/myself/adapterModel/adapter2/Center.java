package com.cn.myself.adapterModel.adapter2;

/**
 * Created by admin on 2018/8/16.
 */
public class Center extends Player {

    private String name;

    public Center() {
    }

    public Center(String name) {
        this.name = name;
    }

    @Override
    public void attack() {
        System.out.println("中锋"+name+"进攻");
    }

    @Override
    public void defense() {
        System.out.println("中锋"+name+"防守");
    }
}
