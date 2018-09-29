package com.cn.session_11.application_1_3.Test;

import com.cn.session_11.application_1_3.Cat;
import com.cn.session_11.application_1_3.Pet;

/**
 * Created by admin on 2018/8/6.
 * 继承类也是同一类
 */
public class TestProblem {

    public static void main(String[] args) {

        Cat cat = new Cat();

        if(cat instanceof  Pet){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }
}
