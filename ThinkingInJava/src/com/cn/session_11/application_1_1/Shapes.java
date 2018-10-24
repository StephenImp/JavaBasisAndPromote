package com.cn.session_11.application_1_1;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by admin on 2018/8/6.
 */
public class Shapes {
    public static void main(String[] args) {

        Vector s = new Vector();
        s.addElement(new Circle());
        s.addElement(new Square());
        s.addElement(new Triangle());
        Enumeration e = s.elements();
        while (e.hasMoreElements()) {
            ((Shape) e.nextElement()).draw();
        }

    }
}
