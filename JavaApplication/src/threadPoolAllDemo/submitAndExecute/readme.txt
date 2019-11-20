1、接收的参数不一样

2、submit有返回值，而execute没有

    用到返回值的例子，比如说我有很多个做validation的task，
    我希望所有的task执行完，然后每个task告诉我它的执行结果，是成功还是失败，如果是失败，原因是什么。
    然后我就可以把所有失败的原因综合起来发给调用者。

    个人觉得cancel execution这个用处不大，很少有需要去取消执行的。
    而最大的用处应该是第二点。

3、submit方便Exception处理
    意思就是如果你在你的task里会抛出checked或者unchecked exception，
    而你又希望外面的调用者能够感知这些exception并做出及时的处理，那么就需要用到submit，
    通过捕获Future.get抛出的异常。
