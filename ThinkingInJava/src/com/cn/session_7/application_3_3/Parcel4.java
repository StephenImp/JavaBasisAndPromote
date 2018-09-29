package com.cn.session_7.application_3_3;

/**
 * Created by admin on 2018/8/2.
 */
public class Parcel4 {

    public Destination dest(String s) {
        
        class PDestination implements Destination {
            private String label;

            private PDestination(String whereTo) {
                label = whereTo;
            }

            @Override
            public String readLabel() {
                return label;
            }
        }
        return new PDestination(s);
    }
}
