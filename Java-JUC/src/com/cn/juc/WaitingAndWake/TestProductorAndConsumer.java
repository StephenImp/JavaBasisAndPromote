package com.cn.juc.WaitingAndWake;


import java.util.LinkedList;
import java.util.Queue;

/*
 * 生产者和消费者案例
 *
 * 等待，唤醒机制
 */
public class TestProductorAndConsumer {

	public static void main(String[] args) {
		Clerk clerk = new Clerk();

		Productor pro = new Productor(clerk);
		ConsumerDemo cus = new ConsumerDemo(clerk);

		new Thread(pro, "生产者 A").start();
		new Thread(cus, "消费者 B").start();

		new Thread(pro, "生产者 C").start();
		new Thread(cus, "消费者 D").start();
	}

}

//店员
class Clerk{
	
	//Queue<Integer> product = new LinkedList<Integer>();
	private int product = 0;

	//进货
	public synchronized void get(){//循环次数：0

		/**
		 * 此方法会引起虚假唤醒问题 --->else
		 * sale()方法同理
		 *
		 * 当存在一个消费者，一个生产者时：
		 * 此时get()在等待中，但是却没有方法再去 唤醒它,
		 * 程序将不会结束
		 *
		 *
		 * 当存在多个消费者，多个生产者时：
		 * 虚假唤醒：
		 *
		 *
		 * api原文：在某一个版本中，中断和虚假唤醒是可能的，总是使用在循环中
		 */
		if(product>=1){
			System.out.println("产品已满！");

			try {
				this.wait();
			} catch (InterruptedException e) {
			}
		}else{
			System.out.println(Thread.currentThread().getName() + " : " + ++product);
			this.notifyAll();
		}

//		while(product >= 1){//为了避免虚假唤醒问题，应该总是使用在循环中
//			System.out.println("产品已满！");
//
//			try {
//				this.wait();
//			} catch (InterruptedException e) {
//			}
//
//		}
//
//		System.out.println(Thread.currentThread().getName() + " : " + ++product);
//		this.notifyAll();
	}

	//卖货
	public synchronized void sale(){//product = 0; 循环次数：0
		while(product <= 0){
			System.out.println("缺货！");

			try {
				this.wait();
			} catch (InterruptedException e) {
			}
		}

		System.out.println(Thread.currentThread().getName() + " : " + --product);
		this.notifyAll();
	}
}

//生产者线程
class Productor implements Runnable{
	private Clerk clerk;

	public Productor(Clerk clerk) {
		this.clerk = clerk;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}

			clerk.get();
		}
	}
}

//消费者线程
class ConsumerDemo implements Runnable{
	private Clerk clerk;

	public ConsumerDemo(Clerk clerk) {
		this.clerk = clerk;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			clerk.sale();
		}
	}
}
