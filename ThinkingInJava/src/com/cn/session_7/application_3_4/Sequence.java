package com.cn.session_7.application_3_4;

/**
 * Created by admin on 2018/8/2.
 * 链接到外部类
 *
 *
 * 创建自己的内部类时，那个类的对象同时拥有指向封装对象（这些对象封装或生成了内部类）的一个链接。
 * 所以它们能访问那个封装对象的成员——毋需取得任何资格。
 * 除此以外，内部类拥有对封装类所有元素的访问权限。
 */
public class Sequence {

    private Object[] o;
    private int next = 0;

    public Sequence(int size) {
        o = new Object[size];
    }

    public void add(Object x) {
        if (next < o.length) {
            o[next] = x;
            next++;
        }
    }

    private class SSelector implements Selector {
        int i = 0;

        @Override
        public boolean end() {
            return i == o.length;
        }

        @Override
        public Object current() {
            return o[i];
        }

        @Override
        public void next() {
            if (i < o.length) {
                i++;
            }
        }
    }

    public Selector getSelector() {
        return new SSelector();
    }

}
