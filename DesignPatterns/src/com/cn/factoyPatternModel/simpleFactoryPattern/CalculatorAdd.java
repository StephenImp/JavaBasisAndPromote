package com.cn.factoyPatternModel.simpleFactoryPattern;

public class CalculatorAdd extends Operation {

    @Override
    public double getResult() {
        double result = 0;
        
        result = super.getNumberA() + super.getNumberB();
        
        return result;
    }
}
