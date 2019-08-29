package com.cn.session_7.application_1_1;


/**
 * 上溯造型
 */
public class Music {

    /**
     * 接收一个Instrument 句柄
     * 同时也接收从Instrument 衍生出来的所有东西
     *
     * 那这里就类似于工厂模式咯
     * @param i
     */
    public static void tune(Instrument i){
        i.play(Note.MIDDLE_C);
    }

    public static void main(String[] args) {
        Wind wind = new Wind();
        tune(wind);//Upcasting

        Brass brass = new Brass();
        tune(brass);

        Stringed stringed = new Stringed();
        tune(stringed);
    }

}
