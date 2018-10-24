package com.cn.gubao.base.interfaceFilter.impl;

import com.cn.gubao.base.entity.Banana;
import com.cn.gubao.base.interfaceFilter.IAppleFilter;

/**
 * Created by admin on 2018/8/16.
 */
public class BananaFilterByWeight implements IAppleFilter<Banana> {
    @Override
    public boolean obtainApple(Banana banana) {

        if(banana.getWeight()<100){
            return false;
        }
        return true;
    }
}
