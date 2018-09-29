package com.cn.session_7.application_2_2.partTwo;

/**
 * 完全解耦2
 */
public class Apply {

    public static void process(Processor p, Object s){
        System.out.println("Using Processor"+p.name());
        System.out.println(p.process(s));
    }
    

    public static void main(String[] args) {

        Waveform w1 = new Waveform();
        Apply.process(new LowPass(2.0),w1);

        Waveform w2 = new Waveform();
        Apply.process(new HighPass(1.0),w2);

        Waveform w3 = new Waveform();
        Apply.process(new BandPass(3.0,4.0),w3);

    }
    
}
