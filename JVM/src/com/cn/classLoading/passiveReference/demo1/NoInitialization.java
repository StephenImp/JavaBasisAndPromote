package com.cn.classLoading.passiveReference.demo1;

/**
 * Created by MOZi on 2018/10/23.
 *
 * 非主动使用类字段演示
 *
 * 被动引用例子一
 * 被动使用类字段演示一
 * 通过子类引用父类的静态字段，不会导致子类初始化
 */
public class NoInitialization {

    public static void main(String[] args) {

        System.out.println(SubClass.value);
    }
}
