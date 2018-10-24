package com.cn.gubao.base.interfaceFilter.impl;

import com.cn.gubao.base.entity.Apple;
import com.cn.gubao.base.interfaceFilter.IAppleFilter;

/**
 * Created by admin on 2018/8/14.
 */
public class AppleFilterByGreenColor implements IAppleFilter<Apple>{


    @Override
    public boolean obtainApple(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
