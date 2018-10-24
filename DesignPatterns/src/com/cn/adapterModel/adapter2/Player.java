package com.cn.adapterModel.adapter2;

/**
 * Created by admin on 2018/8/16.
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
