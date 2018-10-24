package com.cn.session_7.application_1_2;

public class Woodwind extends Wind{

    @Override
    public void play(Note n){
        System.out.println("Wooding.play()"+n);
    }

    @Override
    public String What(){
        return "Wooding";
    }
    
}
