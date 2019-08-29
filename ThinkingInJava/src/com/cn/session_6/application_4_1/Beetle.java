package com.cn.session_6.application_4_1;

/**
 * Created by admin on 2018/7/31.
 * 继承初始化
 */
public class Beetle extends Insect{

    int k = prt("Beetle.k initialized");

    Beetle() {
        System.out.println("Beetle的构造器！");
        prt("k = " + k);
        prt("j = " + j);
    }

    static int x2 =
            prt("static Beetle.x2 initialized");

    static int prt(String s) {
        System.out.println(s);
        return 63;
    }
    static{
        System.out.println("Beetle的静态代码块");
    }

    public static void main(String[] args) {

        prt("Beetle constructor");//这一步，并没有初始化构造器。

        Beetle b = new Beetle();
    }
}
