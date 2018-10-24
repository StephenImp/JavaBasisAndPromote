package com.cn.strategyModel.strategy1;

import org.junit.Test;

/**
 * 策略模式①
 * 传入不同的子类，调用不同的子类方法。
 */
public class TestStrategyOne {

    @Test
    public void TestStrategy(){
        
        /*
         * 由于实例化不同的策略
         * 最终在调用context.ContextInterface()时
         * 所获得的结果就不尽相同
         *
         */

        Context context;
        
        context = new Context(new ConcreteStrategyA());
        context.ContextInterface();
        
        context = new Context(new ConcreteStrategyB());
        context.ContextInterface();
        
        context = new Context(new ConcreteStrategyC());
        context.ContextInterface();
        
    }
}
