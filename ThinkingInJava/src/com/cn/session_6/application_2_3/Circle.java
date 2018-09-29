package com.cn.session_6.application_2_3;

public class Circle extends Shape{

    Circle(int i) {
        super(i);
        System.out.println("Drawing Circle");
    }

    @Override
    void dispose(){
        System.out.println("Erasing Circle");
        super.dispose();
    }
    
}
