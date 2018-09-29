package com.cn.session_6.application_2_3;

/**
 * 三角形
 */
public class Triangle extends Shape {

    Triangle(int i) {
        super(i);
        System.out.println("Drawing Triangle");
        
    }

    @Override
    void dispose(){
        System.out.println("Erasing Triangle");
        super.dispose();
    }
    
}
