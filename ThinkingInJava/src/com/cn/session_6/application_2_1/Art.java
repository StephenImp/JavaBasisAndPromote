package com.cn.session_6.application_2_1;

public class Art {
    
    public void print(Object s){
        System.out.println(s);
    }

    static {
        System.out.println("Art的静态代码块");
    }

    {
        System.out.println("Art的代码块");
    }

    void display(){
        System.out.println("Art的display()方法!");
    }
    
    Art(){
        print("Art constructor");
    }

}
