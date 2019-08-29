package com.cn.session_7.application_3_2;

/**
 * Created by admin on 2018/8/2.
 * 内部类和上溯造型
 *
 * 当我们准备上溯造型到一个基础类（特别是到一个接口）的时候，
 * 内部类就开始发挥其关键作用（从用于实现的对象生成一个接口句柄具有与上溯造型至一个基础类相同的效果）。
 * 这是由于内部类随后可完全进入不可见或不可用状态——对任何人都将如此。
 * 所以我们可以非常方便地隐藏实施细节。
 * 我们得到的全部回报就是一个基础类或者接口的句柄，而且甚至有可能不知道准确的类型。
 */
public class TestParcel3 {

    public static void main(String[] args) {


        /**
         * 这里就是说，通过内部类 继承接口，或者抽象类
         * 返回出来的就是接口的类型，或者是抽象类的类型。
         * 至于在类的内部到底生成的是那一个子类，外部不会知道。
         *
         * 我们得到的全部回报就是一个基础类或者接口的句柄，而且甚至有可能不知道准确的类型。
         *
         * 注意Contents 不必成为一个抽象类。在这儿也可以使用一个普通类，
         * 但这种设计最典型的起点依然是一个“接口”。
         *
         * ，从客户程序员的角度来看，一个接口的范围没有意义的，因为他们不能访问不属于公共接口类的任何额外方法。
         * 这样一来，Java 编译器也有机会生成效率更高的代码。
         *
         */
        Parcel3 p = new Parcel3();
        Contents c = p.cont();
        Destination d = p.dest("Tanzania");
        // Illegal -- can't access private class:
        // Parcel3.PContents c = p.new PContents();
    }
}
