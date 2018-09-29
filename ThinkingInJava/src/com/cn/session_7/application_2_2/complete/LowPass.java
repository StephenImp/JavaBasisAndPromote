package com.cn.session_7.application_2_2.complete;

public class LowPass extends Filter {

    double cutoff;
    public LowPass(double cutoff){
        this.cutoff = cutoff;
    }

//    @Override
//    public Waveform process(Waveform input){
//        return input;
//    }
}
