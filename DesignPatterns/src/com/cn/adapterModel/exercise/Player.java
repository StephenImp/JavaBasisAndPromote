package com.cn.adapterModel.exercise;

/**
 * Created by MOZi on 2019/2/18.
 */
abstract class Player {

    protected String name;

    public Player(){}

    public Player(String name) {
        this.name = name;
    }

    public abstract void attack();

    public abstract void defense();
}
