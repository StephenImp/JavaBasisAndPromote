package com.cn.session_7.application_1_3;

public class Square extends Shape{

    @Override
    public void draw(){
        System.out.println("Square.draw()");
    }
    
    @Override
    public void erase(){
        System.out.println("Square.erase()");
    }
}
