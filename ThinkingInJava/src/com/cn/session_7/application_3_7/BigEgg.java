package com.cn.session_7.application_3_7;

/**
 * Created by admin on 2018/8/2.
 * 内部类可以覆盖吗？
 * 默认构建器是由编译器自动合成的，而且会调用基础类的默认构建器。
 * 这个例子简单地揭示出当我们从外部类继承的时候，没有任何额外的内部类继续下去。
 */
public class BigEgg extends Egg{

    public class Yolk {
        public Yolk() {
            System.out.println("BigEgg.Yolk()");
        }
    }

    /**
     * 内部类并没有被覆盖
     */
    public static void main(String[] args) {
        new BigEgg();
    }
}
