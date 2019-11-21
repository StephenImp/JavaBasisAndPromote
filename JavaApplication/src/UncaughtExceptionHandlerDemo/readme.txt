Thread 捕获异常   ---  caseTwo

1.java 1.5版本出现的 UncaughtExceptionHandler ,当线程由于未捕获异常突然终止时调用的处理程序的接口。

当一个线程由于未捕获异常即将终止时，
Java虚拟机将使用thread . getuncaughtexceptionhandler()查询线程的uncaughtException处理程序，
并调用处理程序的uncaughtException方法，将线程和异常作为参数传递。

如果一个线程没有显式地设置它的UncaughtExceptionHandler，
那么它的ThreadGroup对象就充当它的UncaughtExceptionHandler。

如果ThreadGroup对象没有处理异常的特殊要求，它可以将调用转发给默认的未捕获异常处理程序。

-------------------------------------------------------------------------------------------
ThreadPool  捕获线程池中的异常   ---  future,submit



ThreadGroup?

threadGroup通过把各个thread组织成树形结构，新的thread创建时会默认继承父线程组的优先级，
对于批量处理thread有更加细致的操作选择，满足用户更多的批量处理需求。



