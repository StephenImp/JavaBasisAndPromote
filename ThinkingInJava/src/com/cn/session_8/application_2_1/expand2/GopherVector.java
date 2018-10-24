package com.cn.session_8.application_2_1.expand2;

import java.util.Vector;

/**
 * Created by admin on 2018/8/3.
 * 生成能自动判别类型的 Vector
 */
public class GopherVector {

    private Vector v = new Vector();

    public void addElement(Gopher m) {
        v.addElement(m);
    }

    public Gopher elementAt(int index) {
        return (Gopher) v.elementAt(index);
    }

    public int size() {
        return v.size();
    }

    public static void main(String[] args) {
        GopherVector gophers = new GopherVector();
        for (int i = 0; i < 3; i++) {
            gophers.addElement(new Gopher(i));
        }

        for (int i = 0; i < gophers.size(); i++) {
            GopherTrap.caughtYa(gophers.elementAt(i));
        }

    }
}
