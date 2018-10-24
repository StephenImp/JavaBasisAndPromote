package com.cn.oom;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MOZi on 2018/10/22.
 * VM Args:-XX:PermSize-10M -XX:MaxPermSize=10M
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {

        //使用List保持着常量池的引用，避免Full GC回首常量池行为
        List<String> list = new ArrayList<>();

        //10MB的PermSize在Integer范围内足够产生OOM了
        int i =0;
        while (true){
            list.add(String.valueOf(i++).intern());
        }

    }


}
