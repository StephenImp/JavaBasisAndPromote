package com.cn.session_7.application_1_8;

/**
 * 两栖动物
 */
public class Amphibian extends Animal {

    private Characteristic p = new Characteristic("Can Live in water");
    

    Amphibian(){
        System.out.println("Amphibian()");
    }

    @Override
    protected void finalize(){
        System.out.println("Amphibian finalize");
        if(DoBaseFinalization.flag){
            try {
                super.finalize();
            } catch(Throwable t) {}
        }
    }
}
