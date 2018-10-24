package com.cn.oom.intern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MOZi on 2018/10/22.
 */
public class TestIntern2 {

    public static void main(String[] args) {

        String str = "abc";
        char [] arry = {'a','b','c'};

        String str2 = new String(arry);

        //使用intern()将str2字符串放入常量池
        str2 = str2.intern();

        //这个比较用来说明字符串字面常量和我们使用intern处理后的字符串是在同一个地方
        System.out.println(str == str2);

        //那好，下面我们就拼命的intern吧
//        List<String> list = new ArrayList<String>();
//        for (int i = 0; i <10000000 ; i++) {
//            String temp = String.valueOf(i).intern();
//            list.add(temp);
//        }

    }
}
