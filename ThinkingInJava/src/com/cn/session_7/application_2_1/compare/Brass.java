package com.cn.session_7.application_2_1.compare;

public class Brass extends Wind {

    @Override
    public void play(Note n){
        System.out.println("Brass.play()"+n );
    }

    @Override
    public void adjust(){
        System.out.println("Adjusting Brass");
    }
    
}
