package com.cn.session_1between3.application_3;

public class PassObject {

    static void f(Letter y) {
        y.c = 'z';
    }

    public static void main(String[] args) {
        Letter x = new Letter();
        x.c = 'a';
        System.out.println("1:x.c--->"+x.c);
        
        System.out.println();
        f(x);
        System.out.println("2:x.c--->"+x.c);
    }
}
