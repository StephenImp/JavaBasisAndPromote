f i n a l 数据

    ①：在对这样的一个常数进行定义的时候，必须给出一个值。
        无论static 还是final 字段，都只能存储一个数据，而且不得改变。

    ②：若随同对象句柄使用final，而不是基本数据类型，它的含义就稍微让人有点儿迷糊了。
        对于基本数据类型，final 会将值变成一个常数；但对于对象句柄，final 会将句柄变成一个常数。
        进行声明时，必须将句柄初始化到一个具体的对象。而且永远不能将句柄变成指向另一个对象。
        然而，对象本身是可以修改的。

        Java对此未提供任何手段，可将一个对象直接变成一个常数（但是，我们可自己编写一个类，使其中的对象具有
        “常数”效果）。这一限制也适用于数组，它也属于对象。