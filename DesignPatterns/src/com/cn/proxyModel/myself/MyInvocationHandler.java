package com.cn.proxyModel.myself;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by MOZi on 2019/2/15.
 */
public class MyInvocationHandler<T> implements InvocationHandler{
    /**
     * 实现了接口的被代理类的对象的声明；
     */
    private T target;

    /**
     * 所有执行代理对象的方法都会被替换成执行invoke方法。
     * @param proxy		代表动态代理对象
     * @param method	代表正在执行的方法
     * @param args		代表调用目标方法时传入的实参
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(target,args);
        return result;
    }

    /**
     * 通过反射获取被代理类的信息
     * 通过代理类信息生成一个动态代理类的实例
     *
     * 被代理类对象接受入口。
     */
    public MyInvocationHandler(T target){
        this.target = target;
    }
}
