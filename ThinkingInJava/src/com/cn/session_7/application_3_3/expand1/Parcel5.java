package com.cn.session_7.application_3_3.expand1;

/**
 * Created by admin on 2018/8/2.
 * 任意作用域内嵌套一个内部类：
 * TrackingSlip 类嵌套于一个if 语句的作用域内。
 * 这并不意味着类是有条件创建的——它会随同其他所有东西得到编译。
 * 然而，在定义它的那个作用域之外，它是不可使用的。
 * 除这些以外，它看起来和一个普通类并没有什么区别。
 */
public class Parcel5 {

    private void internalTracking(boolean b) {
        if (b) {
            /**
             * 这并不意味着类是有条件创建的——它会随同其他所有东西得到编译。
             */
            class TrackingSlip {
                private String id;

                TrackingSlip(String s) {
                    id = s;
                }

                String getSlip() {
                    return id;
                }
            }
            TrackingSlip ts = new TrackingSlip("slip");
            String s = ts.getSlip();
        }
        // Can't use it here! Out of scope:
        //! TrackingSlip ts = new TrackingSlip("x");
    }

    public void track() {
        internalTracking(true);
    }

    public static void main(String[] args) {
        Parcel5 p = new Parcel5();
        p.track();
    }
}
