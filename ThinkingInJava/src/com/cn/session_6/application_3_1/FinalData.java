package com.cn.session_6.application_3_1;

/**
 * f i n a l 数据
 */
public class FinalData {

    /**
     * 由于i1 和i2 都是具有final 属性的基本数据类型，并含有编译期的值，
     * 所以它们除了能作为编译期的常数使用外，在任何导入方式中也不会出现任何不同。
     * Static 强调它们只有一个；而final 表明它是一个常数。
     *
     * 注意对于含有固定初始化值（即编译期常数）的fianl static 基本数据类型，
     * 它们的名字根据规则要全部采用大写。
     */
    private final int i1 = 9;
    private static final int I2 = 99;
    public static final int I3 = 39;

    /**
     * Static 强调它们只有一个；而final 表明它是一个常数。
     * i4 的值是唯一的，但i5 的值不会由于创建了另一个FinalData 对象而发生改变。
     * 那是因为它的属性是static，而且在载入时初始化，而非每创建一个对象时初始化。
     */
    private final int i4 = (int) (Math.random() * 20);
    // i5在编译期间是未知的，所以它没有大写
    static final int i5 = (int) (Math.random() * 20);


    /**
     * 从v1 到v4 的变量向我们揭示出final 句柄的含义。
     *
     * 正如大家在main()中看到的那样，并不能认为由于v2属于final，所以就不能再改变它的值。
     * 然而，我们确实不能再将v2 绑定到一个新对象，因为它的属性是final。
     * 这便是final 对于一个句柄的确切含义。
     * 我们会发现同样的含义亦适用于数组，后者只不过是另一种类型的句柄而已。
     * 将句柄变成final 看起来似乎不如将基本数据类型变成final 那么有用。
     */
    Value v1 = new Value();
    final Value v2 = new Value();
    static final Value v3 = new Value();

    private final int[] a = {1, 2, 3, 4, 5, 6};

    public void print(String id) {
        System.out.println(
                id + ": " + "i4 = " + i4 +
                        ", i5 = " + i5);
    }

    public static void main(String[] args) {

        FinalData fd1 = new FinalData();
        // fd1.i1++; // Error: can't change value

        fd1.v2.i++; // Object isn't constant!
        fd1.v1 = new Value(); // OK -- not final
        for (int i = 0; i < fd1.a.length; i++) {
            fd1.a[i]++;
        }
        // Object isn't constant!

        //fd1.v2 = new Value(); // Error: Can't
        //fd1.v3 = new Value(); // change handle
        // fd1.a = new int[3];
        fd1.print("fd1");
        System.out.println("Creating new FinalData");
        FinalData fd2 = new FinalData();
        fd1.print("fd1");
        fd2.print("fd2");
    }
}

