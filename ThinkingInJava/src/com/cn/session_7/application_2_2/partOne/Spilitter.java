package com.cn.session_7.application_2_2.partOne;

import java.util.Arrays;

public class Spilitter extends Processor {

    @Override
    String process(Object input){
        return Arrays.toString(((String)input).split(" "));
    }
}
