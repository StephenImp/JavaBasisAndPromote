package com.cn.session_7.application_1_3;

import java.util.Random;

public class RandomShapeGenerator {

    public RandomShapeGenerator(){
        System.out.println("RandomShapeGenerator的构造器");
    }

    private Random rand = new Random(47);

    /**
     * 它的作用是在每次调用它时为某个随机选择的Shape 对象生成一个句柄。
     */
    public Shape next(){
        switch(rand.nextInt(3)){
            default:
            case 0:return new Circle();
            case 1:return new Square();
            case 2:return new Triangle();
        }
    }
}
