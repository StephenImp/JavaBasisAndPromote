package com.cn.session_8.application_3_1.expand1;

import java.util.Enumeration;

/**
 * Created by admin on 2018/8/6.
 */
public class Printer {

    static void printAll(Enumeration e) {
        while (e.hasMoreElements()) {
            System.out.println(e.nextElement().toString());
        }
    }
}
