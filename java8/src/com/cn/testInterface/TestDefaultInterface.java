package com.cn.testInterface;

public class TestDefaultInterface {
	
	public static void main(String[] args) {

		SubClass sc = new SubClass();
		System.out.println(sc.getName());

		System.out.println("******************************************************");
		
		MyInterface.show();
	}

}
