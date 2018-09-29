package com.cn.session_7.application_2_1.compare;

public class Wind extends Instrument {

    @Override
    public void play(Note n){
        System.out.println("Wind.play()"+n);
    }

    @Override
    public void adjust() {
    }

    @Override
    public String what(){
        return "Wind";
    }
    
}
