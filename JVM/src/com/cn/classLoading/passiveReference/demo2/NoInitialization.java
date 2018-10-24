package com.cn.classLoading.passiveReference.demo2;

import com.cn.classLoading.passiveReference.demo1.SubClass;
import com.cn.classLoading.passiveReference.demo1.SuperClass;

/**
 * Created by MOZi on 2018/10/23.
 *
 * 非主动使用类字段演示二
 * 通过数组定义引用类，不会触发此类的初始化
 */
public class NoInitialization {

    public static void main(String[] args) {

        //SuperClass[] scp = new SuperClass[0];

        SubClass[] scb = new SubClass[0];
    }
}
