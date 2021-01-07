package com.cn.myself.factoyPatternModel.simpleFactoryPattern;

import org.junit.Test;

/**
 * 简单工厂模式
 */
public class TestDemo {

    @Test
    public void testSimpleFactoryPattern(){
        
        Operation oper;
        
        oper = OperationFactory.createOperation("+");
        oper.setNumberA(9);
        oper.setNumberB(1);
        
        double result = oper.getResult();
        
        System.out.println(result);
    }
   
}
