package com.cn.session_6.application_1;

/**
 * 编译器并不只是为每个句柄创建一个默认对象，因为那样会在许多情况下招致不必要的开销。
 * 如希望句柄得到初始化，可在下面这些地方进行：
     (1) 在对象定义的时候。这意味着它们在构建器调用之前肯定能得到初始化。
     (2) 在那个类的构建器中。
     (3) 紧靠在要求实际使用那个对象之前。这样做可减少不必要的开销——假如对象并不需要创建的话。
 */
public class SprinklerSystem {

    private String value1, value2, value3, value4;

    //WaterSourse sourse = new WaterSourse();
    WaterSourse sourse;

    int i;
    float f;

    void print() {
        System.out.println("value1=" + value1);
        System.out.println("value2=" + value2);
        System.out.println("value3=" + value3);
        System.out.println("value4=" + value4);
        System.out.println("i=" + i);
        System.out.println("f=" + f);
        System.out.println("sourse=" + sourse);

    }

    public static void main(String[] args) {
        SprinklerSystem x = new SprinklerSystem();
        x.print();
    }

}
