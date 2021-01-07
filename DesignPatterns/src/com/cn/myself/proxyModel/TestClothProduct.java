package com.cn.myself.proxyModel;

/**
 * 静态代理模式
 */

/**
 * 接口
 */
interface ClothFactory {
	void productCloth();
}

/**
 * 被代理类
 */
class NikeClothFactory implements ClothFactory {

	@Override
	public void productCloth() {
		System.out.println("Nike工厂生产一批衣服");
	}
}

/**
 * 代理类
 */
class ProxyFactory implements ClothFactory{
	ClothFactory cf;

	/**
	 * 创建代理类的对象时，实际传入的是一个被代理类的对象
	 * @param cf
	 */
	public ProxyFactory(ClothFactory cf){
		this.cf=cf;
	}

	@Override
	public void productCloth() {
		System.out.println("代理开始执行，收代理费￥1000");
		cf.productCloth();
	}

}

/**
 * 静态代理模式
 */
public class TestClothProduct {
	public static void main(String[] args) {

		//创建被代理类的对象
		NikeClothFactory nike = new NikeClothFactory();

		//创建代理类的对象
		ProxyFactory proxy = new ProxyFactory(nike);
		proxy.productCloth();
	}

}
