package com.cn.LambdaDemo.case1_baseStrategy;

/**
 * 函数式接口
 *
 * 函数式接口：接口中只有一个抽象方法的接口，称为函数式接口。 可以使用注解 @FunctionalInterface 修饰
 * 			   可以检查是否是函数式接口
 */
@FunctionalInterface
public interface MyPredicate<T> {

	public boolean test(T t);
	
}
