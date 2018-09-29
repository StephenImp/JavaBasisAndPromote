package com.cn.session_7.application_2_1.compare;

public class Percussion extends Instrument {

    public void play(Note n){
        System.out.println("Percussion.play()"+n);
    }
    
    public String What(){
        return "Percussion";
    }
    
    public void adjust(){
        System.out.println("Adjusting Percussion");
    }
}
