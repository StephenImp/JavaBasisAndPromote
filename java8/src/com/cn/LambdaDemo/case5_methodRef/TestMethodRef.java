package com.cn.LambdaDemo.case5_methodRef;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.*;

import com.cn.LambdaDemo.case1_baseStrategy.Employee;
import org.junit.Test;

/*

	函数的参数跟箭头左边是一样的话，则可以使用方法引用。***


 * 一、方法引用：若 Lambda 体中的功能，已经有方法提供了实现，可以使用方法引用
 * 			  （可以将方法引用理解为 Lambda 表达式的另外一种表现形式）
 * 
 * 1. 对象的引用 :: 实例方法名
 * 
 * 2. 类名 :: 静态方法名
 * 
 * 3. 类名 :: 实例方法名
 * 
 * 注意：
 *
 * 	 ①方法引用所引用的方法的参数列表与返回值类型，需要与函数式接口中抽象方法的参数列表和返回值类型保持一致！
 *
  * ②若Lambda 的参数列表的第一个参数，是实例方法的调用者，第二个参数(或无参)是实例方法的参数时，
  * 	格式： ClassName::MethodName
 * 
 * 二、构造器引用 :构造器的参数列表，需要与函数式接口中参数列表保持一致！
 * 
 * 1. 类名 :: new
 * 
 * 三、数组引用
 * 
 * 	类型[] :: new;
 * 
 * 
 */
public class TestMethodRef {
	//数组引用
	@Test
	public void test8(){
		Function<Integer, String[]> fun = (args) -> new String[args];
		String[] strs = fun.apply(10);
		System.out.println(strs.length);
		
		System.out.println("--------------------------");
		
		Function<Integer, Employee[]> fun2 = Employee[] :: new;
		Employee[] emps = fun2.apply(20);
		System.out.println(emps.length);
	}

	/**
	 * 构造器引用
	 */
	@Test
	public void test7(){

		Function<String, Employee> fun = Employee::new;
		Employee e = fun.apply("wpw");
		System.out.println(e);

		BiFunction<String, Integer, Employee> fun2 = Employee::new;
		Employee e1 = fun2.apply("cl", 18);
		System.out.println(e1);
	}
	
	@Test
	public void test6(){

		Supplier<Employee> sup = () -> new Employee();
		System.out.println(sup.get());
		
		System.out.println("------------------------------------");
		
		Supplier<Employee> sup2 = Employee::new;
		System.out.println(sup2.get());
	}
	
	//类名 :: 实例方法名
	@Test
	public void test5(){
		BiPredicate<String, String> bp = (x, y) -> x.equals(y);
		System.out.println(bp.test("abcde", "abcde"));
		
		System.out.println("-----------------------------------------");
		
		BiPredicate<String, String> bp2 = String::equals;
		System.out.println(bp2.test("abc", "abc"));
		
		System.out.println("-----------------------------------------");
		
		
		Function<Employee, String> fun = (e) -> e.show();
		System.out.println(fun.apply(new Employee()));
		
		System.out.println("-----------------------------------------");
		
		Function<Employee, String> fun2 = Employee::show;
		System.out.println(fun2.apply(new Employee()));
		
	}
	
	//类名 :: 静态方法名
	@Test
	public void test4(){
		Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
		com.compare(1,2);
		
		System.out.println("-------------------------------------");
		
		Comparator<Integer> com2 = Integer::compare;
		com2.compare(1,2);
	}

	/**
	 * BiFunction接口
	 *
	 * 静态方法的方法引用
	 *
	 */
	@Test
	public void test3(){

		BiFunction<Double, Double, Double> fun = (x, y) -> Math.max(x, y);
		System.out.println(fun.apply(1.5, 22.2));
		
		System.out.println("--------------------------------------------------");
		
		BiFunction<Double, Double, Double> fun2 = Math::max;
		System.out.println(fun2.apply(1.2, 1.5));
	}

	/**
	 * Supplier接口
	 *
	 * 非静态方法的方法引用
	 *
	 */
	//对象的引用 :: 实例方法名
	@Test
	public void test2(){
		Employee emp = new Employee(101, "张三", 18, 9999.99);
		
		Supplier<String> sup = () -> emp.getName();
		System.out.println(sup.get());
		
		System.out.println("----------------------------------");
		
		Supplier<String> sup2 = emp::getName;
		System.out.println(sup2.get());

		System.out.println("----------------------------------");

		UnaryOperator<String> function = emp::getEmpNameDoing;
		function.apply("在学习");

		System.out.println("----------------------------------");

		//IntUnaryOperator

		System.out.println("----------------------------------");
		//两个输入一个输出
		BiFunction<Employee,String,String> function1 =  Employee::getEmpNameDoing;
		/**
		 * 普通对象是值传递，基本数据类型才是引用传递。
		 */
		//emp = null;
		function1.apply(emp,"依旧在学习");
	}

	/**
	 * Consumer接口
	 * 函数的参数跟箭头左边是一样的话，则可以使用方法引用。
	 *
	 */
	@Test
	public void test1(){

		Consumer<String> con = (str)-> System.out.println(str);
		con.accept("Hello con!");

		System.out.println("--------------------------------");

		PrintStream ps = System.out;

		Consumer<String> con1 = (str) -> ps.println(str);
		con1.accept("Hello con1！");
		
		System.out.println("--------------------------------");
		
		Consumer<String> con2 = ps::println;
		con2.accept("Hello con2！");

		System.out.println("--------------------------------");
		
		Consumer<String> con3 = System.out::println;
		con3.accept("Hello con3！");
	}
	
}
