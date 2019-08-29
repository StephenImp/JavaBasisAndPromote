package com.cn.session_6.application_2_1.exercise;

public class C extends A{

    static {
        System.out.println("C 的static 代码块");
    }

    C(){
        System.out.println("C");
    }

    B b = new B();
}
