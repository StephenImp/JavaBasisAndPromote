package com.cn.atguigu.DesignPattern.proxy.dynamic;

public class TeacherDao implements ITeacherDao {

	@Override
	public void teach() {
		// TODO Auto-generated method stub
		System.out.println(" ��ʦ�ڿ���.... ");
	}

	@Override
	public void sayHello(String name) {
		// TODO Auto-generated method stub
		System.out.println("hello " + name);
	}
	
}
