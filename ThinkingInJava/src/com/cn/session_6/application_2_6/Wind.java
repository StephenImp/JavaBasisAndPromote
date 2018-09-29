package com.cn.session_6.application_2_6;

/**
 * 
 ************************************************************
 * @类名 : Wind.java
 *
 * @DESCRIPTION : 向上转型
 * @AUTHOR :  admin
 * @DATE :  2017年9月28日
 ************************************************************
 */
public class Wind extends Instrument {

    public static void main(String[] args) {
        Wind flute = new Wind();
        Instrument.tune(flute);
    }
}
