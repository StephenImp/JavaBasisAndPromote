package com.cn.session_7.application_1_2;

/**
 * 打击乐器
 */
public class Percussion extends Instrument {

    @Override
    public void play(Note n){
        System.out.println("Percussion.play()"+n);
    }

    @Override
    public String What(){
        return "Percussion";
    }

    @Override
    void adjust(){
        System.out.println("Adjusting Percussion");
    }
}
