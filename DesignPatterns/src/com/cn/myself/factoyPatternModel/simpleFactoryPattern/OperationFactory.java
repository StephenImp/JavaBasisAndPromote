package com.cn.myself.factoyPatternModel.simpleFactoryPattern;

public class OperationFactory {

    public static Operation createOperation(String operation) {
        Operation oper = null;
        switch (operation) {
            case "+":
                oper = new CalculatorAdd();
                break;
            case "-":
                oper = new CalculatorSub();
                break;
            case "*":
                oper = new CalculatorMul();
                break;
            case "/":
                oper = new CalculatorDiv();
                break;
        }
        return oper;
    }
}
