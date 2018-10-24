package com.cn.session_7.application_2_2.partTwo;

public class Processor {

    public String name() {
        return getClass().getSimpleName();
    }

    Object process(Object input) {
        return input;
    }
}
