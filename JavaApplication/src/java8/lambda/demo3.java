package java8.lambda;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;

/**
 * Created by MOZi on 2019/2/26.
 */
public class demo3 {

    public static void main(String[] args) {

        //语法格式1：无参，无返回值
        Runnable r1 = ()-> System.out.println("hello  world");


        //语法格式2：    一个参数
        Consumer<String> run  = (args1)-> System.out.println(args1);


        //语法格式3:  只需要一个参数，参数的小括号可以省略
        Consumer<String> run1  = args1-> System.out.println(args1);


        //语法格式4:  需要两个参数，并且有返回值
        BinaryOperator<Long> bo = (x,y)->{
            System.out.println("实现函数接口的方法！");
            return x+y;
        };

        //语法格式5: 当lambda体只有一条语句时，return与大括号可以省略
        BinaryOperator<Long> bo1 = (x,y)->  x+y;

        //语法6:数据类型可以省略，因为可以由编译器推断得出，称为"推断类型"
        BinaryOperator<Long> bo2 = (Long x,Long y)->{
            System.out.println("实现函数接口的方法！");
            return x+y;
        };

    }
}
