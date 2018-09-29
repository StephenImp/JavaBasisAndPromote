package com.cn.session_7.application_1_6;

/**
 * 缺陷：“覆盖”私有方法。
 *
 * 如果基类的方法是私有的，子类虽然重写了，调用的还是基类的私有方法
 */
public class PrivateOverride {

    private void f(){
        System.out.println("PrivateOverride.private f()");
    }
    
    public static void main(String[] args) {

        PrivateOverride po = new Derived();
        po.f();
        
    }
}