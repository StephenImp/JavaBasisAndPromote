package com.cn.session_7.application_2_1;

public class Wind implements Instrument {

    @Override
    public void play() {
        System.out.println("Wind5.play()");
    }

    @Override
    public String what() {
        return "Wind5";
    }

    @Override
    public void adjust() {
    }

}
