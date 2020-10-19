package com.cn.myself.strategyModel.strategy2;

/**
 * 返利收费子类
 */
public class CashReturn extends CashSuper {
    
    private double moneyCondition = 0.0d;
    private double moneyReturn = 0.0d;

    /**
     * 构造方法，用来接收传来的参数
     */
    public CashReturn(String moneyCondition,String moneyReturn){
        this.moneyCondition = Double.parseDouble(moneyCondition);
        this.moneyReturn = Double.parseDouble(moneyReturn);
    }

    @Override
    public double acceptCash(double money) {
        double result = money;
        if(money>=moneyCondition){
            result = money - Math.floor(money/moneyCondition)*moneyReturn;
        }
        return result;
    }

}
