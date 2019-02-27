package com.cn.adapterModel.exercise;

/**
 * Created by MOZi on 2019/2/18.
 */
public class ForeignCenter {

    private String name;

    public ForeignCenter(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void attack() {
        System.out.println(name+"外籍中锋的进攻!!!");
    }

    public void defense() {
        System.out.println(name+"外籍中锋的防守!!!");
    }

}
