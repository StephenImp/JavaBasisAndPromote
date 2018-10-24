package com.cn.session_7.application_3_6;

/**
 * Created by admin on 2018/8/2.
 * 引用外部类对象
 *
 * 有些时候，我们想告诉其他某些对象创建它某个内部类的一个对象。
 * 为达到这个目的，必须在new 表达式中提供指向其他外部类对象的一个句柄
 */
public class Parcel7 {

    class Contents {
        private int i = 11;

        public int value() {
            return i;
        }
    }

    class Destination {
        private String label;

        Destination(String whereTo) {
            label = whereTo;
        }

        String readLabel() {
            return label;
        }
    }

    public static void main(String[] args) {

        Parcel7 p = new Parcel7();

        // Must use instance of outer class
        // to create an instances of the inner class:
        Contents c = p.new Contents();
        Destination d = p.new Destination("Tanzania");

        //Contents s = new Contents();//no

        /**
         * 因此，除非已拥有外部类的一个对象，否则不可能创建内部类的一个对象。
         * 这是由于内部类的对象已同创建它的外部类的对象“默默”地连接到一起。
         * 然而，如果生成一个static 内部类，就不需要指向外部类对象的一个句柄。(application_3_5)
         */
    }
}
