package com.cn.session_7.application_2_2.partTwo;

public class BandPass extends Filter{

    double lowCutoff,highCutoff;

    public BandPass(double lowCut,double highCut){
        this.lowCutoff = lowCut;
        this.highCutoff = highCut;
    }

    @Override
    public Waveform process(Waveform input){
        return input;
    }
}
