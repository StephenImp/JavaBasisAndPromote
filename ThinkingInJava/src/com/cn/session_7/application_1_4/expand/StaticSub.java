package com.cn.session_7.application_1_4.expand;

public class StaticSub extends StaticSuper {

    public static String staticGet(){
        return "Derived staticGet()";
    }

    public String dynamicGet(){
        return "Derived dynamicGet()";
    }
    
}
