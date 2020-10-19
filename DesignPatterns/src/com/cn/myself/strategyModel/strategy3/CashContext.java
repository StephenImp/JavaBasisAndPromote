package com.cn.myself.strategyModel.strategy3;

public class CashContext {

    /**
     * 声明一个CashSuper对象
     */
    private CashSuper cs;

    /**
     * 通过构造方法，传入具体的收费策略
     */
    public CashContext(CashSuper cashSuper) {
        this.cs = cashSuper;
    }

    public double GetResult(Double money) {

        //根据收费策略的不同，获得计算结果
        
        /**
         * 根据传入的策略不同，调用不同的策略中的方法
         */
        return cs.acceptCash(money);
    }

}
