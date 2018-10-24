package com.cn.oom.intern;

import org.junit.Test;

/**
 * Created by MOZi on 2018/10/22.
 */
public class TestIntern {

    /**
     *  String.intern返回引用测试
     *
     *  String.intern()查看是否为常量池首次出现的实例引用
     */
    @Test
    public  void testIntern(){

        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);//true

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);//false

    }
}
