package com.cn.juc.volatileDemo;

import java.util.concurrent.atomic.AtomicInteger;

/*
 * 一、i++ 的原子性问题：i++ 的操作实际上分为三个步骤“读-改-写”
 * 		  int i = 10;
 * 		  i = i++; //10
 * 
 * 		  int temp = i;
 * 		  i = i + 1;
 * 		  i = temp;
 *
 *		int j = 10;
		System.out.println(++j);//11
		System.out.println("j:"+j);//11
		System.out.println("j:"+j++);//11

		int j = 10;
		System.out.println("j:"+j);//10
		System.out.println("j:"+j++);//10
 *
 *
 * 二、原子变量：在 java.util.concurrent.atomic 包下提供了一些原子变量。
 * 		1. volatile 保证内存可见性
 * 		2.  CAS（Compare-And-Swap） 算法保证数据变量的原子性
 * 			CAS 算法是硬件对于并发操作的支持
 * 			CAS 包含了三个操作数：
 * 			①内存值  V
 * 			②预估值  A
 * 			③更新值  B
 * 			当且仅当 V == A 时， V = B; 否则，不会执行任何操作。
 */
public class TestAtomicDemo {

	public static void main(String[] args) {


		AtomicDemo ad = new AtomicDemo();
		
		for (int i = 0; i < 15; i++) {
			new Thread(ad).start();
		}
	}
	
}

class AtomicDemo implements Runnable{

	private  int serialNumber = 0;  //此时会有线程安全问题(原子性问题)

//	private volatile int serialNumber = 0;// volatile 并不能解决

	//private AtomicInteger serialNumber = new AtomicInteger(0);//解决原子性问题


	@Override
	public void run() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		
		System.out.println(Thread.currentThread().getName()+":"+getSerialNumber());
	}
	
	public int getSerialNumber(){
		//return serialNumber.getAndIncrement();
		return  serialNumber++;
	}

}
