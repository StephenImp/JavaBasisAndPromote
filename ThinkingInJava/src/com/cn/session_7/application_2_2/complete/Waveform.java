package com.cn.session_7.application_2_2.complete;

/**
 * 波形
 */
public class Waveform {

    private static long counter;
    private final long id  = counter++;
    @Override
    public String toString(){
        return "Waveform"+id;
    }
}
