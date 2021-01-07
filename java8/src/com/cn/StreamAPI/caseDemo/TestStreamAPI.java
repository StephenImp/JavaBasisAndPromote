package com.cn.StreamAPI.caseDemo;

import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.cn.LambdaDemo.case1_baseStrategy.Employee;
import org.junit.Test;

/*
 * 一、Stream API 的操作步骤：
 *
 * 1. 创建 Stream
 *
 * 2. 中间操作
	  筛选与切片
		filter——接收 Lambda ， 从流中排除某些元素。
		limit——截断流，使其元素不超过给定数量。
		skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
		distinct——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
 *
 * 3. 终止操作(终端操作)
 */
public class TestStreamAPI {


    /**
     * 外部迭代与内部迭代
     */
    @Test
    public void testImooc() {
        //List<Integer> nums = new ArrayList<>();
        //nums.add(1);
        //nums.add(2);
        //nums.add(3);
        int[] nums1 = {1, 2, 3};
        //外部迭代
        Integer sum = 0;
        for (Integer num : nums1) {
            sum += num;
        }
        System.out.println(sum);

        //Stream内部迭代
        //map 就是中间操作(返回stream操作)
        //sum 就是终止操作(返回结果)
        int sum1 = IntStream.of(nums1).map(i -> i * 2).sum();
        int sum2 = IntStream.of(nums1).map(TestStreamAPI::cal).sum();
        System.out.println(sum1);
        System.out.println(sum2);


        //惰性求值  这里跟spark 里面的action算子很像，但是这里有什么用呢？ todo
        System.out.println("惰性求值就是终止没有调用的情况下，中间操作不会执行");
        IntStream.of(nums1).map(TestStreamAPI::cal);

    }


    public static int cal(int i) {
        System.out.println(i + "*2");
        return i * 2;
    }

    /**
     * 并行流
     */
    @Test
    public void testParallelStream() {

        //①串行
        IntStream.range(1,100).peek(TestStreamAPI::debug).count();

        //②并行
        IntStream.range(1,100).parallel().peek(TestStreamAPI::debug).count();

        //③现在要实现一个效果:有两步操作，先并行再串行
        //多次调用串行和并行的函数的话，以最后一次为准
        IntStream.range(1, 100)
                .parallel().peek(TestStreamAPI::debug)
                .sequential().peek(TestStreamAPI::debug2)
                .count();


        //④并行流使用的线程池是ForkJoinPool.commonPool
        //默认的线程数是当前机器的cpu个数
        //使用这个属性可以修改默认的线程数
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","20");
        IntStream.range(1,100).parallel().peek(TestStreamAPI::debug).count();


        //⑤所有的并行流都使用相同的线程池，
        //使用自己的线程池，不适用默认的线程池，防止任务被阻塞
        //ForkJoinPool-1 线程名称
        ForkJoinPool pool = new ForkJoinPool(20);
        pool.submit(()->IntStream.range(1,100).parallel()
            .peek(TestStreamAPI::debug).count());
        pool.shutdown();

        // pool 是守护进程的方式运行，由于这里是运行在主函数里面，那么main()关闭了，pool也就关闭了
        synchronized (pool){
            try {
                pool.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void debug(int i) {
        System.out.println(Thread.currentThread().getName()+"debug" + i);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void debug2(int i) {
        System.err.println("debug" + i);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * Stream运行机制
     *
     * 1.如果都是无状态调用
     * 所有操作是链式调用，一个元素只调用一次。
     * 每一个中间操作返回一个新的流，流里面的一个属性 sourceStage执行同一个地方，就是Head
     * Head->nextStage->nextStage->..->null
     *
     * 2.如果是有状态调用
     *  有状态操作会把无状态操作截断，单独处理
     *
     * 3.并行条件下，有状态的操作不一定能并行操作
     *
     * 4.parallel/sequetial这里两个操作也是中间操作(也是返回Stream)
     *  但是他们不创建流，他们只修改head的并行标志
     *
     */
    @Test
    public void testStream(){


        Random random = new Random();
        //产生随机数

        //串行
//        Stream<Integer> stream = Stream.generate(() -> random.nextInt())
//                //产生500个(无限流需要短路操作)
//                .limit(500)
//                //第一个无状态操作
//                .peek(s -> print("peek " + s))
//
//                //有状态操作
//                .sorted((i1,i2)->{
//                    print("排序："+i1+","+i2);
//                    return i1.compareTo(i2);
//                })
//
//                //第二个无状态操作
//                .filter(s -> {
//                    print("filter " + s);
//                    return s > 10000;
//                });


        //并行
        Stream<Integer> stream = Stream.generate(() -> random.nextInt())
                //产生500个(无限流需要短路操作)
                .limit(50)
                //第一个无状态操作
                .peek(s -> print("peek " + s))

                //有状态操作
                .sorted((i1,i2)->{
                    print("排序："+i1+","+i2);
                    return i1.compareTo(i2);
                })

                //第二个无状态操作
                .filter(s -> {
                    print("filter " + s);
                    return s > 10000;
                }).parallel();


        //终止操作
        stream.count();
    }

    private void print(String s) {
        System.out.println(Thread.currentThread().getName()+" >:"+s);
    }

    //1. 创建 Stream
    @Test
    public void test1() {

        System.out.println("----------------------------------------------------------");

        //1. Collection 提供了两个方法  stream() 与 parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream(); //获取一个顺序流
        Stream<String> parallelStream = list.parallelStream(); //获取一个并行流

        //2. 通过 Arrays 中的 stream() 获取一个数组流
        Integer[] nums = new Integer[10];
        Stream<Integer> stream1 = Arrays.stream(nums);

        //3. 通过 Stream 类中静态方法 of()
        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5, 6);

        //4. 创建无限流  无限流有什么用？todo
        //①迭代
        Stream<Integer> stream3 = Stream.iterate(0, (x) -> x + 2).limit(10);
        stream3.forEach(System.out::println);

        //②生成
        Stream<Double> stream4 = Stream.generate(Math::random).limit(2);
        stream4.forEach(System.out::println);

    }

    //2. 中间操作
    List<Employee> emps = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );

	/*
	  筛选与切片
		filter——接收 Lambda ， 从流中排除某些元素。
		limit——截断流，使其元素不超过给定数量。
		skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
		distinct——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
	 */

    //内部迭代：迭代操作 Stream API 内部完成
    @Test
    public void test2() {
        //所有的中间操作不会做任何的处理
        Stream<Employee> stream = emps.stream()
                .filter((e) -> {
                    System.out.println("测试中间操作");
                    return e.getAge() <= 35;
                });

        //只有当做终止操作时，所有的中间操作会一次性的全部执行，称为“惰性求值”
        stream.forEach(System.out::println);
    }

    //外部迭代
    @Test
    public void test3() {
        Iterator<Employee> it = emps.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    /**
     * 根据id排序?
     */
    @Test
    public void test4() {
        emps.stream()
                .filter((e) -> {
                    System.out.println("短路！"); // &&  ||
                    return e.getSalary() >= 5000;
                })
                .limit(3)
                .forEach(System.out::println);
    }

    /**
     * 根据id排序?
     */
    @Test
    public void test5() {
        emps.parallelStream()
                .filter((e) -> e.getSalary() >= 5000)
                .skip(2)
                .forEach(System.out::println);
    }

    @Test
    public void test6() {
        emps.stream()
                .distinct()
                .forEach(System.out::println);
    }
}
