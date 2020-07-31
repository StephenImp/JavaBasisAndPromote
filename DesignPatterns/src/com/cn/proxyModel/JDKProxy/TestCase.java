package com.cn.proxyModel.JDKProxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

/**
 * 我们发现， $Proxy0继承了Proxy类，同时还实现了Person接口，
 * 而且重写了findLove（）等方法。
 * 在静态块中用反射查找到了目标对象的所有方法，而且保存了所有方法的引用，
 * 重写的方法用反射调用目标对象的方法。
 */
public class TestCase {

    public static void main(String[] args) {
        try {
            Person obj = (Person) new JDKMeipo().getInstance(new Customer());
            obj.findLove();

            //通过反编译工具可以查看源代码
            //运行代码，我们能在E盘下找到一个$Proxy0.class文件。
            //使用Jad反编译，得到$Proxy0.jad文件
            byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});

            FileOutputStream os = new FileOutputStream("E://&$Proxy0.class");
            os.write(bytes);
            os.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
