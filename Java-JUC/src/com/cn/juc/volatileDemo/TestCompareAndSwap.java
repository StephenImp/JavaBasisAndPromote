package com.cn.juc.volatileDemo;

/*
 * 模拟 CAS 算法
 *
 * CAS操作：(CAS 算法是硬件对于并发操作的支持)
	①获取主存中的值
	②主存中的值与私有线程中的旧值进行比较
	③
		相同---返回新值
		不同---返回旧值
 */
public class TestCompareAndSwap {

	public static void main(String[] args) {
		final CompareAndSwap cas = new CompareAndSwap();

		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					/**
					 * 获取内存值
					 */
					int expectedValue = cas.get();
					/**
					 * 主存中的值与私有线程中的旧值进行比较
					 */
					boolean b = cas.compareAndSet(expectedValue, (int)(Math.random() * 101));
					System.out.println(b);
				}
			}).start();
		}

	}

}

class CompareAndSwap{
	private int value;

	//获取内存值
	public synchronized int get(){
		return value;
	}

	//比较
	public synchronized int compareAndSwap(int expectedValue, int newValue){
		int oldValue = value;

		if(oldValue == expectedValue){
			this.value = newValue;
		}

		return oldValue;
	}

	//设置
	public synchronized boolean compareAndSet(int expectedValue, int newValue){
		return expectedValue == compareAndSwap(expectedValue, newValue);
	}
}
