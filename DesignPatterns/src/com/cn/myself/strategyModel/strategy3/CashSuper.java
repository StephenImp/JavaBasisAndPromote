package com.cn.myself.strategyModel.strategy3;

/**
 * 现金收费抽象类
 */
abstract class CashSuper {

    /**
     * 现金收取超类的抽象方法，收取现金，参数为原价，返回为当前价
     */
    public abstract double acceptCash(double money);
}
