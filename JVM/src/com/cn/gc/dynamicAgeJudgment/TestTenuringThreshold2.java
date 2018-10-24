package com.cn.gc.dynamicAgeJudgment;

/**
 * Created by MOZi on 2018/10/22.
 *
 * 长期存活对象进入老年代
 *
 * VM args:-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX :SurvivorRatio=8 -XX:MaxTenuringThreshold=15
 * -XX:+PrintTenuringDistribution
 */
public class TestTenuringThreshold2 {

    private static final int _1MB = 1024*1024;

    public static void testTenuringThreshold(){

        byte[] allocation1,allocation2,allocation3,allocation4;

        allocation1 = new byte[_1MB/4];

        //allocation1+allocation2大于survivo空间的一半
        allocation2 = new byte[_1MB/4];
        allocation3 = new byte[4*_1MB];
        allocation4 = new byte[4*_1MB];
        allocation4 = null;
        allocation4 = new byte[4*_1MB];
    }

}
