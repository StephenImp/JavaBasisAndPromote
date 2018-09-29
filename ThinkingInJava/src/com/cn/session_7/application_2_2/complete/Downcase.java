package com.cn.session_7.application_2_2.complete;

public class Downcase extends StringProcessor{

    @Override
    public String process(Object input){
        return ((String)input).toLowerCase();
    }

}
