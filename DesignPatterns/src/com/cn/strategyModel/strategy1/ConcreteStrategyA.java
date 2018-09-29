package com.cn.strategyModel.strategy1;

/**
 * 具体算法A
 */
public class ConcreteStrategyA extends Strategy {

    @Override
    public void AlgorithmInterface() {
        System.out.println("算法A实现");
    }
    
}
