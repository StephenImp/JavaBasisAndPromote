package com.cn.classLoading.passiveReference.demo3;

import com.cn.classLoading.passiveReference.demo1.SubClass;

/**
 * Created by MOZi on 2018/10/23.
 *
 * 非主动使用类字段演示三
 * 常量在编译阶段会存入调用类的常量池中，
 * 本质上并没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化
 */
public class NoInitialization {

    public static void main(String[] args) {

        System.out.println(ConstClass.HELLOWORLD);
    }
}
