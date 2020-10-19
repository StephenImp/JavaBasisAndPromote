package com.cn.myself.adapterModel.exercise;

/**
 * Created by MOZi on 2019/2/18.
 */
public class Center extends Player {

    public Center(String name){

        this.name = name;
    }

    @Override
    public void attack() {
        System.out.println(name+"中锋的进攻!!!");
    }

    @Override
    public void defense() {
        System.out.println(name+"中锋的防守!!!");
    }
}
