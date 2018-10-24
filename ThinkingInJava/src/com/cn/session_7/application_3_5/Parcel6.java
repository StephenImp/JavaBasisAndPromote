package com.cn.session_7.application_3_5;

/**
 * Created by admin on 2018/8/2.
 * s t a t i c 内部类
 *
 * static 内部类意味着：
 * (1) 为创建一个static 内部类的对象，我们不需要一个外部类对象。
 * (2) 不能从static 内部类的一个对象中访问一个外部类对象。
 *
    但在存在一些限制：由于static 成员只能位于一个类的外部级别，所以内部类不可拥有static 数据或static 内部类。
    倘若为了创建内部类的对象而不需要创建外部类的一个对象，那么可将所有东西都设为static。
 */
public class Parcel6 {

    private static class PContents extends Contents {

        private int i = 11;

        @Override
        public int value() {
            return i;
        }
    }

    protected static class PDestination implements Destination {
        private String label;

        private PDestination(String whereTo) {
            label = whereTo;
        }

        @Override
        public String readLabel() {
            return label;
        }
    }

    public static Destination dest(String s) {
        return new PDestination(s);
    }

    public static Contents cont() {
        return new PContents();
    }

    public static void main(String[] args) {
        Contents c = cont();
        Destination d = dest("Tanzania");
    }
}
