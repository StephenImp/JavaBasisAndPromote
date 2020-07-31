package com.cn.proxyModel.JDKProxy;

/**
 *  * 我们发现， $Proxy0继承了Proxy类，同时还实现了Person接口，
 *  * 而且重写了findLove（）等方法。
 *  * 在静态块中用反射查找到了目标对象的所有方法，而且保存了所有方法的引用，
 *  * 重写的方法用反射调用目标对象的方法。
 *
 *  这个看书吧，我懒得敲了
 */
public class GPProxy {
}
