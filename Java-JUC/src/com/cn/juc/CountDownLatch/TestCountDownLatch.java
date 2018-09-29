package com.cn.juc.CountDownLatch;

import java.util.concurrent.CountDownLatch;

/*
 * CountDownLatch ：闭锁，在完成某些运算时，只有其他所有线程的运算全部完成，当前运算才继续执行
 *
 * 主线程执行到闭锁等待时，主线程等待，当持有闭锁的副线程释放闭锁时，主线程才能继续执行
 */
public class TestCountDownLatch {

	public static void main(String[] args) {
		/**
		 * 每次操作一个线程，
		 *  new CountDownLatch(50)
		 *  这个50都会递减1
		 *  当变量变为0时，主线程操作就可以继续执行了
		 */
		final CountDownLatch latch = new CountDownLatch(50);
		LatchDemo ld = new LatchDemo(latch);

		long start = System.currentTimeMillis();

		for (int i = 0; i < 50; i++) {
			new Thread(ld).start();
		}

		try {
			latch.await();//这里的 latch 与线程中的latch用的是同一个实例   这里等待是固定写法?
		} catch (InterruptedException e) {
		}

		long end = System.currentTimeMillis();

		System.out.println("耗费时间为：" + (end - start));
	}

}

class LatchDemo implements Runnable {

	private CountDownLatch latch;

	public LatchDemo(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {

		/**
		 * 这里加上同步锁？视频里加了，但是不加效果也出来了
		 */
//		synchronized (this){
//			try {
//				for (int i = 0; i < 50000; i++) {
//					if (i % 2 == 0) {
//						System.out.println(i);
//					}
//				}
//			} finally {
//				latch.countDown();//在这里，每次闭锁，递减1
//			}
//		}

		try {
			for (int i = 0; i < 50000; i++) {
				if (i % 2 == 0) {
					System.out.println(i);
				}
			}
		} finally {
			latch.countDown();//在这里，每次闭锁，递减1
		}

	}

}