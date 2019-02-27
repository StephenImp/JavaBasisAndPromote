package com.cn.proxyModel.myself;

import java.lang.reflect.Proxy;

/**
 * Created by MOZi on 2019/2/15.
 */
public class TestProxy {

    public static void main(String[] args) {

        //1.创建被代理类的实例对象
        Person zhangSan = new Student();

        //2.创建一个与被代理对象相关联的InvocationHandler
        MyInvocationHandler<Person> myInvocationHandler = new MyInvocationHandler<>(zhangSan);

        //3.创建一个代理对象stuProxy来代理zhangSan，代理对象的每个执行方法都会替换执行Invocation中的invoke方法
        Person stuProxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class<?>[]{Person.class}, myInvocationHandler);

        stuProxy.giveMoney();
    }



}
