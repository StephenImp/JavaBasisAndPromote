package com.cn.classLoading.load.loadingProcess.clinit;

/**
 * Created by MOZi on 2018/10/23.
 */
public class Parent {

    //这里变量的位子不同会导致结果不同。 2
    public static int A = 1;

    /**
     * 非法向前引用变量
     */
    static {
        A = 2;      //给变量赋值可以正常编译通过
        //System.out.println(A);    //编译器提示“非法向前引用”
    }

    //public static int A = 1;  1

}
