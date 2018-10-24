package com.cn.session_8.application_2_1.expand1;

/**
 * Created by admin on 2018/8/3.
 */
public class MouseTrap {

    static void caughtYa(Object m) {
        Mouse mouse = (Mouse)m; // Cast from Object
        mouse.print("Caught one!");
    }
}
