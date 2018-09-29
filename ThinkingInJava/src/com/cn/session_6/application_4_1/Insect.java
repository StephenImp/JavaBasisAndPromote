package com.cn.session_6.application_4_1;

/**
 * Created by admin on 2018/7/31.
 */
public class Insect {

    int i = 9;
    int j;
    Insect() {
        System.out.println("Insect的构造器！");
        prt("i = " + i + ", j = " + j);
        j = 39;
    }
    static int x1 = prt("static Insect.x1 initialized");

    static int prt(String s) {
        System.out.println(s);
        return 47;
    }

    static{
        System.out.println("Insect的静态代码块");
    }
}
