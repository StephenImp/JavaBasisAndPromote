package com.cn.StreamAPI.caseDemo;

import com.cn.StreamAPI.caseDemo.entity.Employee;
import com.cn.StreamAPI.caseDemo.entity.Employee.Status;
import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

/**
 * Stream 终止操作。
 *
 * 查找与匹配
 * allMatch --检查是否匹配所有元素
 * anyMatch --检查是否匹配一个元素
 * noneMatch--检查是否没有匹配所有元素
 * findFirst--返回第一个元素
 * findAny--返回当前流中的任意元素
 * count--返回流中元素总个数
 * max--返回流中最大值
 * min--返回流中最小值
 *
 */
public class TestStreamAPI2 {

	List<Employee> emps = Arrays.asList(
			new Employee(102, "李四", 79, 6666.66, Status.BUSY),
			new Employee(101, "张三", 18, 9999.99, Status.FREE),
			new Employee(103, "王五", 28, 3333.33, Status.VOCATION),
			new Employee(104, "赵六", 8, 7777.77, Status.BUSY),
			new Employee(104, "赵六", 8, 7777.77, Status.FREE),
			new Employee(104, "赵六", 8, 7777.77, Status.FREE),
			new Employee(105, "田七", 38, 5555.55, Status.BUSY)
	);

	/**
	 * allMatch --检查是否匹配所有元素
	 */
	@Test
	public void test1(){
		boolean b = emps.stream()
				.allMatch((e) -> e.getStatus().equals(Status.BUSY));
		System.out.println(b);

	}

	/**
	 * anyMatch --检查是否匹配一个元素
	 */
	@Test
	public void test2(){
		boolean b = emps.stream()
				.anyMatch((e) -> e.getStatus().equals(Status.BUSY));
		System.out.println(b);

	}

	/**
	 * noneMatch--检查是否没有匹配所有元素
	 */
	@Test
	public void test3(){
		boolean b = emps.stream()
				.noneMatch((e) -> e.getStatus().equals(Status.BUSY));
		System.out.println(b);

	}

	/**
	 * findFirst--返回第一个元素
	 */
	@Test
	public void test4(){

//		Optional<Employee> first = emps.stream().sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
//				.findFirst();

		Optional<Employee> first = emps.stream().sorted(Comparator.comparingDouble(Employee::getSalary))
				.findFirst();

		System.out.println(first.get());
	}

	/**
	 *  *findAny--返回当前流中的任意元素
	 */
	@Test
	public void test5(){

		/**
		 * 串行
		 */
//		Optional<Employee> any = emps.stream()
//				.filter((e) -> e.getStatus().equals(Status.BUSY))
//				.findAny();

		/**
		 * 并行流
		 */
		Optional<Employee> any1 = emps.parallelStream()
				.filter((e) -> e.getStatus().equals(Status.BUSY))
				.findAny();

		System.out.println(any1.get());
	}

	/**
	 *  count--返回流中元素总个数
	 *  max--返回流中最大值
	 */
	@Test
	public void test6(){
		long count = emps.stream()
				.filter((e) -> e.getStatus().equals(Status.FREE))
				.count();

		System.out.println(count);

		/**
		 * 最大值
		 */
		Optional<Double> op = emps.stream()
				.map(Employee::getSalary)
				.max(Double::compare);

		System.out.println(op.get());

		/**
		 * 最小值
		 */
		Optional<Employee> op2 = emps.stream()
				.min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));

		System.out.println(op2.get());
	}

	//注意：流进行了终止操作后，不能再次使用
	@Test
	public void test7(){
		Stream<Employee> stream = emps.stream()
				.filter((e) -> e.getStatus().equals(Status.FREE));

		long count = stream.count();

		stream.map(Employee::getSalary)
				.max(Double::compare);
	}
}
