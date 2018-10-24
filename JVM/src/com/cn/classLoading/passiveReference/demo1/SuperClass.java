package com.cn.classLoading.passiveReference.demo1;

/**
 * Created by MOZi on 2018/10/23.
 */
public class SuperClass {

    static {
        System.out.println("SuperClass init!");
    }

    public static int value = 123;
}
