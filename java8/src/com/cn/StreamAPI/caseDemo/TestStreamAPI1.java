package com.cn.StreamAPI.caseDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.cn.StreamAPI.caseDemo.entity.Employee;
import org.junit.Test;

/*
 * 一、 Stream 的操作步骤
 *
 * 1. 创建 Stream
 *
 * 2. 中间操作
 *
		①映射
		map——接收 Lambda ， 将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
		*
		* 对每一条输入进行指定的操作，然后为每一条输入返回一个对象  ***

		flatMap——接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
		*
		* 最后将所有对象合并为一个对象***

		②排序
		sorted()——自然排序(Comparable)
		sorted(Comparator com)——定制排序(Comparator)
 *
 * 3. 终止操作
 */
public class TestStreamAPI1 {

	List<Employee> emps = Arrays.asList(
			new Employee(102, "李四", 59, 6666.66),
			new Employee(101, "张三", 18, 9999.99),
			new Employee(103, "王五", 28, 3333.33),
			new Employee(104, "赵六", 8, 7777.77),
			new Employee(104, "赵六", 8, 7777.77),
			new Employee(104, "赵六", 8, 7777.77),
			new Employee(105, "田七", 38, 5555.55)
	);

	//2. 中间操作
	/*
		映射
		map——接收 Lambda ， 将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
		flatMap——接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流

	 类比List  add()   addAll()

	 */
	@Test
	public void test1(){
		Stream<String> str = emps.stream()
			.map((e) -> e.getName());

		//System.out.println("-------------------------------------------");

		List<String> strList = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");

		Stream<String> stream = strList.stream()
			   .map(String::toUpperCase);

		//stream.forEach(System.out::println);
		//System.out.println("-------------------------------------------");

		/**
		 * .map--->  Stream<Stream<Character>> stream2
		 */
//		Stream<Stream<Character>> stream2 = strList.stream()
//			   .map(TestStreamAPI1::filterCharacter);//{{a,a,a},{b,b,b}....}
//
//		stream2.forEach((sm) -> {
//			sm.forEach(System.out::print);
//		});

		List<Stream<Character>> collect = strList.stream().map(TestStreamAPI1::filterCharacter).collect(Collectors.toList());
		collect.forEach(s-> {
			System.out.println(s.collect(Collectors.toList()));
		});

		System.out.println("---------------------------------------------");

		/**
		 * .flatMap--->  Stream<Character> stream3
		 */
//		Stream<Character> stream3 = strList.stream()
//			   .flatMap(TestStreamAPI1::filterCharacter);//{a,a,a,b,b,b }
//
//		stream3.forEach(System.out::print);

		List<Character> collect1 = strList.stream().flatMap(TestStreamAPI1::filterCharacter).collect(Collectors.toList());
		System.out.println(collect1);
		//collect1.forEach(System.out::println);
	}

	public static Stream<Character> filterCharacter(String str){
		List<Character> list = new ArrayList<>();

		for (Character ch : str.toCharArray()) {
			list.add(ch);
		}

		return list.stream();
	}

	/*
		sorted()——自然排序
		sorted(Comparator com)——定制排序
	 */
	@Test
	public void test2(){

		/**
		 * 自然排序
		 */
		emps.stream()
			.map(Employee::getName)
			.sorted()
			.forEach(System.out::println);

		System.out.println("------------------------------------");

		/**
		 * 定制排序
		 */
		emps.stream()
			.sorted((x, y) -> {
				if(x.getAge() == y.getAge()){
					return x.getName().compareTo(y.getName());
				}else{
					return Integer.compare(x.getAge(), y.getAge());
				}
			}).forEach(System.out::println);
	}
}
