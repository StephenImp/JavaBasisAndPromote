package com.cn.session_7.application_2_1.compare;

public class Stringed extends Instrument {
    
    public void play(Note n){
        System.out.println("Stringed.play()"+n);
    }
    
    public String What(){
        return "Stringed";
    }
    
    public void adjust(){
        System.out.println("Adjusting Stringed");
    }
}
