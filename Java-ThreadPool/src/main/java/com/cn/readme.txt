
Java通过Executors提供四种线程池，分别为：

1、newCachedThreadPool：创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。（线程最大并发数不可控制）

2、newFixedThreadPool：创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。

3、newScheduledThreadPool：创建一个定长线程池，支持定时及周期性任务执行。

4、newSingleThreadExecutor：创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。



重点讲解：
其中比较容易让人误解的是：corePoolSize，maximumPoolSize，workQueue之间关系。

1.当线程池小于corePoolSize时，新提交任务将创建一个新线程执行任务，即使此时线程池中存在空闲线程。
2.当线程池达到corePoolSize时，新提交任务将被放入workQueue中，等待线程池中任务调度执行
3.当workQueue已满，且maximumPoolSize>corePoolSize时，新提交任务会创建新线程执行任务
4.当提交任务数超过maximumPoolSize时，新提交任务由RejectedExecutionHandler处理
5.当线程池中超过corePoolSize线程，空闲时间达到keepAliveTime时，关闭空闲线程
6.当设置allowCoreThreadTimeOut(true)时，线程池中corePoolSize线程空闲时间达到keepAliveTime也将关闭



那么学会使用ThreadPoolExecutor的参数后，我们就可以不用局限于最上面那四种线程池，可以按照需要来构建自己的线程池；


https://www.cnblogs.com/sharoncmt/p/7511126.html

https://blog.csdn.net/weixin_28760063/article/details/81266152