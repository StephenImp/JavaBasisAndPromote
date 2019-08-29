package com.cn.session_1between3.application_7;

/**
 * 可变参数问题
 */
public class TestVarArgus {

    public static void dealArray(int... intArray){
        for (int i : intArray)  {
            System.out.print(i +" ");
        }
        System.out.println();
    }

    public static void main(String args[]){
        dealArray();
        dealArray(1);
        dealArray(1, 2, 3);

    }
}
