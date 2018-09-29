package com.cn.session_8.application_2_1.expand2;

/**
 * Created by admin on 2018/8/3.
 */
public class Gopher {

    private int gopherNumber;
    Gopher(int i) {
        gopherNumber = i;
    }
    void print(String msg) {
        if(msg != null){
            System.out.println(msg);
        }
        System.out.println(
                "Gopher number " + gopherNumber);
    }
}
