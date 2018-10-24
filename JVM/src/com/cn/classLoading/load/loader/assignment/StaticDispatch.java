package com.cn.classLoading.load.loader.assignment;

import org.junit.Test;

/**
 * Created by MOZi on 2018/10/24.
 *
 * 方法静态分派演示(重载)
 */
public class StaticDispatch {


    static abstract class Human{}

    static class Woman extends Human{}

    static class Man extends Human{}

    public void sayHello(Human guy){

        System.out.print("hello,guy!");
    }

    public void sayHello(Man guy){
        System.out.print("hello,gentleman!");
    }

    public void sayHello(Woman guy){
        System.out.println("hello.lady!");
    }

//    @Test
//    public void test(){
//        Human man = new Man();
//        Human woman = new Woman();
//
//        StaticDispatch sr = new StaticDispatch();
//        sr.sayHello(man);
//        System.out.println();
//        sr.sayHello(woman);
//
//    }



    public static void main(String[] args) {

        /**
         * Human 变量的静态类型
         *
         * Man 变量的实际类型
         */
        Human man = new Man();
        Human woman = new Woman();

        StaticDispatch sr = new StaticDispatch();
        sr.sayHello(man);
        System.out.println();
        sr.sayHello(woman);

        System.out.println("******************************");

        Man man1 = new Man();
        Woman woman1 = new Woman();

        sr.sayHello(man1);
        System.out.println();
        sr.sayHello(woman1);

    }


}
