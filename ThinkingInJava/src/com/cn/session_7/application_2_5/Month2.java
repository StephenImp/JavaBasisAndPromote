package com.cn.session_7.application_2_5;

/**
 * Created by admin on 2018/8/2.
 * 常数分组
 */
public final class Month2 {

    private String name;

    private Month2(String nm) {
        name = nm;
    }

    @Override
    public String toString() {
        return name;
    }

    public final static Month2
            JAN = new Month2("January"),
            FEB = new Month2("February"),
            MAR = new Month2("March"),
            APR = new Month2("April"),
            MAY = new Month2("May"),
            JUN = new Month2("June"),
            JUL = new Month2("July"),
            AUG = new Month2("August"),
            SEP = new Month2("September"),
            OCT = new Month2("October"),
            NOV = new Month2("November"),
            DEC = new Month2("December");

    /**
     * 注意数组中提供了一个多余的JAN，使偏移量增加了1，也使December 确实成为12月
     */
    public final static Month2[] month = {
            JAN, JAN, FEB, MAR, APR, MAY, JUN,
            JUL, AUG, SEP, OCT, NOV, DEC};

    public static void main(String[] args) {

        Month2 m = Month2.JAN;
        System.out.println(m);


        m = Month2.month[12];
        System.out.println(m);
        System.out.println(m == Month2.DEC);
        System.out.println(m.equals(Month2.DEC));
    }
}
