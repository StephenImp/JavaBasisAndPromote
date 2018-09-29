package com.cn.session_6.application_1;

public class WaterSourse {
    private String s;

    WaterSourse() {
        System.out.println("WaterSourse()");
        s = new String("Constructed");
    }

    @Override
    public String toString() {
        return s;
    }

}
