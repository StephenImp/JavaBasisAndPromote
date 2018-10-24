package com.cn.session_7.application_1_1;

/**
 * 风琴
 */
public class Wind extends Instrument {

    @Override
    public void play(Note n){
        System.out.println("Wind.play()"+n);
    }
    
}
