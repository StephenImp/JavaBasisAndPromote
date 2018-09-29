package com.cn.session_8.application_2_1.expand1;

import java.util.Vector;

/**
 * Created by admin on 2018/8/3.
 * 错误有时并不显露出来
 *
 * 第一种情况是相当特殊的：
 * String 类从编译器获得了额外的帮助，使其能够正常工作。
 * 只要编译器期待的是一个String 对象，但它没有得到一个，
 * 就会自动调用在Object 里定义、并且能够由任何Java 类覆盖的 toString()方法。
 * 这个方法能生成满足要求的String对象，然后在我们需要的时候使用。
 * 因此，为了让自己类的对象能显示出来，要做的全部事情就是覆盖toString()方法
 *
 * 说的是什么捏，没觉得有什么问题。
 *
 */
public class WorksAnyway {

    public static void main(String[] args) {
        Vector mice = new Vector();
        for (int i = 0; i < 3; i++){
            mice.addElement(new Mouse(i));
        }

        for (int i = 0; i < mice.size(); i++) {
            // No cast necessary, automatic call
            // to Object.toString():
            System.out.println("Free mouse: " + mice.elementAt(i));
            MouseTrap.caughtYa(mice.elementAt(i));
        }
    }
}
