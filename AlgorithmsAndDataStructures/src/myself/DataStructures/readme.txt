有序数组插入数据项太慢：
插入数据时，之后所有的数据项都要向后移一位


链表查询太慢：
插入和删除很快，只需要改变某一项的前后引用即可
但是查询的话必须从头开始，直到找到数据项为止


树：
既可以像有序数组那样快速查找，又可以像链表一样快速的插入和删除

因为java语言有垃圾自动收集机制，所以不需要非把节点本身删掉，
一旦java意识到程序不再与这个节点有联系，就会把它清楚出存储器

中序后继：
对于每一个节点来说，比该关键字值次高的节点是它的中序后继，简称为该节点的后继
https://blog.csdn.net/zhangbaoanhadoop/article/details/81059269

关于二叉树的前序、中序、后序三种遍历
https://blog.csdn.net/qq_33243189/article/details/80222629

二叉树搜索有一个很麻烦的问题：如果树中插入的数是随机数，则执行的效果很好
但是如果插入的是有序数据，速度就会特别的慢
因为当插入有序数据时，二叉树就是非平衡二叉树了。

哈希表：
如果不需要有序遍历数据，并且可以提前预测数据量的大小，那么哈希表在速度和易用性方面是无与伦比的

什么是hash算法：

每一个字符都有自己所对应的ASCII码。对应的ASCII码用幂的连乘来表示（如a 97-->9*10+9*1）--->hugeNumber。
hash化：arrzyIndex = hugeNumber%arraySize  以这样的形式将大数字范围化--->arrzyIndex (hash地址)

冲突：eg:单词hash化后，某些数组下标相同。

解决冲突:

    ①开放地址法:线性探测，二次探测和再hash法
         线性探测:eg:5421--->5422 (产生聚集--->hash落在聚集范围内的数据都要移动)  这里是原始聚集
         二次探测:eg:第一次：5421+1  第二次：5421+4  第三次：5421+9 。。。（步骤是步数的平方） 这里会产生二次聚集
         再hash法:解决原始聚集与二次聚集。

    ②链地址法：在hash表的每个单元中设置链表。(这里联系一下hashMap底层原理)





