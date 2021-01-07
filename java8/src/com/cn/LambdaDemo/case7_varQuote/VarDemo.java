package com.cn.LambdaDemo.case7_varQuote;

import java.util.function.Consumer;

/**
 * 变量引用
 */
public class VarDemo {

    public static void main(String[] args) {

        /**
         * 这里的变量其实是final类型的，只是jdk8后默认省略了这个final
         */
        String str = "变量引用"; //
        //str = ""; //报错
        // 这里的 str 和上面的 str是不一样的，这里的str是  "变量引用" 本身，上面的只是音容，是两个东西
        //java 的参数是 值传递，不是引用传递。
        Consumer<String> consumer = s-> System.out.println(s+str);

        //为什么修改了方法引用就不行了？
        //Consumer<String> consumer1 = s1-> System.out::println(s1+str);




    }
}
