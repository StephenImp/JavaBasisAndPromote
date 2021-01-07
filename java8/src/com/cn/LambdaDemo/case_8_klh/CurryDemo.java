package com.cn.LambdaDemo.case_8_klh;

import java.util.function.Function;

/**
 * 级联表达式：就是有多个箭头的表达式
 * <p>
 * -> 左边是输入，右边是输出
 * <p>
 * 柯理化：把多个参数的函数转换为只有一个参数的函数
 * 意义：
 *      1.函数标准化
 *      2.高阶函数，就是返回函数的函数
 */
public class CurryDemo {

    public static void main(String[] args) {

        /**
         *
         * 级联表达式
         *
         * 解析  x -> y -> x + y;
         *
         * x -> (y -> x + y);
         * 入参是x,返回的是 (y -> x + y) 这个表达式
         *
         * y -> x + y
         * 入参是y,返回是x+y
         *
         * 所以是 Function<Integer, Function<Integer, Integer>>
         */
        Function<Integer, Function<Integer, Integer>> fun = x -> y -> x + y;

        //第一次调用返回的是一个函数
        Function<Integer, Integer> apply = fun.apply(2);
        //第二次调用，返回的是值  等价于下面的表达式
        Integer apply1 = apply.apply(3);
        System.out.println(fun.apply(2).apply(3));


        /**
         * 柯理化
         */
        Function<Integer, Function<Integer, Function<Integer, Integer>>> fun2 = x -> y -> z -> x + y + z;
        Integer apply2 = fun2.apply(2).apply(3).apply(5);
        System.out.println(apply2);


        System.out.println("-------------------------------------");

        /**
         * 所有的函数都是一样的，可以进行批量处理
         */
        int[] nums = {2,3,4};
        Function f = fun2;
        for (int i = 0; i <nums.length ; i++) {
            if (f instanceof Function){
                Object object = f.apply(nums[i]);
                if (object instanceof Function){
                    f= (Function) object;
                }else {
                    System.out.println("调用结束,结果为:"+object);
                }
            }
        }


    }
}
