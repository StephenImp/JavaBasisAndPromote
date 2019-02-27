package com.cn.proxyModel.myself;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by MOZi on 2019/2/15.
 */
public class MyInvocationHandler<T> implements InvocationHandler{

    private T target;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result = method.invoke(target,args);

        return result;
    }


    MyInvocationHandler(T target){
        this.target = target;
    }
}
