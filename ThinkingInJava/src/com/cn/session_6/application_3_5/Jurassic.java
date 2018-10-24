package com.cn.session_6.application_3_5;

/**
 * f in a l 类
 *
 * 如果说整个类都是final（在它的定义前冠以final 关键字），就表明自己不希望从这个类继承，
 * 或者不允许其他任何人采取这种操作。
 * 换言之，出于这样或那样的原因，我们的类肯定不需要进行任何改变；
 * 或者出于安全方面的理由，我们不希望进行子类化（子类处理）。
 *
 * eg：String类
 */
public class Jurassic {

    public static void main(String[] args) {

        /**
         * 结果只是禁止进行继承——没有更多的限制
         */

        Dinosaur n = new Dinosaur();
        n.f();
        n.i = 40;
        n.j++;

        System.out.println(n.i);
        System.out.println(n.j);
    }
}
