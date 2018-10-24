package com.cn.session_11.application_1_2;

/**
 * Created by admin on 2018/8/6.
 *  Class 对象
 *
 *  理解：反射，运行时编译。
 *        静态，JVM加载时编译。
 */
public class SweetShop {
    /**
     * 在运行期，一旦我们想生成那个类的一个对象，用于执行程序的 Java 虚拟机（JVM）首先就会检查那个类型的Class对象是否已经载入。
     * 若尚未载入，JVM就会查找同名的.class 文件，并将其载入。
     * 所以Java 程序启动时并不是完全载入的，这一点与许多传统语言都不同。
     *
     * 一旦那个类型的Class 对象进入内存，就用它创建那一类型的所有对象。
     */

    public static void main(String[] args) {

        System.out.println("inside main");
        new Candy();
        System.out.println("After creating Candy");
        try {
            Class<?> Gum = Class.forName("com.cn.session_11.application_1_2.Gum");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("After Class.forName(\"Gum\")");

        new Cookie();
        System.out.println("After creating Cookie");
    }


    /**
     * 非常有趣的是，另一个 JVM的输出变成了另一个样子：
         Loading Candy
         Loading Cookie
         inside main
         After creating Candy
         Loading Gum
         After Class.forName("Gum")
         After creating Cookie
     看来JVM通过检查main()中的代码，已经预测到了对Candy 和Cookie 的需要，但却看不到Gum，因为它是通
     过对forName()的一个调用创建的，而不是通过更典型的new 调用。
     尽管这个JVM也达到了我们希望的效果，因为确实会在我们需要之前载入那些类，但却不能肯定这儿展示的行为百分之百正确。
     */
}
