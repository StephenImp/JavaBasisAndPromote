package com.cn.session_1between3.application_2;

/**
 * Created by admin on 2018/7/30.
 * String不属于基本数据类型，试一试 效果
 *
 * 效果好像跟基本數據類型的效果是一樣的
 */
public class TestString {

    public static void main(String[] args) {

        String a = new String("A");
        String b = new String("B");

        System.out.println("before--->"+a);
        System.out.println("before--->"+b);

        a = b;

        //a = "C";
        b = "C";

        System.out.println("after--->"+a);
        System.out.println("after--->"+b);
    }


}
