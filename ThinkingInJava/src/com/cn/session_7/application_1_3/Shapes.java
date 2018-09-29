package com.cn.session_7.application_1_3;

/**
 * 产生正确的行为
 * 后期绑定
 */
public class Shapes {

    /**
     * JVM加载时，就创建了RandomShapeGenerator对象
     */
    private static RandomShapeGenerator gen = new RandomShapeGenerator();
    
    public static void main(String[] args) {


        Shape [] s = new Shape[9];

        /**
         * 创建不同的子类对象
         */
        for(int i = 0;i<s.length;i++){
            s[i] = gen.next();
        }

        for(Shape shp:s){
            shp.draw();
        }
    }
}
