package com.cn.session_1between3.application_4.case2;

/**
 * 如果两个引用指向同一个对象，那么==就成立；
 * 反之，如果两个引用指向的不是同一个对象，那么==就不成立，
 * 即便两个引用的内容是一样的。因此，结果就会出现false。
 *
 * 是非常有趣的地方。如果你查看Integer.java类，
 * 你会找到IntegerCache.java这个内部私有类，它为-128到127之间的所有整数对象提供缓存。
 *
 * 现在你可能会问，为什么会为-128到127之间的所有整数设置缓存？
 * 这是因为在这个范围内的小数值整数在日常生活中的使用频率要比其它的大得多，多次使用相同的底层对象这一特性可以通过该设置进行有效的内存优化。
 */
public class Equivalence2 {
    public static void main(String[] args) {
        Integer a = 1000, b = 1000;
        System.out.println(a == b);//false
        Integer c = 100;
        Integer d = 100;
        System.out.println(c == d);//true
    }
}
