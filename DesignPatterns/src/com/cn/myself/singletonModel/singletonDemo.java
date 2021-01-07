package com.cn.myself.singletonModel;

/**
 * 单例设计模式：
 * 私有的构造器，私有静态的属性，公共的方法return一个实例。
 */
public class singletonDemo {

	//饿汉式
	private singletonDemo() {
	}

	private static singletonDemo demo = new singletonDemo();

	public static singletonDemo getNewinstance() {

		return demo;
	}


	//懒汉式
//	private singletonDemo() {
//	}
//
//	private static singletonDemo demo;
//
//	public static singletonDemo getNewinstance() {
//
//		if (demo == null) {
//			demo = new singletonDemo();
//		}
//		return demo;
//	}
}
