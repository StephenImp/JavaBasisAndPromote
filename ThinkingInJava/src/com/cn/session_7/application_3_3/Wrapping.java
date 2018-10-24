package com.cn.session_7.application_3_3;

/**
 * Created by admin on 2018/8/2.
 * 尽管是含有具体实施细节的一个普通类，但Wrapping 也作为它所有衍生类的一个通用“接口”使用：
 * 我们注意到Wrapping 有一个要求使用自变量的构建器，这就使情况变得更加有趣了。
 */
public class Wrapping {

    private int i;

    public Wrapping(int x) {
        i = x;
    }

    public int value() {
        return i;
    }
}
