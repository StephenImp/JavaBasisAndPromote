package com.cn.myself.strategyModel.factory;

import org.junit.Test;

/**
 * 工厂模式
 * 根据不同的选择，创建不同的子类对象。
 */
public class TestFactory {

    double total = 0.0d;
    
    CashSuper cs;
    
    @Test
    public void Click(){

        //根据传入的类型，返回抽象类CashSuper下对应类型的实现类
        cs = CashFactory.createCashAccept("满300返100");
        
        double totalPrices = 0d;
        
        //调用实现类的方法
        totalPrices = cs.acceptCash(300);
        
        total = total + totalPrices;
        
        System.out.println(total);
    }
}
