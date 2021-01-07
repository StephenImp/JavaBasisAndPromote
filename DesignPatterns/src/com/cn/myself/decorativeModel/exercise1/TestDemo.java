package com.cn.myself.decorativeModel.exercise1;

/**
 * Created by MOZi on 2019/2/25.
 */
public class TestDemo {

    public static void main(String[] args) {

        ConcreteComponet concreteComponet = new ConcreteComponet();
        concreteComponet.action();


        A a = new A();
        a.setComponent(concreteComponet);

        /**
         * 这里只是执行了子类的方法，没有执行父类的。
         */
        a.action();

        B b = new B();
        b.setComponent(concreteComponet);


        /**
         * 这里只是执行了子类的方法，没有执行父类的。
         */
        b.action();


        /**
         * 同样只是执行了子类的方法，没有执行父类的。
         */
        Decorator d = new B();
        b.setComponent(concreteComponet);

        d.action();


    }


}
