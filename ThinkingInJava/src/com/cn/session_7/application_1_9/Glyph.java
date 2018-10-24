package com.cn.session_7.application_1_9;

public class Glyph {

     void draw(){
        System.out.println("Glyph.draw()");
    }
    
    Glyph(){
        System.out.println("Glyph() before draw()");
    
        draw();
        
        System.out.println("Glyph() after draw()");
    }
    
}
