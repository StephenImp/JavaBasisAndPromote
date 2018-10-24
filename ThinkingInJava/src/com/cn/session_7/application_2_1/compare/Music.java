package com.cn.session_7.application_2_1.compare;

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

        /**
         * 衍生类拥有基类的属性。
         */
        Instrument i = new Woodwind();
        System.out.println(i.i);
    }
}
