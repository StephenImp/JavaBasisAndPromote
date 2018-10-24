package com.cn.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MOZi on 2018/10/22.
 *
 * java 堆溢出
 * VM args:-Xms20m  -Xmx20m  -XX:+HeapDumpOnOutOfMemoryError
 *
 */
public class HeapOOM {

    static class OOMObject{

    }

    public static void main(String[] args) {

        List <OOMObject> list = new ArrayList<>();

        while (true){
            list.add(new OOMObject());
        }
    }
}
