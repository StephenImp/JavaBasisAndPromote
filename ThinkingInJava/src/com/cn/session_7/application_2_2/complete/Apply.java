package com.cn.session_7.application_2_2.complete;

public class Apply {

    public static void process(Processor p ,Object s){
        System.out.println("Using process"+p.name());
        System.out.println(p.process(s));
    }
}
