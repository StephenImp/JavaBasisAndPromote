package com.cn.session_6.application_2_4;

public class Lisa extends Homer {
    
    /**
     * 使用override注解必须重写父类或者超类的方法
     * 否则只能是重载
     */
    //@Override
    void doh(Milhouse m){
        System.out.println("doh(Milhouse)");
    }


    /**
     * 重写
     */
    @Override
    char doh(char m){
        System.out.println("do(char)");
        return 'd';
    }

}
