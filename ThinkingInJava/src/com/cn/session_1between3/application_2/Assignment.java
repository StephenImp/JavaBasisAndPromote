package com.cn.session_1between3.application_2;

public class Assignment {
    public static void main(String[] args) {

        Number n1 = new Number();
        Number n2 = new Number();

        n1.i = 9;
        n2.i = 47;
        System.out.println("1:n1.i=" + n1.i + ",n2.i=" + n2.i);

        //n1.i = n2.i;//对基本数据类型的赋值


        /**
         * 对对象进行赋值
         * 由于赋值操作的是一个对象的引用，所以修改n1的同时也改变了n2
         * 这是由于n1和n2包含的是相同的引用，它们指向的是相同的对象
         * 在对n1赋值的时候，这个引用被覆盖，也就是丢失了，而那个不再被引用的对象会由“垃圾回收器”自动清理
         */
        n1 = n2;
        System.out.println("2:n1.i=" + n1.i + ",n2.i=" + n2.i);

        n1.i = 27;
        System.out.println("3:n1.i=" + n1.i + ",n2.i=" + n2.i);

    }
}
