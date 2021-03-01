package com.cn;

import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestFinal {

    private final Map<String, String> beanDefinitionMap = new ConcurrentHashMap<>(256);

    @Test
    public void testFinal(){

        beanDefinitionMap.put("test1","test1");

        //beanDefinitionMap = new ConcurrentHashMap<>(256);;

    }

}
