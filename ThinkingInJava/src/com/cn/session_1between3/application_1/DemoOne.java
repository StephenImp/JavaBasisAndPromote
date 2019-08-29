package com.cn.session_1between3.application_1;

import org.junit.Test;

public class DemoOne {

    /**
     * 当i为成员(全局)变量时，i的初始值为0
     * 当i为局部变量时，编译报错
     */

    int i ;

    @Test
    public void TestOne(){
        System.out.println(i);

    }
}
