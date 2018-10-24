package com.cn.adapterModel.adapter2;

/**
 * Created by admin on 2018/8/16.
 * 适配器模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。
 */
public class TestAdapter2 {

    public static void main(String[] args) {

        Player forwards = new Forwards("麦克格雷迪");
        forwards.attack();

        Player guards = new Guards("乔丹");
        guards.attack();

        Player center = new Center("奥尼尔");
        center.attack();

        Player translator = new Translator("姚明");
        translator.attack();
        translator.defense();

    }


}
