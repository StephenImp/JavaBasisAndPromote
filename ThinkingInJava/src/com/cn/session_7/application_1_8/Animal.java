package com.cn.session_7.application_1_8;

public class Animal extends LivingCreature {

    private Characteristic p = new Characteristic("has heart");

    Animal(){
        System.out.println("Animal()");
    }

    @Override
    protected void finalize(){
        System.out.println("Animal finalize");
        if(DoBaseFinalization.flag){
                try {
                    super.finalize();
                } catch(Throwable t) {

                }

        }
    }
}
