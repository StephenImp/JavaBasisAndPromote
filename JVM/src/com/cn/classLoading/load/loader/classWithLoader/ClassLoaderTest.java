package com.cn.classLoading.load.loader.classWithLoader;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by MOZi on 2018/10/23.
 * 不同的类加载器对instanceof关键字运算结果的影响.
 *
 * 这里玩的有问题。
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws Exception{

        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {

                try {
                    String fileName = name.substring(name.lastIndexOf(".")+1)+".class";

                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null){
                        return super.loadClass(name);
                    }

                    byte[] b = new byte[is.available()];
                    is.read();
                    return defineClass(name,b,0,b.length);

                }catch (IOException e){
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object obj = myLoader.loadClass("com.cn.classLoading.load.loader.classWithLoader.ClassLoaderTest").newInstance();

        System.out.println(obj.getClass());
        System.out.println(obj instanceof com.cn.classLoading.load.loader.classWithLoader.ClassLoaderTest);

    }
}
