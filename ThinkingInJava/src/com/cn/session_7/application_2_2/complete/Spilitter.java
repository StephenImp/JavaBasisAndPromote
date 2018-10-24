package com.cn.session_7.application_2_2.complete;

import java.util.Arrays;

public class Spilitter extends StringProcessor {

    @Override
    public String process(Object input){
        return Arrays.toString(((String)input).split(" "));
    }

}
