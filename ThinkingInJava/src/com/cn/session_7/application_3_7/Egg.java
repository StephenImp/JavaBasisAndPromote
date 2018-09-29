package com.cn.session_7.application_3_7;

/**
 * Created by admin on 2018/8/2.
 */
public class Egg {

    protected class Yolk {
        public Yolk() {
            System.out.println("Egg.Yolk()");
        }
    }

    private Yolk y;

    public Egg() {
        System.out.println("New Egg()");
        y = new Yolk();
    }
}
