package com.cn.session_1between3.application_5;

public class EqualsMethod2 {
    /**
     * 如果在Value中重写equal方法，则结果为true.
     */

    public static void main(String[] args) {
       Value v1= new Value();
       Value v2= new Value();

       v1.i = v2.i = 100;
       System.out.println(v1.equals(v2));//false

    }
}

