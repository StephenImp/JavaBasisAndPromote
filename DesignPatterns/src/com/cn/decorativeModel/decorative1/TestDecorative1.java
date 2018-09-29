package com.cn.decorativeModel.decorative1;

import org.junit.Test;

public class TestDecorative1 {

    @Test
    public void TestDecorative(){

        ConcreteComponet c = new ConcreteComponet();
        c.Operation();

        System.out.println("*****************************************");

        ConcreteDecoratorA a = new ConcreteDecoratorA();
        a.setComponent(c);
        a.Operation();

        System.out.println("*****************************************");

//        ConcreteDecoratorB b = new ConcreteDecoratorB();
//        b.setComponent(a);
//        b.Operation();


        ConcreteDecoratorB b = new ConcreteDecoratorB();
        b.setComponent(c);
        b.Operation();
    }
}
