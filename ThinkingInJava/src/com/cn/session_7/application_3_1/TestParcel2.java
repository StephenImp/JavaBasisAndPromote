package com.cn.session_7.application_3_1;

/**
 * Created by admin on 2018/8/2.
 * 内部类
 */
public class TestParcel2 {

    public static void main(String[] args) {

        Parcel2 p = new Parcel2();
        p.ship("Tanzania");


        /**
         * 若想在除外部类非static 方法内部之外的任何地方生成内部类的一个对象，
         * 必须将那个对象的类型设为“外部类名.内部类名”，
         */

        Parcel2 q = new Parcel2();
        // Defining handles to inner classes:
        Parcel2.Contents c = q.cont();
        Parcel2.Destination d = q.to("Borneo");
    }
}
