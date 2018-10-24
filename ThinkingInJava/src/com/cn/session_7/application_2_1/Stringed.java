package com.cn.session_7.application_2_1;

public class Stringed implements Instrument {

    @Override
    public void play() {
        System.out.println("Stringed5.play()");
    }

    @Override
    public String what() {
        return "Stringed5";
    }

    @Override
    public void adjust() {
    }
}
