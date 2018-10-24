package com.cn.session_6.application_2_1;

public class Drawing extends Art {

    static {
        System.out.println("Drawing的静态代码块");
    }

    {
        System.out.println("Drawing的代码块");
    }

    void display(){
        System.out.println("Drawing的display()方法!");
    }

    Drawing(){
        print("Drawing constructor");
    }
}
