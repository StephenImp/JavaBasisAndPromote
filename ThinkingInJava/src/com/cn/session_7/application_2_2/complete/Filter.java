package com.cn.session_7.application_2_2.complete;

public class Filter {

    public String name(){
        return getClass().getSimpleName();
    }
    
    public Waveform process(Waveform input){
        return input;
    }
}
