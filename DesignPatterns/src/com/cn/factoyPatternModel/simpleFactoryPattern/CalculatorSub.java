package com.cn.factoyPatternModel.simpleFactoryPattern;

public class CalculatorSub extends Operation {
    @Override
    public double getResult() {
        double result = 0;
        result = super.getNumberA() - super.getNumberB();
        return result;
    }
}
