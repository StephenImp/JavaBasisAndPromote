package com.cn.session_7.application_2_2.partOne;

public class Downcase extends Processor {

    @Override
    String process(Object input) {
        return ((String) input).toLowerCase();
    }
}
