package com.cn.session_7.application_3_4;

/**
 * Created by admin on 2018/8/2.
 *
 * 链接到外部类
 *
 * 创建自己的内部类时，那个类的对象同时拥有指向封装对象（这些对象封装或生成了内部类）的一个链接。
 * 所以它们能访问那个封装对象的成员——毋需取得任何资格。
 * 除此以外，内部类拥有对封装类所有元素的访问权限。
 *
 *
 * 就是说内部类同样可以调用外部类的方法,和成员属性。
 */
public class TestSequence {

    public static void main(String[] args) {
        Sequence s = new Sequence(10);
        for (int i = 0; i < 10; i++) {
            s.add(Integer.toString(i));
        }

        /**
         * 这里还是隐藏了一波内部类。
         * 内部类拥有对封装类所有元素的访问权限。
         *
         */
        Selector sl = s.getSelector();
        while (!sl.end()) {
            System.out.println((String) sl.current());
            sl.next();
        }
    }
}
