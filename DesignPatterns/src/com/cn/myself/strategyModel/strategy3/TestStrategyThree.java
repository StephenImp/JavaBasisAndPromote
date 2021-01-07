package com.cn.myself.strategyModel.strategy3;

import org.junit.Test;
/**
 * TestStrategyThree 与 TestStrategyTwo 不同的是
 * 选择使用工厂模式的时机不同罢了
 *
 *
 * 这里与工厂模式不同的是
 *   1）策略模式
 *   在TestStrategyThree中，根据不同的选择（type），new不同的实现类对象
 *   在上下文（CashContext）中根据传入的实现类对象，调用不同实现类的方法
 *   返回结果
 *
 *
 *   2)工厂模式
 *   在TestFactory中，传入类型（type）
 *   在CashFactory中，根据传入的类型，new不同的实现类对象
 *   是根据传入的类型，new一个新的实现类对象
 */
public class TestStrategyThree {

    double total = 0.0d;

    CashSuper cs;

    @Test
    public void Click() {

        CashContext cc = null;

        /**
         *  根据传入的类型选择相应的策略模式
         */
        String type = "正常收费";

        switch (type) {
            case "正常收费":
                cc = new CashContext(new CashNormal());
                break;
            case "满300返100":
                cc = new CashContext(new CashReturn("300", "100"));
                break;
            case "打8折":
                cc = new CashContext(new CashRebate("0.8"));
                break;
            default:
                break;
        }

        double totalPrices = 0d;

        /*
         * 通过对Context的GetResult方法的调用，
         * 可以得到收取费用的结果，让具体算法与客户进行了隔离 
         */
        totalPrices = cc.GetResult(500.0d);

        total = total + totalPrices;

        System.out.println(total);
    }
}
