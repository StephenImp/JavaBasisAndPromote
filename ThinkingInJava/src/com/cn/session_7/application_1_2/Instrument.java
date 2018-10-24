package com.cn.session_7.application_1_2;

public class Instrument {
    
    public void play(Note n){
        System.out.println("Instrument.play()"+n);
    }
    
    public String What(){
        return "Instrument";
    }
    
    void adjust(){
        System.out.println("Adjusting Instrument");
    }
}
