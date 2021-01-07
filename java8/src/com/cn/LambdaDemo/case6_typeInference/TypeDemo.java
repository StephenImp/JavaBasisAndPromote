package com.cn.LambdaDemo.case6_typeInference;

/**
 * 类型推断
 *
 * 需要告诉编译器Lambda表达式 实现的接口
 *
 */
public class TypeDemo {

    @FunctionalInterface
    interface IMatch{
        int add(int x,int y);
    }

    @FunctionalInterface
    interface IMatch2{
        int sub(int x,int y);
    }

    public static IMatch createLambda(){
        return (x,y)-> x+y;
    }

    public void test(IMatch match){

    }

    public void test(IMatch2 match){

    }

    public static Integer getValue(int x,int y,IMatch2 match){
        return match.sub(x,y);
    }



    public static void main(String[] args) {

        //定义变量类型  这个lambda 表达式 被指定是IMatch 类型的接口
        //IMatch lambda = (x,y)-> x+y ;
        Integer num = getValue(1,2,(x,y)-> x-y);
        System.out.println(num);


        //数组
        IMatch[] lambdas = {(x,y)-> x+y};
        Object lambdas2 = (IMatch)(x,y)-> x+y;

        //通过返回类型
        IMatch lambda3 = createLambda();


        //句柄调用
        TypeDemo demo = new TypeDemo();
        //demo.test((x,y)-> x+y);  //报错
        //当有二义性的时候，使用强转对应的接口进行解决
        demo.test((IMatch2) (x,y)-> x+y);
    }
}
