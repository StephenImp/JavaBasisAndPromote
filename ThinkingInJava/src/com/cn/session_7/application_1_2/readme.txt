绑定：
    将一个方法调用同一个方法主体连接到一起就称为“绑定”（Binding）。

前期绑定:
    若在程序运行以前执行绑定（由编译器和链接程序，如果有的话）

后期绑定:
    在运行期间判断对象 的类型，并分别调用适当的方法,
    也就是说，编译器此时依然不知道对象的类型，


    Java 中绑定的所有方法都采用后期绑定技术，除非一个方法已被声明成final。
    这意味着我们通常不必决定是否应进行后期绑定——它是自动发生的。



    为什么要把一个方法声明成final 呢？
    正如上一章指出的那样，它能防止其他人覆盖那个方法。
    但也许更重要的一点是，它可有效地“关闭”动态绑定，或者告诉编译器不需要进行动态绑定。
    这样一来，编译器就可为final 方法调用生成效率更高的代码。