package com.cn.session_7.application_2_6;

/**
 * Created by admin on 2018/8/2.
 * 初始化接口中的字段
 *
 */
public class TestRandVals {

    public static void main(String[] args) {

        /**
         * 当然，字段并不是接口的一部分，而是保存于那个接口的static 存储区域中。
         */
        System.out.println(RandVals.rint);
        System.out.println(RandVals.rlong);
        System.out.println(RandVals.rfloat);
        System.out.println(RandVals.rdouble);
    }
}
