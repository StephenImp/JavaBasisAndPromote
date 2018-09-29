package com.cn.gubao.base.interfaceFilter.impl;

import com.cn.gubao.base.entity.Apple;
import com.cn.gubao.base.interfaceFilter.IAppleFilter;

/**
 * Created by admin on 2018/8/14.
 */
public class AppleFilterByWeightColor implements IAppleFilter<Apple>{


    @Override
    public boolean obtainApple(Apple apple) {
        return apple.getWeight()>100;
    }
}
