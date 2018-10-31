package com.cn.MyAnnotation;

import com.sun.istack.internal.NotNull;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2018\10\31 0031.
 * 重复注解与类型注解
 */
public class TestAnnotation {

    private @NotNull Object obj = null;

    @Test
    public void test2(){

        System.out.println(obj);
    }

    /**
     * 定义注解，并指定容器类(重复注解)
     */
    @Test
    public void test1() throws NoSuchMethodException {

        Class<TestAnnotation> clazz = TestAnnotation.class;
        Method m1 = clazz.getMethod("show",String.class);

        MyAnnotation[] mas = m1.getAnnotationsByType(MyAnnotation.class);

        for (MyAnnotation myAnnotation:mas) {
            System.out.println(myAnnotation.value());
        }

        System.out.println("********************************");

        this.show("");
    }

    @MyAnnotation("hello")
    @MyAnnotation("World")
    public void show(@MyAnnotation("abc") String str ){
        System.out.println(str);

    }
}
