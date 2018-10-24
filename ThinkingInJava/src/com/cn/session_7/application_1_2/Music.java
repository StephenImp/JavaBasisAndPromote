package com.cn.session_7.application_1_2;

/**
 * 向上转型的深入理解
 */
public class Music {

    public static void tune(Instrument i){
        i.play(Note.MIDDLE_C);
    }
    
    public static void tuneAll(Instrument[] e){
        for(Instrument i:e){
            tune(i);
        }
    }

    public static void main(String[] args) {
        
        Instrument [] orchestra = {
          new Wind(),
          new Percussion(),
          new Stringed(),
          new Brass(),
          new Woodwind(),
        };
        
        tuneAll(orchestra);
    }
}
