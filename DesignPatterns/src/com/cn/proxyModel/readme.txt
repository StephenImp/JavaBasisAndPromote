https://www.cnblogs.com/gonjan-blog/p/6685611.html  代理模式

1.创建一个与代理对象相关联的InvocationHandler

2.创建一个代理对象，代理对象的每个执行方法都会替换执行Invocation中的invoke方法


代理类并不是真正实现服务，而是通过调用委托类（被代理的类）的对象的方法来实现服务