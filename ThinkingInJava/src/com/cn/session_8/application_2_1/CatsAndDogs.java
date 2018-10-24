package com.cn.session_8.application_2_1;

import java.util.Vector;

/**
 * Created by admin on 2018/8/3.
 * 缺点：类型未知
 */
public class CatsAndDogs {

    public static void main(String[] args) {
        Vector cats = new Vector();
        for (int i = 0; i < 7; i++){
            cats.addElement(new Cat(i));
        }

        // Not a problem to add a dog to cats:
        cats.addElement(new Dog(7));
        for (int i = 0; i < cats.size(); i++){
            ((Cat) cats.elementAt(i)).print();
        }

        // Dog is detected only at run-time
    }
}
