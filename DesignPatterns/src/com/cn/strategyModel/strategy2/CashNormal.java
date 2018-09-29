package com.cn.strategyModel.strategy2;

/**
 * 正常收费，原价返回
 */
public class CashNormal extends CashSuper {
    @Override
    public double acceptCash(double money) {
        
        return money;
    }

}
