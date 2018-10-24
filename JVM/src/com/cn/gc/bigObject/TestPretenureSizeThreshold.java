package com.cn.gc.bigObject;

/**
 * Created by MOZi on 2018/10/22.
 * 大对象直接进入老年代
 *
 * VM Args:-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * -XX:PretenureSizeThreshold=3145728
 */
public class TestPretenureSizeThreshold {

    private static final int _1MB = 1024*1024;


    public static void testPretenureSizeThreshold(){
        byte[] allocation;
        allocation = new byte[_1MB];//直接分配在老年代中
    }
}
