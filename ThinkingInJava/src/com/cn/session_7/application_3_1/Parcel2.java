package com.cn.session_7.application_3_1;

/**
 * Created by admin on 2018/8/2.
 */
public class Parcel2 {

    class Contents {
        private int i = 11;

        public int value() {
            return i;
        }
    }

    class Destination {
        private String label;

        Destination(String whereTo) {
            label = whereTo;
        }

        String readLabel() {
            return label;
        }
    }

    public Destination to(String s) {
        return new Destination(s);
    }

    public Contents cont() {
        return new Contents();
    }

    public void ship(String dest) {
        Contents c = cont();
        System.out.println(c.value());

        Destination d = to(dest);
        System.out.println(d.readLabel());
    }

}
