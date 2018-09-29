package com.cn.session_4between5.application_3;

/**
 * 在构造器中调用构造器
 *
 * 注意：
 * ①必须将构造器置于最始处(this的调用必须在方法的第一行)
 * ②this可以调用一个构造器，但是不能调用两个
 * ③this.成员变量--->区分入参与成员变量
 *
 */
public class Flower {
    
    int petalCount = 0;
    String s  = new String("null");
    
    Flower(int petals){
        petalCount = petals;
        System.out.println("Constructor w/int arg only,petalCount = "+ petalCount);
    }
    
    Flower(String ss){
        System.out.println("Constructor w/String arg only,s = "+ ss);
        s = ss;
    }
    
    Flower(String s,int petals){
        this(petals);
        //this(s);  Can't call two!
        this.s = s;//Another use of "this"
        System.out.println("String & int args");
    }
    
    Flower(){
        this("hi",47);
        System.out.println("default constructor (no args)");
    }

    void print(){
        //this(11);  Not inside non-constructor!
        System.out.println("petalCount = "+petalCount+"s = "+s);
    }
    
    public static void main(String[] args) {
        Flower x = new Flower();
        x.print();
    }
}
