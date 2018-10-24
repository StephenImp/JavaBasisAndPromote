package com.cn.classLoading.passiveReference.demo3;

/**
 * Created by MOZi on 2018/10/23.
 */
public class ConstClass {

    static {
        System.out.println("ConstClass init!");
    }

    /**
     * static 在加载时就被加载到方法区中
     */
    public static final String HELLOWORLD = "hello world";
    //public static  String HELLOWORLD = "hello world";
}

