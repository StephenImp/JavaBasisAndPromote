面向对象：
    ①
    前期绑定:
    后期绑定:为了执行后期绑定，Java使用一小段特殊的代码来代替绝对地址调用，
             这段代码使用在对象中存储的信息来计算方法体的地址。

    ②
    向上转型

    ③
    单根继承（Object）

堆（这里指的并不是数据结构中的堆）

    JAVA虚拟机将运行时的数据分成了几大块:
    1、程序计数器，
    2、虚拟机栈，
    3、本地方法栈，
    4、方法区，
    5、堆，
    java堆一般就是指这个，这个堆里面存储的都是通过new关键字产生的对象
    这里就涉及到了JVM,这本书看完直接JVM。

    java完全采用了动态内存分配方式。每当想要创建新对象时，就要使用new关键字来构建此对象的动态实例

并发编程
    中断：
        中断是指计算机运行过程中，出现某些意外情况需主机干预时，
        机器能自动停止正在运行的程序并转入处理新情况的程序，处理完毕后又返回原被暂停的程序继续运行。

                       解决
     隐患：共享资源    ---->   锁。

