package com.cn.session_8.application_3_1.expand1;

import java.util.Vector;

/**
 * Created by admin on 2018/8/6.
 */
public class HamsterMaze {

    public static void main(String[] args) {
        Vector v = new Vector();
        for (int i = 0; i < 3; i++) {
            v.addElement(new Hamster(i));
        }
        Printer.printAll(v.elements());
    }
}
