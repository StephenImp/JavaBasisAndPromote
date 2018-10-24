package com.cn.session_8.application_1_2;

import org.junit.Test;

/**
 * Created by admin on 2018/8/3.
 *
 * break的作用是跳出当前循环块（for、while、do while）或程序块（switch）。
 * 在循环块中的作用是跳出当前正在循环的循环体。在程序块中的作用是中断和下一个case条件的比较。
 *
 *
 * continue用于结束循环体中其后语句的执行，并跳回循环程序块的开头执行下一次循环，而不是立刻循环体。
 */
public class TestContinueAndBreak {

    @Test
    public void testContinue() {

        String a[] = {"A","B","C","D","E","F"};

        /**
         * continue loop 跳到 loop 处(必须是一个循环)
         */
        loop:
        for(int i = 0;i<a.length;i++){

            boolean flag = true;

            while(flag){
                if(a[i].equals("C")){
                    continue loop;
                }else {
                    a[i] = "Z";
                    if(i == a.length-1){
                        break ;
                    }
                    flag = false;
                }
            }
        }

        for(String s:a){
            System.out.println(s);
        }

    }

}
