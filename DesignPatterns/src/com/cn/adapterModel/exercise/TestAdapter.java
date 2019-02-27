package com.cn.adapterModel.exercise;

/**
 * Created by MOZi on 2019/2/18.
 */
public class TestAdapter {

    public static void main(String[] args) {

        Player player = new Center("姚明");
        player.attack();
        player.defense();


        Player player1 = new Translator("奥尼尔");
        player1.attack();
        player1.defense();
    }



}
