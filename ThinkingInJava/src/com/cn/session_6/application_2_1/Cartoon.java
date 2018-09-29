package com.cn.session_6.application_2_1;

/**
 * 在构建器中执行初始化，通过调用基础类构建器，后者有足够的能力和权限来执行对基础类的初始化。
 * 在衍生类的构建器中，Java 会自动插入对基础类构建器的调用。
 */
public class Cartoon extends Drawing {

    static {
        System.out.println("Cartoon的静态代码块");
    }

    {
        System.out.println("Cartoon的代码块");
    }

    public Cartoon(){
        print("Cartoon constructor");
    }

    @Override
    void display(){
        System.out.println("Cartoon的display()方法!");
    }
    
    public static void main(String[] args) {
        Cartoon x = new Cartoon();
        x.display();
    }
}
