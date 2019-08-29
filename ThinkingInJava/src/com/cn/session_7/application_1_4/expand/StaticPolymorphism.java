package com.cn.session_7.application_1_4.expand;

/**
 * 缺陷：域与静态方法
 */
public class StaticPolymorphism {

    public static void main(String[] args) {

        /**
         * 如果某个方法是静态的，它的行为就不具有多态性。
         * 静态方法是与类，而并非与单个方法进行关联。
         */

        StaticSuper staticSup  = new StaticSub();

        System.out.println(staticSup.staticGet());

        System.out.println(staticSup.dynamicGet());


        /**
         * 子类就会调用自己重写的方法
         */
//        System.out.println("**************************************");
//        Super sup = new Sub();
//        System.out.println(sup.dynamicGet());

//        System.out.println("**************************************");
//
//        Sub sub = new Sub();
//        System.out.println(sub.dynamicGet());

    }
}
