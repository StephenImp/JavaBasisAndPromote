package com.cn.strategyModel.strategy2;


import org.junit.Test;

/**
 * 策略模式与工厂模式的结合
 *
 * 区别：策略模式，通过上下文，根据不同的子类调用不同的方法
 *
 * 结合工厂模式，可以创建不同的子类对象。
 */
public class TestStrategyTwo {

    double total = 0.0d;


    @Test
    public void Click() {

        CashContext cc = new CashContext("正常收费");
        
        double totalPrices = 0d;

        totalPrices = cc.GetResult(500.0d);

        total = total + totalPrices;

        System.out.println(total);
    }
}
