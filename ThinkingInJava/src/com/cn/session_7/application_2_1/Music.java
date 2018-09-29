package com.cn.session_7.application_2_1;


/**
 * 接口
 */
public class Music {

    /**
     * 我们在tune()方法中可以发现没有任何证据显示Instrument5到底是个“普通”类、“抽象”类还是一个“接口”。
     * 这是做是故意的：每种方法都使程序员能对对象的创建与使用进行不同的控制。
     */
    public static void tune(Instrument i){
        i.play();
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
