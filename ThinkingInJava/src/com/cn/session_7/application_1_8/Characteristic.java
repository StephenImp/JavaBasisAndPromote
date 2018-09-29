package com.cn.session_7.application_1_8;

/**
 * 特性
 */
public class Characteristic {
    
    private String s;

    public Characteristic(String s) {
        this.s = s;
        System.out.println("Creating Characteristic" + s);
    }

    @Override
    protected void finalize(){
        System.out.println("finalizing Characteristic" + s);
    }

}
