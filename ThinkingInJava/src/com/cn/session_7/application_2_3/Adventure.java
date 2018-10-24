package com.cn.session_7.application_2_3;

/**
 * Created by admin on 2018/8/2.
 * J a v a 的“多重继承”
 *
 * 使用接口最重要的一个原因：能上溯造型至多个基础类
 *
 * 使用接口的第二个原因与使用抽象基础类的原因是一样的：
 * 防止客户程序员制作这个类的一个对象，以及规定它仅仅是一个接口。
 */
public class Adventure {

    static void t(CanFight x) {
        x.fight();
        System.out.println(CanFight.a);
        //System.out.println(x.a);  x.a 不能訪問！
    }
    static void u(CanSwim x) {
        x.swim();
        System.out.println(CanSwim.c);
    }
    static void v(CanFly x) {
        x.fly();
        System.out.println(CanFly.b);
    }
    static void w(ActionCharacter x) { x.fight(); }
    public static void main(String[] args) {
        Hero i = new Hero();
        t(i); // Treat it as a CanFight
        u(i); // Treat it as a CanSwim
        v(i); // Treat it as a CanFly
        w(i); // Treat it as an ActionCharacter
    }
}
