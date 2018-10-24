package com.cn.oom;

import org.junit.Test;

/**
 * Created by MOZi on 2018/10/22.
 *
 * VM Args:-Xss128k       -Xss参数减少栈内内存容量。
 */
public class JavaJVMStackSOF {

    private int stackLength = 1;

    public void stackLeak(){

        stackLength++;
        stackLeak();
    }



    @Test
    public void test1(){

        JavaJVMStackSOF oom = new JavaJVMStackSOF();


        try {
            oom.stackLeak();
        }catch (Exception e){
            System.out.println("stack length:"+ oom.stackLength);
            e.printStackTrace();
        }
    }
}
