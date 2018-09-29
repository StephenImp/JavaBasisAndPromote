package com.cn.session_7.application_3_3;

/**
 * Created by admin on 2018/8/2.
 * 方法和作用域中的内部类
 *
 * 在方法内部实现内部类,也可以达到隐藏的效果
 */
public class TestParcel4 {

    public static void main(String[] args) {
        Parcel4 p = new Parcel4();
        Destination d = p.dest("Tanzania");
    }
}
