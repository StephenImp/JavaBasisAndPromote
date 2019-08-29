package com.cn.session_4between5.application_2;


/**
 * 小转大
 * ①：常量数值5被当做int值处理，所以如果有某个重载方法接收int型参数，它就会被调用
 * ②：如果传入的数据类型（实际参数类型）小于方法中声明的形式参数类型，实际数据类型会被提升
 * ③：char类型略有不同，如果无法找到恰好接收char类型的方法,就会把char类型直接提升至int类型
 */
public class PrimitiveOverloading {

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



    void testConstVal(){
        prt("testing With 5");
        f1(5);f2(5);f3(5);f4(5);f5(5);f6(5);f7(5);
    }

    void testChar(){
        char x = 'x';
        prt("char argument:");
        f1(x);f2(x);f3(x);f4(x);f5(x);f6(x);f7(x);
    }

    void testByte(){
        byte x = 0;
        prt("byte argument:");
        f1(x);f2(x);f3(x);f4(x);f5(x);f6(x);f7(x);
    }

    void testShort(){
        short x = 0;
        prt("short argument:");
        f1(x);f2(x);f3(x);f4(x);f5(x);f6(x);f7(x);
    }

    void testInt(){
        int x = 0;
        prt("int argument:");
        f1(x);f2(x);f3(x);f4(x);f5(x);f6(x);f7(x);
    }

    void testLong(){
        long x = 0;
        prt("long argument:");
        f1(x);f2(x);f3(x);f4(x);f5(x);f6(x);f7(x);
    }

    void testFloat(){
        long x = 0;
        prt("float argument:");
        f1(x);f2(x);f3(x);f4(x);f5(x);f6(x);f7(x);
    }


    void testDouble(){
        double x = 0;
        prt("double argument:");

        f1(x);f2(x);f3(x);f4(x);f5(x);f6(x);f7(x);
    }

    public static void main(String[] args) {
        PrimitiveOverloading p = new PrimitiveOverloading();
        p.testConstVal();
        p.testChar();
        p.testByte();
        p.testShort();
        p.testInt();
        p.testLong();
        p.testFloat();
        p.testDouble();
    }
}
