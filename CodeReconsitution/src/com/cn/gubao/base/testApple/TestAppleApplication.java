package com.cn.gubao.base.testApple;

import com.cn.gubao.base.application.FilterApples;
import com.cn.gubao.base.entity.Apple;
import com.cn.gubao.base.interfaceFilter.IAppleFilter;
import com.cn.gubao.base.interfaceFilter.impl.AppleFilterByWeightColor;
import com.cn.gubao.base.interfaceFilter.impl.BananaFilterByWeight;
import org.junit.Test;


/**
 * Created by admin on 2018/8/14.
 */
public class TestAppleApplication {

    /**
     * Object o  该如何使用？
     */
    @Test
    public void test5(){

        System.out.println(FilterApples.filterFruit(FilterApples.reposBanana, new IAppleFilter() {
            @Override
            public boolean obtainApple(Object o) {
                return false;
            }
        }));

        System.out.println( FilterApples.filterFruit(FilterApples.reposBanana,new BananaFilterByWeight()));

    }


//    @Test
//    public void test4A(){
//        System.out.println(FilterApples.filterApples(new IAppleFilter() {
//            @Override
//            public boolean obtainApple(Apple apple) {
//                return "red".equals(apple.getColor());
//            }
//        }));
//    }


    @Test
    public void test4(){
        System.out.println(FilterApples.filterApples(new AppleFilterByWeightColor()));
    }
}
