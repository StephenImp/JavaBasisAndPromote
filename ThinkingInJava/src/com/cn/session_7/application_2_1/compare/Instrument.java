package com.cn.session_7.application_2_1.compare;

abstract class Instrument {

    public int i =1;
    public abstract void play(Note n);
    public String what(){
        return "Instrument";
    }    
    public abstract void adjust();
}
