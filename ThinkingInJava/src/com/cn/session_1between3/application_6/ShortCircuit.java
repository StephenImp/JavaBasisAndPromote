package com.cn.session_1between3.application_6;

import org.junit.Test;

/**
 * 
 ************************************************************
 * @类名 : ShortCircuit.java
 *
 * @DESCRIPTION : 當表達式中有一個返回為false，那麼後面將不會繼續執行，
 *                這就是短路
 * @AUTHOR :  admin
 * @DATE :  2017年9月21日
 ************************************************************
 */
public class ShortCircuit {
    
    static boolean test1(int val){
        
        System.out.println("test1("+val +")");
        
        System.out.println("result:"+(val<1));
        
        return val<1;
    }
    
    static boolean test2(int val){
        
        System.out.println("test2("+val +")");
        
        System.out.println("result:"+(val<2));
        
        return val<2;
    }

    static boolean test3(int val){
        
        System.out.println("test3("+val +")");
        
        System.out.println("result:"+(val<3));
        
        return val<3;
    }

    /**
     * 短路操作
     */
    @Test
    public void testOne(){

        if(test1(0)&&test2(2)&&test3(2)){
            System.out.println("expression is true");
        }else{
            System.out.println("expression is false");
        }
    }

    /**
     * 不会短路
     */
    @Test
    public void testTwo(){

        if(test1(0)&test2(2)&test3(2)){
            System.out.println("expression is true");
        }else{
            System.out.println("expression is false");
        }
    }

}
