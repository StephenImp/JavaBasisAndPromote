package com.cn.proxyModel;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Subject {
	void action();
}

/**
 * 被代理类①
 */
class RealSubject implements Subject {
	@Override
	public void action() {
		System.out.println("我是被代理类:--->RealSubject");
	}
}

/**
 * 被代理类②
 */
class RealSubject2 implements Subject{
	@Override
	public void action() {
		System.out.println("我是被代理类2:--->RealSubject2");
	}
}

class MyInvocationHandler implements InvocationHandler {
	/**
	 * 实现了接口的被代理类的对象的声明；
	 */
	Object obj;

	/**
	 * 通过反射获取被代理类的信息
	 */
	public Object blind(Object obj) {
		this.obj = obj;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj
				.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object returnVal = method.invoke(obj, args);
		return returnVal;
	}

}

/**
 * 动态代理的使用
 * 动态代理类，通过绑定不同的子类实例，执行不同的子类方法。
 */
public class TestProxy {

	public static void main(String[] args) {

		/**
		 * 动态代理类
		 */
		MyInvocationHandler handler = new MyInvocationHandler();

		RealSubject real = new RealSubject();
		RealSubject2 real2 = new RealSubject2();
		/**
		 * 获取被代理类的信息
		 */
		Object obj = handler.blind(real);
		Object obj2 = handler.blind(real2);
		Subject sub = (Subject)obj;
		Subject sub2 = (Subject)obj2;

		/**
		 * 这里执行DynamicProxy的invoke方法
		 */
		sub.action();
		sub2.action();



		NikeClothFactory nike = new NikeClothFactory();
		/**
		 * 获取被代理类的信息
		 */
		ClothFactory proxyCloth = (ClothFactory) handler.blind(nike);
		proxyCloth.productCloth();
	}
}