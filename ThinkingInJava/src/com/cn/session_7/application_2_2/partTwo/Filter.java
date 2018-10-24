package com.cn.session_7.application_2_2.partTwo;

public class Filter extends Processor{

    @Override
    public String name(){
        return getClass().getSimpleName();
    }
    
    public Waveform process(Waveform input){
        return input;
    }
}
