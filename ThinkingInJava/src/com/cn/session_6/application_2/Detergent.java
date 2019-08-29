package com.cn.session_6.application_2;

/**
 * 子类调用重写父类的方法，只运行子类自己的方法
 */
public class Detergent extends Cleanser {

    @Override
    public void scrub(){
        append("Detergent.scrub--->");
        //super.scrub();
    }

    public void foam(){
        append("foam()");
    }

    public static void main(String[] args) {
        Detergent x = new Detergent();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        print(x);
        print("Testing base Class");
        Cleanser.main(args);
    }

}
