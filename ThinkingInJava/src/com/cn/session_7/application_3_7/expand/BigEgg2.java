package com.cn.session_7.application_3_7.expand;

/**
 * Created by admin on 2018/8/2.
 */
public class BigEgg2 extends Egg2 {

    public class Yolk extends Egg2.Yolk {
        public Yolk() {
            System.out.println("BigEgg2.Yolk()");
        }

        @Override
        public void f() {
            System.out.println("BigEgg2.Yolk.f()");
        }
    }

    public BigEgg2() {
        insertYolk(new Yolk());
    }

    public static void main(String[] args) {
        Egg2 e2 = new BigEgg2();

        /**
         *
             Egg2.Yolk()    基类的内部类构造器
             New Egg2()     基类构造器
             Egg2.Yolk()    基类的内部类构造器 ---> public BigEgg2() { insertYolk(new Yolk()); }-->重新又造了一个衍生类的Yolk。
             BigEgg2.Yolk() 衍生类的内部类的构造器
         */

       e2.g();
        /**
         *   BigEgg2.Yolk.f()
         */

        /**
         * 现在，BigEgg2.Yolk 明确地扩展了Egg2.Yolk，而且覆盖了它的方法。
         * 方法insertYolk()允许BigEgg2 将它自己的某个Yolk 对象上溯造型至Egg2 的y 句柄。
         * 所以当g()调用y.f()的时候，就会使用f()被覆盖版本。
         */

    }


}
