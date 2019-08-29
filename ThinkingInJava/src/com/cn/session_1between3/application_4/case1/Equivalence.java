package com.cn.session_1between3.application_4.case1;

/**
 *   == 比较的是地址值
 *   這裡的Integer类重写了equals方法，所以 equals 比较的是内容值
 *   否则比较的也是地址值
 */
public class Equivalence {
    public static void main(String[] args) {
        Integer n1 = new Integer(47);
        Integer n2 = new Integer(47);
        Integer n3 = 100;
        Integer n4 = 100;

        System.out.println(n1 == n2);// false
        System.out.println(n1 != n2);// true
        System.out.println(n1.equals(n2));//true
        System.out.println(n3 == n4);//true
    }
}
