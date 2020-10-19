package com.cn.myself.factoyPatternModel.simpleFactoryPattern;

abstract class Operation {

    private double numberA;
    private double numberB;

    abstract double getResult();

    public double getNumberA() {
        return numberA;
    }

    public void setNumberA(double numberA) {
        this.numberA = numberA;
    }

    public double getNumberB() {
        return numberB;
    }

    public void setNumberB(double numberB) {
        this.numberB = numberB;
    }

}
