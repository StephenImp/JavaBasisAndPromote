package com.cn.adapterModel.exercise;

/**
 * Created by MOZi on 2019/2/18.
 */
public class Translator extends Player {

    ForeignCenter foreignCenter = null;


    public Translator(String name){
        foreignCenter =  new ForeignCenter(name);
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
