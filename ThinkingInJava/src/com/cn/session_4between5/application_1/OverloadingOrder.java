package com.cn.session_4between5.application_1;

/**
 *  1 必须载同一个类中
 * 2 方法名相同
 * 3 方法的参数的个数、顺序或类型不同
 * 4 与方法的修饰符和或返回值没有关系
 */
public class OverloadingOrder {

    static void print(String s,int i){
        System.out.println("String :"+s+",int:"+i);
    }

    static void print(int i,String s){
        System.out.println("int :"+i+",String"+s);
    }

    public static void main(String[] args) {

        print("String first",11);
        print(99,"int first");
    }
}
