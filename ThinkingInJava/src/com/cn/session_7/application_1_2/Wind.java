package com.cn.session_7.application_1_2;

public class Wind extends Instrument {

    @Override
    public void play(Note n){
        System.out.println("Wind.play()"+n);
    }

    @Override
    public String What(){
        return "Wind";
    }

    @Override
    void adjust(){
        System.out.println("Adjusting Wind");
    }
}
