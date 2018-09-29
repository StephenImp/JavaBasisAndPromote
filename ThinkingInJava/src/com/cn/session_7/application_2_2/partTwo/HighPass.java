package com.cn.session_7.application_2_2.partTwo;

public class HighPass extends Filter {

    double cutoff;
    public HighPass(double cutoff){
        this.cutoff = cutoff;
    }

    @Override
    public Waveform process(Waveform input){
        return input;
    }
}
