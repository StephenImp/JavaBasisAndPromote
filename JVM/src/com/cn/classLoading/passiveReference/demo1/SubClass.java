package com.cn.classLoading.passiveReference.demo1;

/**
 * Created by MOZi on 2018/10/23.
 */
public class SubClass extends SuperClass {

    static {
        System.out.println("SubClass init!");
    }

}
