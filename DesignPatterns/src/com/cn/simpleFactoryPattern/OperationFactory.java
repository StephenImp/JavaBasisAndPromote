package com.cn.simpleFactoryPattern;

public class OperationFactory {

    public static Operation createOperation(String opration) {
        Operation oper = null;
        switch (opration) {
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
