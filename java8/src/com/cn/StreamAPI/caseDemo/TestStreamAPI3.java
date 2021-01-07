package com.cn.StreamAPI.caseDemo;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.cn.StreamAPI.caseDemo.entity.Employee;
import com.cn.StreamAPI.caseDemo.entity.Employee.Status;
import org.junit.Test;

/**
 * Stream 终止操作。
 *
 * 一些统计操作
 *
 *
 *
 *
 */
public class TestStreamAPI3 {



	List<Employee> emps = Arrays.asList(
			new Employee(102, "李四", 79, 6666.66, Status.BUSY),
			new Employee(101, "张三", 18, 9999.99, Status.FREE),
			new Employee(103, "王五", 28, 3333.33, Status.VOCATION),
			new Employee(104, "赵六", 8, 7777.77, Status.BUSY),
			new Employee(104, "赵六", 8, 7777.77, Status.FREE),
			new Employee(104, "赵六", 8, 7777.77, Status.FREE),
			new Employee(105, "田七", 38, 5555.55, Status.BUSY)
	);


	@Test
	public void testImooc(){

		//汇总统计
		DoubleSummaryStatistics sumSalary = emps.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
		System.out.println(sumSalary);

		//分块统计
		Map<Boolean, List<Employee>> collect = emps.stream().collect(Collectors.partitioningBy(e -> e.getStatus() == Status.BUSY));
		System.out.println(collect);

		//得到所有分组的各个人数
		Map<Status, Long> num = emps.stream().collect(Collectors.groupingBy(Employee::getStatus, Collectors.counting()));
		System.out.println(num);


	}



	//3. 终止操作

	/**
	 归约
	 reduce(T identity, BinaryOperator) / reduce(BinaryOperator)
	 ——可以将流中元素反复结合起来，得到一个值。
	 */

	@Test
	public void test1(){
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

		Integer sum = list.stream()
			.reduce(0, (x, y) -> x + y);

		System.out.println(sum);

		System.out.println("----------------------------------------");

		Optional<Double> op = emps.stream()
			.map(Employee::getSalary)
			.reduce(Double::sum);

		System.out.println(op.get());
	}

	//需求：搜索名字中 “六” 出现的次数
	@Test
	public void test2(){
		Optional<Integer> sum = emps.stream()
			.map(Employee::getName)
			.flatMap(TestStreamAPI1::filterCharacter)
			.map((ch) -> {
				if(ch.equals('六'))
					return 1;
				else
					return 0;
			}).reduce(Integer::sum);

		System.out.println(sum.get());
	}

	/**
	 * 收集
	 * collect——将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
	 */
	@Test
	public void test3(){
		/**
		 * 存到List中
		 */
		List<String> list = emps.stream()
			.map(Employee::getName)
			.collect(Collectors.toList());

		list.forEach(System.out::println);

		System.out.println("----------------------------------");

		/**
		 * 存到set中
		 */
		Set<String> set = emps.stream()
			.map(Employee::getName)
			.collect(Collectors.toSet());

		set.forEach(System.out::println);

		System.out.println("----------------------------------");

		/**
		 * 存到HashSet中
		 */
		HashSet<String> hs = emps.stream()
			.map(Employee::getName)
			.collect(Collectors.toCollection(HashSet::new));

		hs.forEach(System.out::println);
	}

	@Test
	public void test4(){
		/**
		 * 最大值
		 */
		Optional<Double> max = emps.stream()
			.map(Employee::getSalary)
			.collect(Collectors.maxBy(Double::compare));

		System.out.println(max.get());

		/**
		 * 最小值
		 */
		Optional<Employee> op = emps.stream()
			.collect(Collectors.minBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));

		System.out.println(op.get());

		/**
		 * 工资总和
		 */
		Double sum = emps.stream()
			.collect(Collectors.summingDouble(Employee::getSalary));

		System.out.println(sum);

		/**
		 * 平均值
		 */
		Double avg = emps.stream()
			.collect(Collectors.averagingDouble(Employee::getSalary));

		System.out.println(avg);

		/**
		 * 总数
		 */
		Long count = emps.stream()
			.collect(Collectors.counting());

		System.out.println(count);

		System.out.println("--------------------------------------------");


		/**
		 * 组函数的另外一种实现方式
		 */
		DoubleSummaryStatistics dss = emps.stream()
			.collect(Collectors.summarizingDouble(Employee::getSalary));

		System.out.println(+dss.getMax());
		System.out.println(+dss.getAverage());
		System.out.println(+dss.getCount());
		System.out.println(+dss.getMin());
		System.out.println(+dss.getSum());
	}

	//分组(按照员工的状态分组)
	@Test
	public void test5(){
		Map<Status, List<Employee>> map = emps.stream()
			.collect(Collectors.groupingBy(Employee::getStatus));

		System.out.println(map);
	}

	//多级分组
	@Test
	public void test6(){
		Map<Status, Map<String, List<Employee>>> map = emps.stream()
			.collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e) -> {
				if(e.getAge() >= 60)
					return "老年";
				else if(e.getAge() >= 35)
					return "中年";
				else
					return "成年";
			})));

		System.out.println(map);
	}

	//分区(片)  true 和 false 两个区
	//满足条件一个区，不满足条件的一个区
	@Test
	public void test7(){
		Map<Boolean, List<Employee>> map = emps.stream()
			.collect(Collectors.partitioningBy((e) -> e.getSalary() >= 5000));

		System.out.println(map);
	}

	//连接字符串
	@Test
	public void test8(){
		String str = emps.stream()
			.map(Employee::getName)
			.collect(Collectors.joining("," , "----", "----"));

		System.out.println(str);
	}

	/**
	 * 计算总和
	 */
	@Test
	public void test9(){
		Optional<Double> sum = emps.stream()
			.map(Employee::getSalary)
			.collect(Collectors.reducing(Double::sum));

		System.out.println(sum.get());
	}
}
