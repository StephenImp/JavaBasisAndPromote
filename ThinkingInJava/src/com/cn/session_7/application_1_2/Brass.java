package com.cn.session_7.application_1_2;

public class Brass extends Wind {

    @Override
    public void play(Note n){
        System.out.println("Brass.play()"+n );
    }

    @Override
    void adjust(){
        System.out.println("Adjusting Brass");
    }
    
}
