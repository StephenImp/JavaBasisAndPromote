package com.cn.session_7.application_1_9;

public class Glyph {

     void draw(){
        System.out.println("Glyph.draw()");
    }

    Glyph(){
        System.out.println("Glyph() before draw()");

        //因为创建的是子类对象，所以这里是子类的实例在调用。
        draw();

        System.out.println("Glyph() after draw()");
    }

}
