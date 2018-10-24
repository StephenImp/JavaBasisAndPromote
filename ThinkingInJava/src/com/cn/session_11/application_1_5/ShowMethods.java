package com.cn.session_11.application_1_5;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by admin on 2018/8/6.
 * 因为由Class.forName()产生的结果不能在编译期间获知，所以所有方法签名信息都会在运行期间提取。
 *
 * 可对一个编译期完全未知的对象进行实际的设置以及发出方法调用。
 * 同样地，这也属于几乎完全不用我们操心的一个步骤
 *
 *
 *
 */
public class ShowMethods {

    static final String usage =
            "usage: \n" +
                    "ShowMethods qualified.class.name\n" +
                    "To show all methods in class or: \n" +
                    "ShowMethods qualified.class.name word\n" +
                    "To search for methods involving 'word'";

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println(usage);
            System.exit(0);
        }
        try {
            Class c = Class.forName(args[0]);
            Method[] m = c.getMethods();
            Constructor[] ctor = c.getConstructors();
            if (args.length == 1) {
                for (int i = 0; i < m.length; i++){
                    System.out.println(m[i].toString());
                }

                for (int i = 0; i < ctor.length; i++){
                    System.out.println(ctor[i].toString());
                }

            } else {
                for (int i = 0; i < m.length; i++){
                    if (m[i].toString().indexOf(args[1]) != -1){
                        System.out.println(m[i].toString());
                    }
                }

                for (int i = 0; i < ctor.length; i++){
                    if (ctor[i].toString().indexOf(args[1]) != -1){
                        System.out.println(ctor[i].toString());
                    }
                }

            }
        } catch (ClassNotFoundException e) {
            System.out.println("No such class: " + e);
        }
    }
}
