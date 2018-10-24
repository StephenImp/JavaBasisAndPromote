package com.cn.session_8.application_3_1.expand1;

/**
 * Created by admin on 2018/8/6.
 */
public class Hamster {

    private int hamsterNumber;

    Hamster(int i) {
        hamsterNumber = i;
    }

    @Override
    public String toString() {
        return "This is Hamster #" + hamsterNumber;
    }
}
