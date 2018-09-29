package com.cn.adapterModel.adapter2;

/**
 * Created by admin on 2018/8/16.
 * 翻译者
 */
public class Translator extends Player {

    private ForeignCenter foreignCenter = new ForeignCenter();

    public Translator() {
    }

    public Translator(String name) {
        foreignCenter.setName(name);
    }

    @Override
    public void attack() {
        foreignCenter.attack();
    }

    @Override
    public void defense() {
        foreignCenter.defense();
    }
}
