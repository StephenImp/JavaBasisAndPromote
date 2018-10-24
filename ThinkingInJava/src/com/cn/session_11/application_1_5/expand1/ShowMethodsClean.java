package com.cn.session_11.application_1_5.expand1;

import java.lang.reflect.*;

/**
 * Created by admin on 2018/8/6.
 *
 * ShowMethodsClean方法非常接近前一个ShowMethods，只是它取得了Method 和Constructor 数组，并将它们转换成单个 String数组。
 * 随后，每个这样的 String对象都在 StripQualifiers.Strip()里“过”一遍，删除所有方法限定词。
 * 正如大家看到的那样，此时用到了StreamTokenizer 和String 来完成这个工作。
 * 假如记不得一个类是否有一个特定的方法，而且不想在联机文档里逐步检查类结构，
 * 或者不知道那个类是否能对某个对象（如Color 对象）做某件事情，该工具便可节省大量编程时间。
 */
public class ShowMethodsClean {

    static final String usage =
            "usage: \n" +
                    "ShowMethodsClean qualified.class.name\n" +
                    "To show all methods in class or: \n" +
                    "ShowMethodsClean qualif.class.name word\n" +
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
            // Convert to an array of cleaned Strings:
            String[] n =new String[m.length + ctor.length];

            for (int i = 0; i < m.length; i++) {
                String s = m[i].toString();
                n[i] = StripQualifiers.strip(s);
            }
            for (int i = 0; i < ctor.length; i++) {
                String s = ctor[i].toString();
                n[i + m.length] =StripQualifiers.strip(s);
            }
            if (args.length == 1){
                for (int i = 0; i < n.length; i++){
                    System.out.println(n[i]);
                }
            }
            else{
                for (int i = 0; i < n.length; i++){
                    if (n[i].indexOf(args[1]) != -1){
                        System.out.println(n[i]);
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("No such class: " + e);
        }
    }
}
