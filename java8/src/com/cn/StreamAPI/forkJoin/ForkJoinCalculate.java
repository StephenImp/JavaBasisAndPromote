package com.cn.StreamAPI.forkJoin;

import java.util.concurrent.RecursiveTask;

/**
 * Recursive(递归)
 *
 * RecursiveTask 有返回值
 * RecursiveAction 没有返回值
 */
public class ForkJoinCalculate extends RecursiveTask<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 13475679780L;
	
	private long start;
	private long end;

	/**
	 * 任务拆分的最大数量
	 */
	private static final long THRESHOLD = 10000L; //临界值
	
	public ForkJoinCalculate(long start, long end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	protected Long compute() {
		long length = end - start;//

		/**
		 * 当长度到达临界值，则开始计算
		 */
		if(length <= THRESHOLD){
			long sum = 0;
			
			for (long i = start; i <= end; i++) {
				sum += i;
			}
			
			return sum;
		}else{
			/**
			 * 将任务不停的拆分，并将该子任务压入线程队列
			 * 直到任务数达到临界值
			 */

			long middle = (start + end) / 2;
			
			ForkJoinCalculate left = new ForkJoinCalculate(start, middle);
			left.fork(); //拆分，并将该子任务压入线程队列
			
			ForkJoinCalculate right = new ForkJoinCalculate(middle+1, end);
			right.fork();
			
			return left.join() + right.join();
		}
		
	}

}
