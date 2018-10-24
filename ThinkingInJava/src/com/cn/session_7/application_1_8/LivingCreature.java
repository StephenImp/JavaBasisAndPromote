package com.cn.session_7.application_1_8;

/**
 * 生物
 */
public class LivingCreature {

    private Characteristic p = new Characteristic("is alive");

    LivingCreature(){
        System.out.println("LivingCreature");
    }

    @Override
    protected void finalize(){
        System.out.println("LivingCreature finalize");
        if(DoBaseFinalization.flag){
            try {
                super.finalize();
            } catch(Throwable t) {
            }
        }
    }
}
