package com.cn.session_6.application_3_4;

public class OverridingPrivate extends WithFinals {

    private final void f(){
        System.out.println("OverridingPrivate.f()");
    }
    
    private void g(){
        System.out.println("OverridingPrivate.g()");
    }
    
}
