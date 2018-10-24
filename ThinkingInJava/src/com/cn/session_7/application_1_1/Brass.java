package com.cn.session_7.application_1_1;

/**
 *  黄铜制品
 */
public class Brass extends Instrument {
    
   @Override
    public void play(Note n){
        System.out.println("Brass.play()"+n);
    }
}
