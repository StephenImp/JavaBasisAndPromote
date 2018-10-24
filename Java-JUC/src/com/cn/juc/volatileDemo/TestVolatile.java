package com.cn.juc.volatileDemo;

/*
 * 一、volatile 关键字：当多个线程进行操作共享数据时，可以保证内存中的数据可见。
 * 					  相较于 synchronized 是一种较为轻量级的同步策略。
 *
 * 					  volatile相当于把共享数据不在各自的缓存中去读写，而是放在主存中去进行操作
 * 
 * 注意：
 * 1. volatile 不具备“互斥性”--->		synchronized 一个线程在运行后，其他线程必须等待锁的释放
 * 2. volatile 不能保证变量的“原子性”
 *
 * 内存可见性：
 * jvm会为每一个执行任务的线程分配一个独立的缓存，用于提高效率
 * 线程中对数据的操作都是在缓存中执行的
 * 两个线程，各个缓存之间，数据是不可见的
 *
 */
public class TestVolatile {
	
	public static void main(String[] args) {
		ThreadDemo td = new ThreadDemo();
		new Thread(td).start();

		/**
		 * 如果不使用volatile关键字，
		 * 主线程读的flag为false
		 * 子线程却对flag作了修改。
		 *
		 * 自我总结：子线程內共享的数据，需要加volatile关键字
		 */
		while(true){
			if(td.isFlag()){
				System.out.println("------------------");
				break;
			}
		}
		
	}

}

class ThreadDemo implements Runnable {


	/**
	 * 这里不使用volatile关键字，效果出不来。
	 * flag是共享数据
	 */
	//private volatile boolean flag = false;
	private  boolean flag = false;

	@Override
	public void run() {
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
		}

		flag = true;
		
		System.out.println("flag=" + isFlag());

	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}