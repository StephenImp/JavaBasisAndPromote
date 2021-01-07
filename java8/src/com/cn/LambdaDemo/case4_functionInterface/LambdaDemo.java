package com.cn.LambdaDemo.case4_functionInterface;


/**
 * 函数式接口的继承以及实现指定的default方法
 *
 * 函数式接口:一个接口里面只有一个需要去实现的方法.并不是接口里面只有一个方法。
 * jdk8新增了一个default方法，这个方法不需要去实现
 *
 */
public class LambdaDemo {


@FunctionalInterface
interface interface1{

    Integer method1(Integer a);

    default Integer method2(Integer a,Integer b) {

        return a+b;
    }
}


@FunctionalInterface
interface interface2{
    Integer method1(Integer a);
    default Integer method2(Integer a,Integer b) {
        return a+b;
    }
}

@FunctionalInterface
interface interface3 extends interface1,interface2{
    @Override
    default Integer method2(Integer a,Integer b) {
        return interface1.super.method2(a,b);
    }
}


    public static void main(String[] args) {

        interface1 a1 = (i)->i*2;

    }
}
