package com.cn.session_6.application_1_1;

public class Soap {
    private String s;
    
    public void print(String s){
        System.out.println(s);
    }
    
    Soap(){
     print("Soap()");
     s = "Contructed";
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String toString() {
        return s;
    }
    
}
