package com.cn.MultithReadingReturn;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by admin on 2018/6/14.
 */
public class CallableTest implements Callable {

    private String name ;
    public CallableTest(String name) {
        this.name = name;
    }

    @Override
    public Object call() throws Exception {
        System.out.println("call");
        TimeUnit.SECONDS.sleep(1);
        return name+"返回了东西";
    }
}
