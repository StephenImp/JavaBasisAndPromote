package com.cn.session_4between5.application_2;

/**
 * 大转小(需要强转)
 *
 *如果传入的实际参数大，就要通过类型转换来执行窄化转换，
 * 不这样做，编译器会报错
 */
public class Demotion {

    static void prt(String s) {
        System.out.println(s);
    }

    void f1(char x) {
        prt("f1(char)");
    }
    void f1(byte x) {
        prt("f1(byte)");
    }
    void f1(short x) {
        prt("f1(short)");
    }
    void f1(int x) {
        prt("f1(int)");
    }
    void f1(long x) {
        prt("f1(long)");
    }
    void f1(float x) {
        prt("f1(float)");
    }
    void f1(double x) {
        prt("f1(double)");
    }
    
    
    
    void f2(byte x) {
        prt("f2(byte)");
    }
    void f2(short x) {
        prt("f2(short)");
    }
    void f2(int x) {
        prt("f2(int)");
    }
    void f2(long x) {
        prt("f2(long)");
    }
    void f2(float x) {
        prt("f2(float)");
    }
    void f2(double x) {
        prt("f2(double)");
    }
    
    
    
    void f3(short x) {
        prt("f3(short)");
    }
    void f3(int x) {
        prt("f3(int)");
    }
    void f3(long x) {
        prt("f3(long)");
    }
    void f3(float x) {
        prt("f3(float)");
    }
    void f3(double x) {
        prt("f3(double)");
    }
    
    
    
    void f4(int x) {
        prt("f4(int)");
    }
    void f4(long x) {
        prt("f4(long)");
    }
    void f4(float x) {
        prt("f4(float)");
    }
    void f4(double x) {
        prt("f4(double)");
    }
    
    
    
    void f5(long x) {
        prt("f5(long)");
    }
    void f5(float x) {
        prt("f5(float)");
    }
    void f5(double x) {
        prt("f5(double)");
    }
    
    
    void f6(float x) {
        prt("f6(float)");
    }
    void f6(double x) {
        prt("f6(double)");
    }
    
    
    
    void f7(double x) {
        prt("f7(double)");
    }
    
    void testDouble(){
        double x = 0;
        prt("double argument:");
        f1(x);f2((float)x);f3((long)x);f4((int)x);f5((short)x);f6((byte)x);f7((char)x);
    }
    
    public static void main(String[] args) {
        Demotion p  = new Demotion();
        p.testDouble();
    }
}
