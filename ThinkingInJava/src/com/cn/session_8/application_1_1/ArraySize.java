package com.cn.session_8.application_1_1;

/**
 * Created by admin on 2018/8/3.
 * 数组和第一类对象
 */
public class ArraySize {

    public static void main(String[] args) {

        // Arrays of objects:
        Weeble[] a; // Null handle
        Weeble[] b = new Weeble[5]; // Null handles
        Weeble[] c = new Weeble[4];
        for (int i = 0; i < c.length; i++){
            c[i] = new Weeble();
        }

        Weeble[] d = {
                new Weeble(), new Weeble(), new Weeble()
        };

        // Compile error: variable a not initialized:
        //!System.out.println("a.length=" + a.length);
        System.out.println("b.length = " + b.length);  //5


        // The handles inside the array are
        // automatically initialized to null:
        for (int i = 0; i < b.length; i++){
            System.out.println("b[" + i + "]=" + b[i]);
        }

        System.out.println("c.length = " + c.length);  //4
        System.out.println("d.length = " + d.length);  //3


        /**
         * 向我们展示了如何取得同一个数组对象连接的句柄，
         * 然后将其赋给另一个数组对象，就象我们针对对象句柄的其他任何类型做的那样。
         * 现在，a和 d 都指向内存堆内同样的数组对象。
         */
        a = d;
        System.out.println("a.length = " + a.length);  //3
        // Java 1.1 initialization syntax:
        a = new Weeble[]{
                new Weeble(), new Weeble()
        };


        /**
         * 从效果上来看，数组的赋值却与基本数据类型类似
         */
        System.out.println("a.length = " + a.length);  //2
        System.out.println("d.length = " + d.length);  //3


        System.out.println();


        // Arrays of primitives:
        int[] e; // Null handle
        int[] f = new int[5];
        int[] g = new int[4];
        for (int i = 0; i < g.length; i++){
            g[i] = i * i;
        }

        int[] h = {11, 47, 93};


        // Compile error: variable e not initialized:
        //!System.out.println("e.length=" + e.length);
        System.out.println("f.length = " + f.length); //5


        // The primitives inside the array are
        // automatically initialized to zero:
        for (int i = 0; i < f.length; i++){
            System.out.println("f[" + i + "]=" + f[i]);
        }

        System.out.println("g.length = " + g.length); //4

        System.out.println("h.length = " + h.length); //3
        e = h;
        System.out.println("e.length = " + e.length); //3


        // Java 1.1 initialization syntax:
        e = new int[]{1, 2};
        System.out.println("e.length = " + e.length); //2
        System.out.println("h.length = " + h.length); //3
    }
}
