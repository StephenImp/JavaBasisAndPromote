package com.cn.session_6.application_2_4;

/**
 * 名字的隐藏
 */
public class Hide {

    public static void main(String[] args) {
        Bart b = new Bart();
        b.doh(1);
        b.doh('x');
        b.doh(1.0f);
        b.doh(new Milhouse());
    }
}
