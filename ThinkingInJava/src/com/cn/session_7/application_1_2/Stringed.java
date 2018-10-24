package com.cn.session_7.application_1_2;

/**
 * 弦
 */
public class Stringed extends Instrument {

    @Override
    public void play(Note n){
        System.out.println("Stringed.play()"+n);
    }

    @Override
    public String What(){
        return "Stringed";
    }

    @Override
    void adjust(){
        System.out.println("Adjusting Stringed");
    }
}
