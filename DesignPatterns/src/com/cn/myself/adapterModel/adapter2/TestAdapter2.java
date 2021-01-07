package com.cn.myself.adapterModel.adapter2;

/**
 * Created by admin on 2018/8/16.
 * 适配器模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。
 *
 * 不同的子类去做不同的事情。
 *
 * 如果接口不兼容，则用兼容的接口在不能兼容的类的外部封装一层，实现统一。
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
