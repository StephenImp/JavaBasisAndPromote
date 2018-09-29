package com.cn.session_8.application_3_1;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by admin on 2018/8/6.
 * 枚举器（反复器）
 */
public class CatsAndDogs2 {

    public static void main(String[] args) {

        Vector cats = new Vector();
        for (int i = 0; i < 7; i++) {
            cats.addElement(new Cat2(i));
        }

        // Not a problem to add a dog to cats:
        cats.addElement(new Dog2(7));

        /**
         * 使用Enumeration，我们不必关心集合中的元素数量。
         * 所有工作均由 hasMoreElements()和nextElement()自动照管了。
         */
        Enumeration e = cats.elements();
        while (e.hasMoreElements()) {
            ((Cat2) e.nextElement()).print();
        }
        // Dog is detected only at run-time
    }
}
