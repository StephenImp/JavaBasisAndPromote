package com.cn.gc;

import org.junit.Test;

/**
 * Created by MOZi on 2018/10/22.
 *
 * testGC()方法执行后，objA和objB会不会被GC回收。
 *
 * 引用计数算法的缺陷
 */
public class ReferenceCountingGC {

    public Object instance = null;

    private static final int _1MB = 1024*1024;

    /**
     *这个成员属性的唯一意义就是占点内存，以便能在GC日志中看清楚是否被回收过。
     */
    private byte[] bigSize = new byte[2*_1MB];

    @Test
    public void testGC(){

        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();

        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        //假设在这行发生GC，objA和objB是否能被回收
        System.gc();
    }
}
