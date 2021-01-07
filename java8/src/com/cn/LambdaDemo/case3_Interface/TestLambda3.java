package com.cn.LambdaDemo.case3_Interface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

import org.junit.Test;

/*
 * Java8 内置的四大核心函数式接口
 * 
 * Consumer<T> : 消费型接口
 * 		void accept(T t);
 * 
 * Supplier<T> : 供给型接口
 * 		T get(); 
 * 
 * Function<T, R> : 函数型接口
 * 		R apply(T t);
 * 
 * Predicate<T> : 断言型接口
 * 		boolean test(T t);
 *
 * UnaryOperator<T>:	一元函数(输入输出相同)   这个接口继承于 Function<T, R>
 *
 *    <T> UnaryOperator<T> identity()
 *
 *
 * BiFunction<T, U, R>: 两个输入一个输出
 * 		R apply(T t, U u);
 *
 *
 * BinaryOperator<T> extends BiFunction<T,T,T>	 二元函数，输入输出类型相同
 */

/**
 * 方法实现
 *
 * 调用方法
 */
public class TestLambda3 {

	/**
	 * lambda体是boolean类型的。
	 */
	//Predicate<T> 断言型接口：
	@Test
	public void test4(){
		List<String> list = Arrays.asList("Hello", "atguigu", "Lambda", "www", "ok");
		List<String> strList = filterStr(list, (s) -> s.length() > 3);
		
		for (String str : strList) {
			System.out.println(str);
		}
	}
	
	//需求：将满足条件的字符串，放入集合中
	public List<String> filterStr(List<String> list, Predicate<String> pre){
		List<String> strList = new ArrayList<>();
		
		for (String str : list) {
			if(pre.test(str)){
				strList.add(str);
			}
		}
		
		return strList;
	}

	/**
	 * 函数式接口，定义入参，出参。
	 */
	//Function<T, R> 函数型接口：
	@Test
	public void test3(){

		String newStr = strHandler("\t\t\t 我大尚硅谷威武   ", (str) -> str.trim());
		System.out.println(newStr);
		
		String subStr = strHandler("我大尚硅谷威武", (str) -> str.substring(2, 5));
		System.out.println(subStr);
	}
	
	//需求：用于处理字符串
	public String strHandler(String str, Function<String, String> fun){
		return fun.apply(str);
	}
	
	//Supplier<T> 供给型接口 :

	/**
	 * 供给型接口
	 * 传进去一个值，传出来一个值
	 */
	@Test
	public void test2(){
		List<Integer> numList = getNumList(10, () -> (int)(Math.random() * 100));
		
		for (Integer num : numList) {
			System.out.println(num);
		}
	}
	
	//需求：产生指定个数的整数，并放入集合中
	public List<Integer> getNumList(int num, Supplier<Integer> sup){
		List<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < num; i++) {
			Integer n = sup.get();
			list.add(n);
		}
		
		return list;
	}
	
	//Consumer<T> 消费型接口 :
	/**
	 * 参数--->利用参数，接口中方法的具体实现
	 *
	 * 传进去直接运行，不用返回的
	 */
	@Test
	public void test1(){
		happy(10000, (m) -> System.out.println("你们刚哥喜欢大宝剑，每次消费：" + m + "元"));
	} 
	
	public void happy(double money, Consumer<Double> con){
		con.accept(money);
	}
}
