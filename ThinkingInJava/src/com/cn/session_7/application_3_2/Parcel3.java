package com.cn.session_7.application_3_2;

/**
 * Created by admin on 2018/8/2.
 *
 * 当我们准备上溯造型到一个基础类（特别是到一个接口）的时候，
 * 内部类就开始发挥其关键作用（从用于实现的对象生成一个接口句柄具有与上溯造型至一个基础类相同的效果）。
 * 这是由于内部类随后可完全进入不可见或不可用状态——对任何人都将如此。
 * 所以我们可以非常方便地隐藏实施细节。
 * 我们得到的全部回报就是一个基础类或者接口的句柄，而且甚至有可能不知道准确的类型。
 */
public class Parcel3 {

    /**
     * 内部类PContents 被设为private，
     * 所以除了Parcel3 之外，其他任何东西都不能访问它
     */
    private class PContents extends Contents {
        private int i = 11;

        @Override
        public int value() {
            return i;
        }
    }

    /**
     * PDestination 被设为protected，
     * 所以除了Parcel3，Parcel3 包内的类（因为protected 也为包赋予了访问权；也就是说，protected 也是“友好的”），
     * 以及Parcel3 的继承者之外，其他任何东西都不能访问PDestination。
     */
    protected class PDestination implements Destination {
        private String label;

        private PDestination(String whereTo) {
            label = whereTo;
        }

        @Override
        public String readLabel() {
            return label;
        }
    }

    public Destination dest(String s) {
        return new PDestination(s);
    }

    public Contents cont() {
        return new PContents();
    }
}
