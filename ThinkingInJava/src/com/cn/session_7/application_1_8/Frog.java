package com.cn.session_7.application_1_8;

/**
 * 继承和f i n a l i z e ( )
 * 青蛙
 */

public class Frog extends Amphibian {

    public Frog() {
        System.out.println("Forg()");
    }

    @Override
    protected void finalize() {
        System.out.println("Frog finalize");
        if (DoBaseFinalization.flag) {
            try {
                super.finalize();
            } catch (Throwable t) {
            }
        }

    }


    public static void main(String[] args) {
        if (args.length != 0 &&args[0].equals("finalize")) {
            DoBaseFinalization.flag = true;
        } else {
            System.out.println("not finalizing bases");
        }

        new Frog(); // Instantly becomes garbage
        System.out.println("bye!");
        // Must do this to guarantee that all
        // finalizers will be called:

        /**
         * 无论是否调用了基础类收尾模块，
         * Characteristic 成员对象都肯定会得到收尾（清除）处理。
         * System.runFinalizersOnExit(true)添加了额外的开销，以保证收尾工作的正常进行。
         */
        System.runFinalizersOnExit(true);
    }

    /**
     * 但假如在命令行加入“finalize”自变量，则会获得下述结果：
     Creating Characteristic is alive
     LivingCreature()
     Creating Characteristic has heart
     Animal()
     Creating Characteristic can live in water
     Amphibian()
     Frog()
     bye!
     Frog finalize
     Amphibian finalize
     Animal finalize
     LivingCreature finalize
     finalizing Characteristic is alive
     finalizing Characteristic has heart
     finalizing Characteristic can live in water

     收尾它与初始化顺序正好相反
     */
}
