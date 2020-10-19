package com.cn.myself.factoyPatternModel.simpleFactoryPattern;

public class CalculatorDiv extends Operation {

    @Override
    public double getResult() {
        double result = 0;
        if (super.getNumberB() == 0) {
            try {
                throw new Exception("除数不能为0");
            } catch (Exception e) {
            }
        } else {
            result = super.getNumberA() / super.getNumberB();
        }

        return result;
    }
}
