package com.cn.StreamAPI.forkJoin;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

import org.junit.Test;

/**
 * 应用：eg:在网上不同的文章中找热搜关键词
 */
public class TestForkJoin {

	/**
	 * forkJoin框架
	 */
	@Test
	public void test1(){
		//long start = System.currentTimeMillis();
		Instant start = Instant.now();

		ForkJoinPool pool = new ForkJoinPool();
		ForkJoinTask<Long> task = new ForkJoinCalculate(0L, 20000000000L);

		//执行
		long sum = pool.invoke(task);
		System.out.println(sum);
		
		//long end = System.currentTimeMillis();
		Instant end = Instant.now();
		
		//System.out.println("耗费的时间为: " + (end - start)); //112-1953-1988-2654-2647-20663-113808
		System.out.println("耗费的时间为："+ Duration.between(start,end).toMillis());
	}

	/**
	 * 普通for
	 */
	@Test
	public void test2(){
		long start = System.currentTimeMillis();
		
		long sum = 0L;
		
		for (long i = 0L; i <= 20000000000L; i++) {
			sum += i;
		}
		
		System.out.println(sum);
		
		long end = System.currentTimeMillis();
		
		System.out.println("耗费的时间为: " + (end - start)); //34-3174-3132-4227-4223-31583
	}

	/**
	 * 比自己手写的forkJoin框架更高效。
	 */
	@Test
	public void test3(){

		System.out.println("方式①");
		long start = System.currentTimeMillis();

		/**
		 * rangeClosed生成一系列连续的数。
		 */
		Long sum = LongStream.rangeClosed(0L, 10000000000L)
							 .parallel()
							 .sum();
		
		System.out.println(sum);
		
		long end = System.currentTimeMillis();
		
		System.out.println("耗费的时间为: " + (end - start)); //2061-2053-2086-18926


		System.out.println("------------------------------------");

		System.out.println("方式②");

		long start1 = System.currentTimeMillis();

		LongStream.rangeClosed(0,10000000000L)
				   .parallel()
				   .reduce(0,Long::sum);

		long end1 = System.currentTimeMillis();

		System.out.println("耗费的时间为: " + (end1 - start1)); //2061-2053-2086-18926
	}

}
