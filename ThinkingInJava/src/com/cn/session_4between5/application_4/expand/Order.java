package com.cn.session_4between5.application_4.expand;

/**
 * Created by admin on 2018/7/31.
 * 类中各组成部分的初始化顺序：
 * 静态变量初始化，静态代码块，初始化静态方法，初始化实例变量，代码块，构造方法。
 */
public class Order {

    int a = 1;
    static int b = 1;

    //代码块
    {
        System.out.println("实例变量a=" + a);
        System.out.println("代码块执行！");
    }

    //静态代码块
    static {
        System.out.println("静态变量b=" + b);
        System.out.println("静态代码块被执行！");
    }

    //构造方法
    Order() {
        System.out.println("构造方法执行！");
    }

    void display(){
        System.out.println("display()A被调用!");
    }

    public static void main(String[] args) {
        Order o = new Order();
        o.display();
    }
}
